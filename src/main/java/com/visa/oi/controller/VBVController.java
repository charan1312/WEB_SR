package com.visa.oi.controller;

import com.visa.oi.model.Item;
import com.visa.oi.model.ItemHistory;
import com.visa.oi.service.AppService;
import com.visa.oi.service.ItemHistoryService;
import com.visa.oi.service.ItemService;
import com.visa.oi.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by caware on 12/19/2016.
 */

@Controller
@RequestMapping("/vbv")
public class VBVController{

    private static final Logger logger = LoggerFactory.getLogger(VBVController.class);

    @Autowired
    ItemService itemService;

    @Autowired
    AppService appService;

    @Autowired
    ItemHistoryService itemHistoryService;


    /*
    *   This method is used to get the list of active items for VBV application from the DB
    *
    */
    @RequestMapping(value="/vbvActive",method = RequestMethod.GET)
    public String getVBVActiveList(ModelMap model){
        logger.debug("getVBVActiveList(): is called");

        //Get the App ID for VBV application from the DB.  App : VBV and TableName : APP
        int appId = appService.getAppIdUsingDescription(HibernateUtil.vbvAppName);

        //Get the Items for the given appID and actInd from the DB table - Here App : VBV and ActiveIndicator : Active
        List<Item> vbvActiveItems = itemService.listActionItems(HibernateUtil.actInd,appId);
        logger.debug("Active Items for appId:" + appId + ",Count:" + vbvActiveItems.size());

        //This "item" Object is to read the new Action Item Entry in the UI Page
        model.addAttribute("item", new Item());

        //Adding the DB results to "model" Object to send it to the view
        model.addAttribute("vbvActiveItems",vbvActiveItems);

        //Return the view Object
        return "vbvactive";
    }


    /*
    *   This method is used to get the list of Completed Items for VBV application from the DB
    *
    */
    @RequestMapping(value="/vbvInActive",method = RequestMethod.GET)
    public String getVBVInActiveList(ModelMap model){
        logger.debug("getVBVInActiveList(): is called");

        //Get the App ID for VBV application from the DB.  App : VBV and TableName : APP
        int appId = appService.getAppIdUsingDescription(HibernateUtil.vbvAppName);

        //Get the Items for the given appID and actInd from the DB table - Here App : VBV and ActiveIndicator : InActive
        List<Item> vbvInActiveItems = itemService.listActionItems(HibernateUtil.inActInd,appId);
        logger.debug("Completed Items for appId:" + appId + ",Count:" + vbvInActiveItems.size());

        //This "item" Object is to read the new Action Item Entry in the UI Page
        model.addAttribute("item", new Item());

        //Adding the DB results to "model" Object to send it to the view
        model.addAttribute("vbvInActiveItems",vbvInActiveItems);

        //Return the view Object
        return "vbvinactive";
    }


    /*
    *   This method is used to add an active VBV item into the DB
    *
    */
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public String addVBVItem(@ModelAttribute("item") Item item, ModelMap model){

        logger.debug("addVBVItem(): is called");
        logger.info("Model Attribute (ITEM object) received thru Form is :" + item);

        //Get the App ID for VBV application from the DB and append it to the "Item" model Attribute : item
        int appId = appService.getAppIdUsingDescription(HibernateUtil.vbvAppName);
        item.setAppId(appId);

        //Since the Item is to be added, it must be active - Set the Active Indicator of Item as "Active"
        item.setActiveInd(HibernateUtil.actInd);

        //Sending the Item Object to the Service Class to add them to the DB
        itemService.addItem(item);

        //After adding the item to DB, redirecting to the current active list
        return "redirect:/vbv/vbvActive";
    }


    /*
    *   This method is used to list the history of updates for a particular Item from the DB
    *       We can also update an Active Item from here
    */
    @RequestMapping(value={"/history/{itemId}","/update/{itemId}"},method = RequestMethod.GET)
    public String VBVItemUpdateNHistory(@PathVariable int itemId,ModelMap model){
        logger.debug("VBVItemUpdateNHistory(): is called");

        //Get the Item that is selected (to update) or (to see the item history)
        Item item = this.itemService.getItemWithId(itemId);
        logger.debug("ITEM object using itemID:" + item);

        //Get the List of History of that Item
        List<ItemHistory> itemHistories = this.itemHistoryService.listItemHistoryUsingID(itemId);
        logger.debug("ITEM HISTORY size:" + itemHistories.size());

        model.addAttribute("allOlderUpdatesOfItem",itemHistories);

        //The condition is to check if the Item is ACTIVE OR INActive and return the corresponding VIEW page
        if(item.getActiveInd() == 1){
            //This item is for adding new Action Items - This item is a copy of the original ITEM fetched using Serial_No which we allow for modification
            Item newUpdate = this.itemService.copyItem(item);
            model.addAttribute("newUpdate", newUpdate);
            return "vbvactivehistory";
        }
        else {
            return "vbvinactivehistory";
        }
    }


