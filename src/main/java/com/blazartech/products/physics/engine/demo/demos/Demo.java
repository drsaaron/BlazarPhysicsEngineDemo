/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.blazartech.products.physics.engine.demo.demos;

import com.blazartech.products.physics.engine.PhysicsEngine;

/**
 *
 * @author scott
 */
public interface Demo {

    PhysicsEngine getEngine();

    void runDemo(long dt, int maxIterations);
    
}
