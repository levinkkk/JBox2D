/*
 * JBox2D - A Java Port of Erin Catto's Box2D
 * 
 * JBox2D homepage: http://jbox2d.sourceforge.net/
 * Box2D homepage: http://www.box2d.org
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

package org.jbox2d.common;

//Updated to rev. 142 of b2Settings.cpp/.h


/** Global tuning constants based on MKS units and various integer maximums (vertices per shape, pairs, etc.). */
public class Settings {

	/** A "close to zero" float epsilon value for use */
	public static final float EPSILON = 1.1920928955078125E-7f;

	/** Pi. */
	public static final float PI = (float) Math.PI;


	//###################
	//#### COLLISION ####
	//###################

	/**
	 * The maximum number of contact points between two convex shapes.
	 */
	public static final int maxManifoldPoints = 2;

	/**
	 * The maximum number of vertices on a convex polygon.
	 */
	public static final int maxPolygonVertices = 8;

	/**
	 * Factor used to fatten AABBs in b2DynamicTree. This allows client
	 * objects to move a small amount without needing to adjust the tree.
	 */
	public static final float fatAABBFactor = 1.5f;

	/**
	 * The initial pool size for the dynamic tree.
	 */
	public static final int nodePoolSize	= 50;

	/** Must be a power of two. */
	public static final int maxProxies = 512;

	/** Must be a power of two. */
	public static final int maxPairs = 8 * maxProxies;

	/**
	 * A small length used as a collision and constraint tolerance. Usually it is
	 * chosen to be numerically significant, but visually insignificant.
	 */
	public static final float linearSlop	= 0.005f;

	/**
	 * A small angle used as a collision and constraint tolerance. Usually it is
	 * chosen to be numerically significant, but visually insignificant.
	 */
	public static final float angularSlop = (2.0f / 180.0f * PI);

	/**
	 * The radius of the polygon/edge shape skin. This should not be modified. Making
	 * this smaller means polygons will have and insufficient for continuous collision.
	 * Making it larger may create artifacts for vertex collision.
	 */
	public static final float polygonRadius = (2.0f * PI);


	//##################
	//#### DYNAMICS ####
	//##################

	/**
	 * Maximum number of contacts to be handled to solve a TOI island.
	 */
	public static final int maxTOIContactsPerIsland = 32;

	/**
	 * Maximum number of joints to be handled to solve a TOI island.
	 */
	public static final int maxTOIJointsPerIsland = 32;

	/**
	 * A velocity threshold for elastic collisions. Any collision with a relative linear
	 * velocity below this threshold will be treated as inelastic.
	 */
	public static final float velocityThreshold = 1.0f;

	/**
	 *  The maximum linear position correction used when solving constraints. This helps to
	 * prevent overshoot.
	 */
	public static final float maxLinearCorrection = 0.2f;

	/**
	 * The maximum angular position correction used when solving constraints. This helps to
	 * prevent overshoot.
	 */
	public static final float maxAngularCorrection = (8.0f / 180.0f * PI);

	/**
	 *  The maximum linear velocity of a body. This limit is very large and is used
	 * to prevent numerical problems. You shouldn't need to adjust this.
	 */
	public static final float maxTranslation = 2.0f;
	public static final float maxTranslationSquared = (maxTranslation * maxTranslation);

	/**
	 *  The maximum angular velocity of a body. This limit is very large and is used
	 * to prevent numerical problems. You shouldn't need to adjust this.
	 */
	public static final float maxRotation = (0.5f * PI);
	public static final float maxRotationSquared = (maxRotation * maxRotation);

	/**
	 *  This scale factor controls how fast overlap is resolved. Ideally this would be 1 so
	 * that overlap is removed in one time step. However using values close to 1 often lead
	 * to overshoot.
	 */
	public static final float contactBaumgarte = 0.2f;

	//###################
	//###### SLEEP ######
	//###################

	/**
	 * The time that a body must be still before it will go to sleep.
	 */
	public static final float timeToSleep = 0.5f;

	/**
	 * A body cannot sleep if its linear velocity is above this tolerance.
	 */
	public static final float linearSleepTolerance = 0.01f;

	/**
	 * A body cannot sleep if its angular velocity is above this tolerance.
	 */
	public static final float angularSleepTolerance = (2.0f / 180.0f * PI);
}
