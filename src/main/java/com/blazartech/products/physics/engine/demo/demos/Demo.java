/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blazartech.products.physics.engine.demo.demos;

import com.blazartech.products.physics.engine.Body;
import com.blazartech.products.physics.engine.PhysicsEngine;
import com.blazartech.products.physics.engine.PhysicsEngineHelper;
import com.blazartech.products.physics.engine.PhysicsTimer;
import com.blazartech.products.physics.engine.Vector2D;
import com.blazartech.products.physics.engine.demo.gui.MainWindow;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author AAR1069
 * @version $Id$
 */

/*
$Log$
********************************************************************************/

public abstract class Demo {

    private PhysicsEngine engine;

    public PhysicsEngine getEngine() {
        return engine;
    }

    abstract protected void addBodies();
    abstract protected void addForces();

    abstract protected String getName();

    private static Logger logger = LoggerFactory.getLogger(Demo.class);

    public void runDemo(long dt, int maxIterations) {
        logger.info("Starting demo " + getName());

        engine = PhysicsEngineHelper.instance().getEngine();
        engine.removeAllBodies();
        engine.removeAllForces();

        logger.info("adding bodies.");
        addBodies();
        for (Body body : engine.getBodies()) {
            body.getState().addPropertyChangeListener(new PropertyChangeListener() {

                public void propertyChange(PropertyChangeEvent evt) {
                    if (evt.getPropertyName().equals("position")) {
                        Vector2D newPosition = (Vector2D) evt.getNewValue();
                        logger.info("position = " + newPosition.toString());
                    } else if (evt.getPropertyName().equals("velocity")) {
                        Vector2D newVelocity = (Vector2D) evt.getNewValue();
                        logger.debug("velocity = " + newVelocity);
                    }
                }

            });
        }

        logger.info("adding forces.");
        addForces();

        // setup the GUI.
        MainWindow demoWindow = new MainWindow();
        demoWindow.getDemoPanel().setBodies(engine.getBodies());
        demoWindow.getDemoPanel().setScaleFactor(5.);
        demoWindow.getDemoPanel().setCircleSize(20);
        demoWindow.setVisible(true);

        logger.info("running engine.");
        PhysicsTimer timer = PhysicsEngineHelper.instance().getTimer();
        timer.startEngine(engine, dt, maxIterations);
        demoWindow.showDemo();
    }

}