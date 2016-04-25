/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.mongodb.DB;  
import com.mongodb.MongoClient;  
import com.mongodb.MongoException;  
import org.jongo.Jongo;  
import org.jongo.MongoCollection;
import org.springframework.context.annotation.Bean;
/**
 *
 * @author aaronlieberman
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    
//    @Configuration
//    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//      @Override
//      protected void configure(HttpSecurity http) throws Exception {
//        http
//          .httpBasic()
//        .and()
//          .authorizeRequests()
//            .antMatchers("/index.html", "/main.html", "/login.html", "/").permitAll()
//            .anyRequest().authenticated();
//      }
//    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Jongo jongo() {
        DB db;
        try {
            db = new MongoClient("127.0.0.1", 27017).getDB("bc-flashjoin");
        } catch (Exception e) {
            throw new MongoException("Connection error : ", e);
        }
        return new Jongo(db);
    }

    @Bean
    public MongoCollection users() {
        return jongo().getCollection("User");
    }
}
