package com.java.helloworld;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author aaronlieberman
 */
@RestController
public class hello {
    @RequestMapping("/")
    public String index() {
        return "Greetings sireeeeelll";
    }
}
