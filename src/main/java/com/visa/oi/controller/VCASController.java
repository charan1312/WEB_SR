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
@RequestMapping("/vcas")
public class VCASController{

    private static final Logger logger = LoggerFactory.getLogger(VCASController.class);

    private String vcasController = "VCAS Controller";

    @RequestMapping(value="/vcasActive",method = RequestMethod.GET)
    public String getVCASActiveList(ModelMap model){
        model.addAttribute("vcasController",vcasController);
        return "vcasactive";
    }


    @RequestMapping(value="/vcasInActive",method = RequestMethod.GET)
    public String getVCASInActiveList(ModelMap model){
        model.addAttribute("vcasController",vcasController);
        return "vcasinactive";
    }

}