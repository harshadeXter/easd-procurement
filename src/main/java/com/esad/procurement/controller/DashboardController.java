package com.esad.procurement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class DashboardController {
    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "dashboard";
    }
}