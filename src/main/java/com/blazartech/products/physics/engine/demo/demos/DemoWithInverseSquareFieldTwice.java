/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.products.physics.engine.demo.demos;

import com.blazartech.products.physics.engine.Vector2D;
import com.blazartech.products.physics.engine.demo.forces.InverseSquareField;
import org.springframework.stereotype.Component;

/**
 *
 * @author AAR1069
 */
@Component
public class DemoWithInverseSquareFieldTwice extends DemoWithInverseSquareField {

    
    @Override
    protected void addForces() {
        super.addForces();
        
        InverseSquareField field = new InverseSquareField(6.67e3 * 20000, new Vector2D(1000, 0));
        getEngine().addForce(field);
    }

    @Override
    protected String getName() {
        return "demo with two inverse square field";
    }
    
}
