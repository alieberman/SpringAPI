/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.helloworld;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author aaronlieberman
 */
@RestController
public class Driver {
    String driver;
    @RequestMapping("/Driver")
    public String setDriver() {
        driver = "Aaron";
        return "The driver is " + driver;
    }
    public String getDriver() {
        return driver;
    }
}