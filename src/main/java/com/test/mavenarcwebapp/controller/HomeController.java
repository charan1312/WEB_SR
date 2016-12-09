package com.test.mavenarcwebapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by caware on 11/12/2016.
 */

@Controller
@RequestMapping("/hello")
public class HomeController {
    private static int counter = 0;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);



    @RequestMapping(method = RequestMethod.GET)
    public String getHello(ModelMap model){
        model.addAttribute("message","Hello from the HOMECONTROLLER");
        model.addAttribute("counter", ++counter);
        logger.debug("[Welcome] counter: {}" , counter);
        return "hello";
    }

    @RequestMapping(value = "/springmvcwithmavenwebapparc",method = RequestMethod.GET)
    public String getHelloHome() {
        return "test";
    }

    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public String getHelloName(@PathVariable String name,ModelMap model) {
        model.addAttribute("message", "Welcome " + name);
        model.addAttribute("counter",++counter);
        logger.debug("[Welcome Name] counter: {}" , counter);
        return "hello";
    }


}
