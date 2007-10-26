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
package collision;

import common.Settings;
import common.Vec2;

public class Manifold {
    public ContactPoint[] points;

    public Vec2 normal;

    public int pointCount;

    public Manifold() {
        points = new ContactPoint[Settings.maxManifoldPoints];
        for (int i = 0; i < Settings.maxManifoldPoints; i++) {
            points[i] = new ContactPoint();
        }
        normal = new Vec2();
        pointCount = 0;
    }

    public Manifold(Manifold other) {
        points = new ContactPoint[Settings.maxManifoldPoints];
        // FIXME? Need to check how C++ handles an implicit
        // copy of a Manifold, by copying the points array
        // or merely passing a pointer to it.
        System.arraycopy(other.points, 0, points, 0, other.points.length);
        // points = new ContactPoint[other.points.length];
        // for (int i=0; i<other.points.length; i++){
        // points[i] = new ContactPoint(other.points[i]);
        // }
        normal = other.normal.clone();
        pointCount = other.pointCount;// points.length;
    }
}
