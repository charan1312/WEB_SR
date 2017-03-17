package com.visa.oi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by caware on 12/19/2016.
 */


@Controller
@RequestMapping("/tpcas")
public class TPCASController{

    private static final Logger logger = LoggerFactory.getLogger(TPCASController.class);

    private String tpcasController = "TPCAS Controller";

    @RequestMapping(value="/tpcasActive",method = RequestMethod.GET)
    public String getTPCASActiveList(ModelMap model){
        model.addAttribute("tpcasController",tpcasController);
        return "tpcasactive";
    }


    @RequestMapping(value="/tpcasInActive",method = RequestMethod.GET)
    public String getTPCASInActiveList(ModelMap model){
        model.addAttribute("tpcasController",tpcasController);
        return "tpcasinactive";
    }
}

