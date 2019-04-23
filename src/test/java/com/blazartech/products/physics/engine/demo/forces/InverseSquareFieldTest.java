/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.products.physics.engine.demo.forces;

import com.blazartech.products.physics.engine.Body;
import com.blazartech.products.physics.engine.Vector2D;
import com.blazartech.products.physics.engine.demo.demos.SimpleBody;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author AAR1069
 */
@RunWith(SpringRunner.class)
public class InverseSquareFieldTest {
    
    private static final Logger logger = LoggerFactory.getLogger(InverseSquareFieldTest.class);
    
    private static final double FIELD_CONSTANT = 10;
    private static final double MASS = 100;
    private static final Vector2D CENTER = new Vector2D(50, -50);
    
    @TestConfiguration
    static class InverseSquareFieldTestConfiguration {
        
        @Bean
        public InverseSquareField getInverseSquareField() {
            return new InverseSquareField(FIELD_CONSTANT, MASS, CENTER);
        }
    }
    
    @Autowired
    private InverseSquareField instance;
    
    public InverseSquareFieldTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        TEST_BODY.getState().setMass(TEST_MASS);
        TEST_BODY.getState().setPosition(TEST_BODY_INIITAL_POSITION);
        TEST_BODY.getState().setVelocity(TEST_BODY_INITIAL_VELOCITY);
    }
    
    @After
    public void tearDown() {
    }

    private static final Body TEST_BODY = new SimpleBody();
    private static final double TEST_MASS = 1;
    private static final Vector2D TEST_BODY_INIITAL_POSITION = new Vector2D(0, 0);
    private static final Vector2D TEST_BODY_INITIAL_VELOCITY = new Vector2D(0, 0);
    
    /**
     * Test of calculateAcceleration method, of class InverseSquareField.
     */
    @Test
    public void testCalculateAcceleration() {
        logger.info("calculateAcceleration");
        
        long dt = 1L;

        Vector2D expResult = new Vector2D(0.14142, -0.14142);
        Vector2D result = instance.calculateAcceleration(TEST_BODY, dt);
        assertEquals(expResult.getX(), result.getX(), 0.1);
        assertEquals(expResult.getY(), result.getY(), 0.1);
    }
    
}
