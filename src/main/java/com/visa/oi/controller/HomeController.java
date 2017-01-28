package com.visa.oi.controller;

import com.visa.oi.model.App;
import com.visa.oi.service.AppService;
import com.visa.oi.service.ItemService;
import com.visa.oi.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caware on 11/12/2016.
 */

@Controller
@RequestMapping("/updates")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    AppService appService;

    @Autowired
    ItemService itemService;

    /**
     *  This method is to get all the List of Active Action Items of all the Applications from the DB and enlist them.
     *
     * */
    @RequestMapping(value="/active",method = RequestMethod.GET)
    public String getActiveAppList(ModelMap model){
        //counter++;
        logger.debug("getActiveAppList(): is called");

        //Get the Application List from the Database using AppService
        List<App> apps = this.appService.listAllApps();

        //Add the Active Item counts of Each App in a List - Using Active Indicator : HibernateUtil.inActInd
        ArrayList<Integer> appActiveCount = new ArrayList<Integer>(apps.size());
        int totalActiveCount = 0;
        for(int i =0;i < apps.size(); i++){
            appActiveCount.add(this.itemService.getCountForApp(HibernateUtil.actInd, apps.get(i).getAppId()));
            totalActiveCount+=appActiveCount.get(i);
        }

        //Add all the Required Objects to the "model" Attribute to send it to the VIEW jsp
        model.addAttribute("apps",apps);
        model.addAttribute("appActiveCount",appActiveCount);
        model.addAttribute("totalActiveCount",totalActiveCount);

        //Return the view Object
        return "active";
    }

    /**
     *  This method is to get all the List of Completed Action Items of all the Applications from the DB and enlist them.
     *
     */
    @RequestMapping(value="/inactive",method = RequestMethod.GET)
    public String getInActiveAppList(ModelMap model){
        //counter++;
        logger.debug("getInActiveAppList(): is called");

        //Get the Application List from the Database using AppService
        List<App> apps = this.appService.listAllApps();

        //Add the Completed Item counts of Each App in a List - Using Inactive Indicator : HibernateUtil.inActInd
        ArrayList<Integer> appCompletedCount = new ArrayList<Integer>(apps.size());
        int totalCompletedCount = 0;
        for(int i =0;i < apps.size(); i++){
            appCompletedCount.add(this.itemService.getCountForApp(HibernateUtil.inActInd, apps.get(i).getAppId()));
            totalCompletedCount+=appCompletedCount.get(i);
        }

        //Add all the Required Objects to the "model" Attribute to send it to the VIEW jsp
        model.addAttribute("apps",apps);
        model.addAttribute("appCompletedCount",appCompletedCount);
        model.addAttribute("totalCompletedCount",totalCompletedCount);

        //Return the view Object
        return "inactive";
    }

    /*
    @RequestMapping(value = "/springmvcwithmavenwebapparc",method = RequestMethod.GET)
    public String getHelloHome() {
        return "home";
    }

    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public String getHelloName(@PathVariable String name,ModelMap model) {
        model.addAttribute("message", "Welcome " + name);
        model.addAttribute("counter",++counter);
        logger.debug("[Welcome Name] counter: {}" , counter);
        return "inactive";
    }
    */

}
