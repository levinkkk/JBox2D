package org.jbox2d.dynamics;

/**
 * This is an internal structure.
 *
 */
public class TimeStep {
	
	/** time step */
	public float dt;
	
	/** inverse time step (0 if dt == 0). */
	public float inv_dt;
	
	/** dt * inv_dt0 */
	public float dtRatio;
	
	public int velocityIterations;
	
	public int positionIterations;
	
	public boolean warmStarting;
}
