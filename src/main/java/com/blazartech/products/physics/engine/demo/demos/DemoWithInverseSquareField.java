/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blazartech.products.physics.engine.demo.demos;

import com.blazartech.products.physics.engine.Body;
import com.blazartech.products.physics.engine.Vector2D;
import com.blazartech.products.physics.engine.demo.forces.InverseSquareField;

/**
 *
 * @author AAR1069
 * @version $Id$
 */

/*
$Log$
********************************************************************************/

public class DemoWithInverseSquareField extends DemoBase {

    @Override
    protected void addBodies() {
        Body body = new SimpleBody();
        body.getState().setMass(500);  // earth mass
        body.getState().setPosition(new Vector2D(1500, 0));
        body.getState().setVelocity(new Vector2D(125, 408));
        getEngine().addBody(body);

        Body body2 = new SimpleBody();
        body2.getState().setMass(100);
        body2.getState().setPosition(new Vector2D(125, 1000));
        body2.getState().setVelocity(new Vector2D(-508, 125));
        getEngine().addBody(body2);
    }

    @Override
    protected void addForces() {
        InverseSquareField field = new InverseSquareField(6.67e3 * 50000, new Vector2D(0, 0));
        getEngine().addForce(field);
    }

    @Override
    protected String getName() {
        return "demo with inverse square field";
    }

}
