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

    private final double gravitationalConstant;
    private final Vector2D center;

    public InverseSquareField(double constant, Vector2D center) {
        this.gravitationalConstant = constant;
        this.center = center;
    }

    @Override
    public Vector2D calculateAcceleration(Body body, long dt) {
        Vector2D currentPosition = body.getState().getPosition();
        Vector2D relativePosition = currentPosition.subtract(center);
        
        double forceMagnitude = - gravitationalConstant / (relativePosition.size() * relativePosition.size());
        double theta = Math.atan2(relativePosition.getY(), relativePosition.getX());
        Vector2D acceleration = new Vector2D(forceMagnitude * Math.cos(theta),
                                             forceMagnitude * Math.sin(theta));
        return acceleration;
    }

}
