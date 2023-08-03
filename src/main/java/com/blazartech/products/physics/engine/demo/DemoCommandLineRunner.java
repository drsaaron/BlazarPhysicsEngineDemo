/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.products.physics.engine.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.blazartech.products.physics.engine.demo.demos.Demo;

/**
 *
 * @author AAR1069
 */
@Component
public class DemoCommandLineRunner implements CommandLineRunner {
    
    @Autowired
    private Demo demo;

    @Override
    public void run(String... args) throws Exception {
        demo.runDemo(100, 365);
    }
    
    
}
