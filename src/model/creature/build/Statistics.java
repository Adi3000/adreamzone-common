package model.creature.build;

import org.adreamzone.common.engine.Engine;

public class Statistics {
	
	private static final int NB_STATS = 8;
	public static final int PROGRESSION = 0;
	public static final int PRODUCTIVITY = 1;
	public static final int HEALTH = 2;
	public static final int HUNGRY = 3;
	public static final int THIRSTY = 4;
	public static final int BRAVERY = 5;
	public static final int HAPPINESS = 6;
	public static final int AGGRESSIVITY = 7;
	
	public static int[] createBonusStart(int health,int hungry, int thristy, int bravery, int happiness, int aggressivity){
		int[] bonusStart = new int[NB_STATS];
		bonusStart[PROGRESSION] = 0;
		bonusStart[PRODUCTIVITY] = 0;
		bonusStart[HEALTH] = health;
		bonusStart[HUNGRY] = hungry;
		bonusStart[THIRSTY] = thristy;
		bonusStart[BRAVERY] = bravery;
		bonusStart[HAPPINESS] = happiness;
		bonusStart[AGGRESSIVITY] = aggressivity;
		return bonusStart;
	}
		
	private int[] stats;
	private float[] coeffStats;
	private int[] maxStats;
	private int[] bonusStart;
	private Creature owner;
	
	public Statistics(int[] bonusStart){
		coeffStats = new float[NB_STATS];
		stats = new int[NB_STATS];
		maxStats = new int[NB_STATS];
		this.bonusStart = bonusStart;
		this.stats[PROGRESSION] = 1;
		this.coeffStats[PROGRESSION] = 1;
		for(int idx = 1 ; idx < NB_STATS; idx++){
			coeffStats[idx] = (float)1.5;
			maxStats[idx] = getMaxStats(idx);
			stats[idx] = maxStats[idx];
		}
	}
	
	public Statistics(int[] bonusStart,float[] coeffStats){
		this(bonusStart);
		for(int idx = 1 ; idx < NB_STATS; idx++){
			coeffStats[idx] = (float)1.5;
			maxStats[idx] = getMaxStats(idx);
			stats[idx] = maxStats[idx];
		}
	}
	
	/** For debug only **/
	
	public Statistics(int[] bonusStart,int level){
		this(bonusStart);
		if(Engine.DEBUG_MODE)
			this.stats[PROGRESSION] = level;
	}

	public void setLevel(int lvl){
		if(Engine.DEBUG_MODE)
			this.stats[PROGRESSION] = lvl;
		rebuildStats();
	}
	
	public boolean rebuildStats(){
		for(int idx = 1 ; idx < NB_STATS; idx++){
			maxStats[idx] = getMaxStats(idx);
			stats[idx] = maxStats[idx];
		}
		return true;
	}
	
	private int getMaxStats(int idx){
		int max = stats[PROGRESSION]+bonusStart[idx];
		if(stats[PROGRESSION] <= 1) return bonusStart[idx];
		else return (int)(max*coeffStats[idx]);
	}
	
	/**
	 * Modify statistics
	 * @param idx indice du tableau des stats a modifier 
	 * @param value A ajouter a la statistique
	 * @return l'exces négatif ou positif de la modification
	 */
	private int setStats(int idx, int value){
		int bonus = 0;
		this.stats[idx] += value; 
		if(stats[idx] < 0){
			bonus = stats[idx];
			stats[idx] = 0;
		}else if(stats[idx] > getMaxStats(idx)){
			bonus  = stats[idx] - maxStats[idx];
			stats[idx] = maxStats[idx];
		}
		return bonus;
	}
	
	/**
	 * Add or remove some aggressivity
	 * @param aggressivity
	 */
	void setAggressivity(int aggressivity) {
		setStats(AGGRESSIVITY,aggressivity);
	}
	/**
	 * Add or remove happiness
	 * @param happiness
	 */
	void setHappiness(int happiness) {
		setStats(HAPPINESS,happiness);
	}
	
	/**
	 * Add or remove progression
	 * @param level
	 */
	void setProgression(int level) {
		setStats(PROGRESSION,level);
		rebuildStats();
	}
	
	/**
	 * Add or remove some hungry
	 * @param hungry
	 */
	void setHungry(int hungry) {
		setStats(HUNGRY,hungry);
	}
	
	/**
	 * Add or remove some health
	 * @param health
	 */
	void setHealth(int health) {
		setStats(HEALTH,health);
	}
	
	/**
	 * Add or remove some thirsty
	 * @param thirsty
	 */
	void setThirsty(int thirsty) {
		setStats(THIRSTY,thirsty);
	}
	
	public void setProductivity(int productivity) {
		setStats(PRODUCTIVITY,productivity);
	}

	public float getStats(int idx) {
		return stats[idx]/maxStats[idx];
	}
	
	public int getProgression(){
		return stats[PROGRESSION];
	}
	
	/*
	int getAggressivity() {
		return aggressivity;
	}
	
	float getHealth() {
		return health;
	}
	
	float getHappiness() {
		return happiness;
	}
	
	float getHungry() {
		return hungry;
	}
	
	CreatureType getType() {
		return type;
	}
	
	int getBravery() {
		return bravery;
	}

	public float getThirsty() {
		return thirsty;
	}

	public int getProductivity() {
		return productivity;
	}*/
		
	public String toString(){
		String s="";
		s += "progression : "+stats[PROGRESSION]+"/"+getMaxStats(PROGRESSION)+"\n";
		s += "health : " + 100* getStats(HEALTH) +"("+stats[HEALTH]+"/"+maxStats[HEALTH]+")\n";
		s += "hungry : " + 100* getStats(HUNGRY) +"("+stats[HUNGRY]+"/"+maxStats[HUNGRY]+")\n";
		s += "thirsty : " + 100* getStats(THIRSTY) +"("+stats[THIRSTY]+"/"+maxStats[THIRSTY]+")\n";
		s += "happiness : " + 100* getStats(HAPPINESS) +"("+stats[HAPPINESS]+"/"+maxStats[HAPPINESS]+")\n";
		s += "aggressivity : " + 100* getStats(AGGRESSIVITY) +"("+stats[AGGRESSIVITY]+"/"+maxStats[AGGRESSIVITY]+")\n";
		
		return s;
	}
	
}
