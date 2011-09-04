/**
 * 
 */
package org.adreamzone.common.model;

import org.adreamzone.common.database.data.AbstractDataObject;
import org.adreamzone.common.model.users.User;


import net.phys2d.math.Vector2f;
import net.phys2d.raw.Body;

public abstract class DreamedElement extends AbstractDataObject{
	
	/**
	 * User in-game who will possess and manage this {@link DreamedElement}
	 */
	protected User owner;
	/**
	 * Name of the {@link DreamedElement}
	 */
	protected String name;
	/**
	 * User in-game who have created this {@link DreamedElement}, it must exist in DB, or point on a User with only a name
	 */
	protected User author;
	
	/**
	 * Will increase popularity and charism of the Element. Not really defined for the moment
	 * May have multiple instantiation of method to make the DreamedElement progress
	 * @param level none usage really defined
	 */
	//public abstract void progress(int level);
	/**
	 * Physic associated with this element.
	 */
	protected Body body;
	
	/**
	 * Set the velocity of the entity
	 * 
	 * @param x The x component of the velocity to apply
	 * @param y The y component of the velocity to apply
	 */
	public void setVelocity(float x, float y) {
		Vector2f vec = new Vector2f(body.getVelocity());
		vec.scale(-1);
		body.adjustVelocity(vec);
		body.adjustVelocity(new Vector2f(x,y));
	}
	
	/**
	 * Set the x coordinate of this entities position
	 * 
	 * @param x The new x coordinate 
	 */
	public void setX(float x) {
		body.setPosition(x, getY());
	}

	/**
	 * Set the y coordinate of this entities position
	 * 
	 * @param y The new y coordinate 
	 */
	public void setY(float y) {
		body.setPosition(getX(), y);
	}
	
	/**
	 * Set the position of this entity
	 * 
	 * @param x The new x coordinate 
	 * @param y The new y coordinate
	 */
	public void setPosition(float x, float y) {
		body.setPosition(x,y);
	}
	
	/**
	 * Get the x coordinate of this entity's position 
	 * 
	 * @return The x coordinate of this entity
	 */
	public float getX() {
		return body.getPosition().getX();
	}

	/**
	 * Get the y coordinate of this entity's position 
	 * 
	 * @return The y coordinate of this entity
	 */
	public float getY() {
		return body.getPosition().getY();
	}

	/**
	 * Get the x component of the velocity of this entity
	 * 
	 * @return The x component of the velocity of this entity
	 */
	public float getVelX() {
		return body.getVelocity().getX();
	}

	/**
	 * Get the y component of the velocity of this entity
	 * 
	 * @return The y component of the velocity of this entity
	 */
	public float getVelY() {
		return body.getVelocity().getY();
	}

}