    /**
     *  This method is used to add an entry into the ITEM HISTORY TABLE
     *  -
     */
    @RequestMapping(value="/history/add",method = RequestMethod.POST)
    public String updateHistory(@ModelAttribute("newUpdate") Item updatedItem,ModelMap model){
        logger.debug("updateHistory(): is called");

        logger.debug("Received Model attribute (ITEM Object) updatedItem:" + updatedItem);

        //Get the current properties of the RECEIVED Item object from the DB - Received Model attribute : updatedItem
        Item item = this.itemService.getItemWithId(updatedItem.getSerialNo());

        //Add this current Item to ITEM_HISTORY table before modifying the contents with the new updatedItem so that we can track the history
        // Copy the required fields from the above ITEM Object :item - into the ITEMHISTORY object : oldUpdate
        ItemHistory oldUpdate = this.itemHistoryService.copyReqFieldsFromItem(item);

        //Update the Last Modified TimeStamp of the : oldUpdate in ITEM HISTORY - and in : updatedItem in ITEM
        Timestamp cDate = new Timestamp(System.currentTimeMillis());
        oldUpdate.setLastModified(cDate);
        updatedItem.setLastModified(cDate);

        //Add this : oldUpdate to the DB(ITEM_HISTORY table)
        this.itemHistoryService.addHistoryToItem(oldUpdate);

        //Now add the New Update in the ITEM TABLE replacing the old value of the ITEM
        //NOTE THAT - updatedITem is not complete(all properties are not filled), it has only 3 fields -- So need to fill other fields USING : item Object

        //So, copying the fields from : item - into : updatedItem
        this.itemService.copyReqFieldsFromOneItemToAnother(item,updatedItem);
        logger.debug("ITEM object that is being updated: " + updatedItem.getSerialNo() + " and it new values being sent to DB:" + updatedItem);
        this.itemService.updateItem(updatedItem);

        //After adding the item to DB, redirecting to the current active list
        return "redirect:/vbv/vbvActive";
    }


    /*
    @RequestMapping(value="/update/{itemId}",method = RequestMethod.GET)
    public String updateVBVItem(@PathVariable int itemId,ModelMap model){
        logger.debug("updateVBVItem(): is called");


        //After updating the item to DB, displaying the current active list
        return "redirect:/vbv/vbvActive";
    }
    */


    /*
    *  To Mark any Item as complete we need to update the Active Indicator value of that ITEM to Inactive and then Make 2 DB updates -
    *       - Update ITEM HISTORY Table with the final ITEM object values
    *       - update ITEM Table for a particular ITEM - Its Active_Ind column must be updated
     */
    @RequestMapping(value="/markcomplete/{itemId}",method = RequestMethod.GET)
    public String markVBVItemComplete(@PathVariable int itemId,ModelMap model){
        logger.debug("markVBVItemComplete(): is called");

        //Get the Item to be marked as complete based on the itemID value - and update the Active indicator as : INACTIVE - HibernateUtil.inActInd
        Item itemToMarkComplete = this.itemService.getItemWithId(itemId);
        itemToMarkComplete.setActiveInd(HibernateUtil.inActInd);

        //To Make an entry in the ITEM HISTORY , get the final Item History entry from ITEM Object
        ItemHistory finalUpdate = this.itemHistoryService.copyReqFieldsFromItem(itemToMarkComplete);

        //Adding the finalUpdate to the ITEM HISTORY TABLE in DB
        this.itemHistoryService.addHistoryToItem(finalUpdate);

        //Update the ITEM Objects Active Indicator Value into the DB
        this.itemService.updateItem(itemToMarkComplete);

        //After updating the item to DB, redirecting to the current active list
        return "redirect:/vbv/vbvActive";
    }

}
