/**
 * Some creature which will live in DreamZone
 */
package org.adreamzone.common.model.creature.build;

import java.io.Serializable;

import org.adreamzone.common.Position;
import org.adreamzone.common.model.DreamedElement;
import org.adreamzone.common.model.items.food.Drink;
import org.adreamzone.common.model.items.food.Drug;
import org.adreamzone.common.model.items.food.Food;


public class Creature extends DreamedElement{
	
	protected Statistics stats;
	protected int score;
	protected int charisme;
	protected String name;
	protected String idCreature;
	protected String idDesigner;
	protected Creature father;
	protected Position p;
	protected CreatureType type;
	
	public Creature(String name, String idCreature,Statistics stats){
		this.stats = stats;
	}
	//@Override
	public void progress(int level){
		stats.setProgression(level);
	}
	
	//Method which are use for everyday's creature behavior
	public float eatFood(Food f){
		stats.setHungry(f.getFoodPoints());
		return stats.getStats(Statistics.HUNGRY);
	}
	
	public float cure(Drug d){
		stats.setHealth(d.getHealthPoints());
		return stats.getStats(Statistics.HEALTH);
	}
	
	public float drink(Drink d){
		stats.setThirsty(d.getThirstyPoints());
		return stats.getStats(Statistics.THIRSTY);
	}
	
	//Not really defined at this stat
	public Statistics getStats() {
		return stats;
	}
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
