/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blazartech.products.physics.engine.demo.demos;

import com.blazartech.products.physics.engine.Body;
import com.blazartech.products.physics.engine.Force;
import com.blazartech.products.physics.engine.Vector2D;
import com.blazartech.products.physics.engine.demo.forces.UniformVectorForce;

/**
 *
 * @author AAR1069
 * @version $Id$
 */

/*
$Log$
********************************************************************************/

public class DemoWithSimpleField extends DemoBase {

    @Override
    protected void addBodies() {
        Body body = new SimpleBody();
        body.getState().setMass(500);
        body.getState().setPosition(new Vector2D(0, 0));
        body.getState().setVelocity(new Vector2D(10, 0));
        getEngine().addBody(body);
    }

    @Override
    protected void addForces() {
        Force field = new UniformVectorForce(new Vector2D(0, -9.8));
        getEngine().addForce(field);
    }

    @Override
    protected String getName() {
        return "demo with simple vector field";
    }

}
