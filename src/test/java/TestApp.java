/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author aaronlieberman
 */
public class TestApp {
    private static Driver driver;
    @BeforeClass
    public static void initDriver() {
        driver = new Driver("Aarons");
    }
    
    @Test
    public void testDriver() {
        //String driverRes = driver.sum(3, 4);
        String myDriver = driver.getName();
        assertEquals(myDriver, "Aarons");
    }
}
