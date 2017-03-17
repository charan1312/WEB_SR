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
@RequestMapping("/vdna")
public class VDNAController{

    private static final Logger logger = LoggerFactory.getLogger(VDNAController.class);

    private String vdnaController = "VDNA Controller";

    @RequestMapping(value="/vdnaActive",method = RequestMethod.GET)
    public String getVDNAActiveList(ModelMap model){
        model.addAttribute("vdnaController",vdnaController);
        return "vdnaactive";
    }


    @RequestMapping(value="/vdnaInActive",method = RequestMethod.GET)
    public String getVDNAInActiveList(ModelMap model){
        model.addAttribute("vdnaController",vdnaController);
        return "vdnainactive";
    }

}
