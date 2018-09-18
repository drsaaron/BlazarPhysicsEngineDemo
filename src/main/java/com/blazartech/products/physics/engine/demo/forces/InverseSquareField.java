/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blazartech.products.physics.engine.demo.forces;

import com.blazartech.products.physics.engine.Body;
import com.blazartech.products.physics.engine.Force;
import com.blazartech.products.physics.engine.Vector2D;

/**
 *
 * @author AAR1069
 * @version $Id$
 */

/*
$Log$
********************************************************************************/

public class InverseSquareField implements Force {

    private double gravitationalConstant;
    private double mass;

    public InverseSquareField(double constant, double mass) {
        this.gravitationalConstant = constant;
        this.mass = mass;
    }

    public Vector2D calculateAcceleration(Body body, long dt) {
        Vector2D currentPosition = body.getState().getPosition();
        double forceMagnitude = - gravitationalConstant * mass / (currentPosition.size() * currentPosition.size());
        double theta = Math.atan2(currentPosition.getY(), currentPosition.getX());
        Vector2D acceleration = new Vector2D(forceMagnitude * Math.cos(theta),
                                             forceMagnitude * Math.sin(theta));
        return acceleration;
    }

}
