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

public class UniformVectorForce implements Force {

    public UniformVectorForce(Vector2D field) {
        this.field = field;
    }

    private Vector2D field;

    public Vector2D calculateAcceleration(Body body, long dt) {
        return field;
    }

}
