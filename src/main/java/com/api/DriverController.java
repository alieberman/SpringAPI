/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aaronlieberman
 */
@RestController
public class DriverController {
    private static final String template = "%s";
    public final int counter = 1;
    
    @RequestMapping("/driver")
    public Driver driver(String name) {
        return new Driver(String.format(template, "Aaron"));
    }
}
