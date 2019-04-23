/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blazartech.products.physics.engine.demo.demos;

import com.blazartech.products.physics.engine.PhysicsEngine;
import com.blazartech.products.physics.engine.Vector2D;
import com.blazartech.products.physics.engine.demo.gui.MainWindow;
import com.blazartech.products.physics.engine.timer.PhysicsTimer;
import java.beans.PropertyChangeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author AAR1069
 * @version $Id$
 */

/*
$Log$
********************************************************************************/

public abstract class Demo {

    @Autowired
    private PhysicsEngine engine;

    public PhysicsEngine getEngine() {
        return engine;
    }

    abstract protected void addBodies();
    abstract protected void addForces();

    abstract protected String getName();

    private static final Logger logger = LoggerFactory.getLogger(Demo.class);

    public void runDemo(long dt, int maxIterations) {
        logger.info("Starting demo " + getName());

        engine.removeAllBodies();
        engine.removeAllForces();

        logger.info("adding bodies.");
        addBodies();
        engine.getBodies().forEach((body) -> {
            body.getState().addPropertyChangeListener((PropertyChangeEvent evt) -> {
                if (evt.getPropertyName().equals("position")) {
                    Vector2D newPosition = (Vector2D) evt.getNewValue();
                    logger.info("position = " + newPosition.toString());
                } else if (evt.getPropertyName().equals("velocity")) {
                    Vector2D newVelocity = (Vector2D) evt.getNewValue();
                    logger.debug("velocity = " + newVelocity);
                }
            });
        });

        logger.info("adding forces.");
        addForces();

        // setup the GUI.
        MainWindow demoWindow = new MainWindow();
        demoWindow.getDemoPanel().setBodies(engine.getBodies());
        demoWindow.getDemoPanel().setScaleFactor(5.);
        demoWindow.getDemoPanel().setCircleSize(20);
        demoWindow.setVisible(true);

        logger.info("running engine.");
        timer.startEngine(engine, dt, maxIterations);
        demoWindow.showDemo();
    }

    @Autowired
    private PhysicsTimer timer;
}
