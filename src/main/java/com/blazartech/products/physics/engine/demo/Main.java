/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.products.physics.engine.demo;

import com.blazartech.products.physics.engine.demo.demos.Demo;
import com.blazartech.products.physics.engine.demo.demos.DemoWithInverseSquareField;

/**
 *
 * @author AAR1069
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Demo demo = new DemoWithSimpleField();
//        demo.runDemo(100, 100);

        Demo demo = new DemoWithInverseSquareField();
        demo.runDemo(100, 365);
    }
}
