package tests;

import testbed.Test;
import collision.ShapeDescription;
import collision.ShapeType;

import common.Vec2;

import dynamics.Body;
import dynamics.BodyDescription;
import dynamics.World;
import dynamics.joints.RevoluteDescription;

public class Bridge extends Test {

    public Bridge() {
        super("Bridge");
    }

    public void init(World m_world) {
        ShapeDescription sd = new ShapeDescription(ShapeType.BOX_SHAPE);
        sd.box.m_extents = new Vec2(50.0f, 10.0f);

        BodyDescription bd = new BodyDescription();
        bd.position = new Vec2(0.0f, -10.0f);
        bd.addShape(sd);
        Body ground = m_world.CreateBody(bd);

        ShapeDescription sd2 = new ShapeDescription(ShapeType.BOX_SHAPE);
        sd2.box.m_extents = new Vec2(0.5f, 0.125f);
        sd2.density = 20.0f;
        sd2.friction = 0.2f;

        BodyDescription bd2 = new BodyDescription();
        bd2.addShape(sd2);

        RevoluteDescription jd = new RevoluteDescription();
        int numPlanks = 25;

        Body prevBody = ground;
        for (int i = 0; i < numPlanks; ++i) {
            bd.position = new Vec2(-15.5f + 1.25f * i, 5.0f);
            Body body = m_world.CreateBody(bd2);

            jd.anchorPoint = new Vec2(-16.125f + 1.25f * i, 5.0f);
            jd.body1 = prevBody;
            jd.body2 = body;
            m_world.CreateJoint(jd);

            prevBody = body;
        }

        jd.anchorPoint = new Vec2(-16.125f + 1.25f * numPlanks, 5.0f);
        jd.body1 = prevBody;
        jd.body2 = ground;
        m_world.CreateJoint(jd);
    }

    /**
     * Entry point
     */
    public static void main(String[] argv) {
        new Bridge().start();
    }
}
