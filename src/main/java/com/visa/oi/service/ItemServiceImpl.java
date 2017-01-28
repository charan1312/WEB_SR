package com.visa.oi.service;

import com.visa.oi.dao.ItemDAO;
import com.visa.oi.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by caware on 12/22/2016.
 */

@Service
public class ItemServiceImpl implements ItemService{

    private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemDAO itemDAO;

    /*
    public void setItemDAO(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }
    */

    @Transactional
    public List<Item> listActionItems(int activeInd, int appId) {
        logger.debug("listActionItems(): is called");
        return this.itemDAO.listActionItems(activeInd,appId);
    }

    @Transactional
    public void addItem(Item item) {
        logger.debug("addItem(): is called");

        Timestamp cDate = new Timestamp(System.currentTimeMillis());
        // All the Business Constraints regarding the Item object are checked before adding it to the DB
        //Item Objects Creation Date and Last updated Date cannot be null
        if( item.getCreationDate()==null ) {
            item.setCreationDate(cDate);
        }
        if( item.getLastModified()==null ) {
            item.setLastModified(cDate);
        }

        //Finally sending the Object to be persisted in the DB
        logger.debug("The Final ITEM object that will be persisted in DB is :" + item);
        this.itemDAO.addItem(item);
    }


    @Transactional
    public Item copyItem(Item item) {
        logger.debug("copyItem(): is called");
        Item copyOfItem = new Item();
        copyOfItem.setActiveInd(item.getActiveInd());
        copyOfItem.setCreationDate(item.getCreationDate());
        copyOfItem.setAppId(item.getAppId());
        copyOfItem.setSerialNo(item.getSerialNo());
        copyOfItem.setSummary(item.getSummary());
        copyOfItem.setDescription(item.getDescription());
        copyOfItem.setLastModified(item.getLastModified());

        logger.debug("The Final ITEM object that is copied and being returned is :" + copyOfItem);
        return copyOfItem;
    }

    @Transactional
    public Item copyReqFieldsFromOneItemToAnother(Item from,Item to){
        logger.debug("copyReqFieldsFromOneItemToAnother(): is called");
        if(to.getSerialNo() == 0) {
            to.setSerialNo(from.getSerialNo());
        }

        if(to.getActiveInd() == 0) {
            to.setActiveInd(from.getActiveInd());
        }
        if(to.getAppId() == 0) {
            to.setAppId(from.getAppId());
        }
        if(to.getCreationDate() == null) {
            to.setCreationDate(from.getCreationDate());
        }
        if(to.getSummary() == null) {
            to.setSummary(from.getSummary());
        }
        if(to.getDescription() == null) {
            to.setDescription(from.getDescription());
        }

        if(to.getLastModified() == null) {
            to.setLastModified(from.getLastModified());
        }

        return to;
    }

    @Transactional
    public Item getItemWithId(int itemNo){
        logger.debug("getItemWithId(): is called");
        logger.debug("ITEM Number:" + itemNo);
        return this.itemDAO.getItemWithId(itemNo);
    }


    @Transactional
    public void updateItem(Item item) {
        logger.debug("updateItem(): is called");
        this.itemDAO.updateItem(item);
    }

    @Transactional
    public Integer getCountForApp(int activeInd, int appId){
        logger.debug("getCountForApp(): is called");
        return this.itemDAO.getCountForApp(activeInd,appId);
    }

    @Transactional
    public Integer getTotalCount(int activeInd){
        logger.debug("getTotalCount(): is called");
        return this.itemDAO.getTotalCount(activeInd);
    }

}
