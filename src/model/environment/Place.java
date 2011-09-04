/**
 * Place builded by user or predefined from some package
 * Container of some {@link Building} put inside and some {@link Creature} living here
 */
package model.environment;

import java.io.Serializable;
import java.util.ArrayList;

import model.DreamedElement;

public class Place extends DreamedElement{
	
	protected ArrayList<Place> nextTo;
	protected int nbExits;
	private static final int MAX_EXITS = 6;
	protected String idPlace;
	protected int width;
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return null;
	} 
	
	
	
}
