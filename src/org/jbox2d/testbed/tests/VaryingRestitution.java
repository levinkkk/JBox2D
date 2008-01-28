/*
 * JBox2D - A Java Port of Erin Catto's Box2D
 * 
 * JBox2D homepage: http://jbox2d.sourceforge.net/ 
 * Box2D homepage: http://www.gphysics.com
 * 
 * This software is provided 'as-is', without any express or implied
 * warranty.  In no event will the authors be held liable for any damages
 * arising from the use of this software.
 * 
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it
 * freely, subject to the following restrictions:
 * 
 * 1. The origin of this software must not be misrepresented; you must not
 * claim that you wrote the original software. If you use this software
 * in a product, an acknowledgment in the product documentation would be
 * appreciated but is not required.
 * 2. Altered source versions must be plainly marked as such, and must not be
 * misrepresented as being the original software.
 * 3. This notice may not be removed or altered from any source distribution.
 */
package org.jbox2d.testbed.tests;

import org.jbox2d.collision.BoxDef;
import org.jbox2d.collision.CircleDef;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;
import org.jbox2d.testbed.PTest;

import processing.core.PApplet;



public class VaryingRestitution extends PTest {

    public VaryingRestitution() {
        super("VaryingRestitution");
    }

    @Override
    public void go(World world) {
        {
            BoxDef sd = new BoxDef();
            sd.extents = new Vec2(50.0f, 10.0f);

            BodyDef bd = new BodyDef();
            bd.position = new Vec2(0.0f, -10.0f);
            bd.addShape(sd);
            world.createBody(bd);
        }

        {
            CircleDef sd = new CircleDef();
            ;
            // sd.poly.m_vertexCount = 8;
            sd.radius = .6f;
            sd.density = 5.0f;

            BodyDef bd = new BodyDef();
            bd.addShape(sd);

            float restitution[] = new float[] { 0.0f, 0.1f, 0.3f, 0.5f, 0.75f,
                    0.9f, 1.0f };

            for (int i = 0; i < restitution.length; ++i) {
                sd.restitution = restitution[i];
                bd.position = new Vec2(-10.0f + 3.0f * i, 10.0f);
                m_world.createBody(bd);
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main(new String[] { "org.jbox2d.testbed.tests.VaryingRestitution" });
    }
}
