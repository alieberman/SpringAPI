/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api;

import org.jongo.MongoCollection;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.security.access.annotation.Secured;  
import org.springframework.security.core.userdetails.UserDetails;  
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;  
import java.util.Map;
/**
 *
 * @author aaronlieberman
 */
@RestController
public class ResourceController {
    @Autowired
    private MongoCollection User;

    //@Secured({"ADMIN"})
    @RequestMapping("/resource")
    public Map<String, Object> home(@AuthenticationPrincipal UserDetails userDetails) {
        Client client = User.findOne("{#: #}", Client.USERNAME, userDetails.getUsername()).as(Client.class);
        Map<String, Object> model = new HashMap<>();
        model.put("username", client.getUsername());
        model.put("password", client.getPassword());
        model.put("authorities", client.getRoles());
        return model;
    }
}
