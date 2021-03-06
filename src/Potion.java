import java.lang.Math.*;


public class Potion{
	
	/*
	 * time is the number of steps a character can take until the potion runs off once it is used.
	 * effect is the randomly determined effect of the potion whether it be good or bad for the player.
	 * If effect = 1 the potion is a buff for the player. If effect = 1 it is a nerf for the player.
	 * stat is the randomly determined stat of the player that the potion will effect.
	 * The stat types and effect outcomes are saved in the final variables.
	 */
	
	public static final int BUFF = 1;
	public static final int NERF = 2;
	public static final int HEALTH = 1;
	public static final int ATTACK = 2;
	public static final int DEFENSE = 3;

	
	int time = 10;
	int effect,stat;
	boolean beingUsed = false;
	boolean statFound, effectFound;
	
	
	
	public Potion(){
		
		effect = this.determineEffect();
		effectFound = true;
		stat = this.determineStat();
		statFound = true;
	}
	
	public void use(){
		if(time>0){
			beingUsed = true;
		}
	}
	
	
	public void update(){
		
		if(this.isDone()){
			return;
		}
		else{
			time--;
		}

	}
	
	public int determineStat(){
		
		if(statFound==true){
			return stat;
		}
		
		double x = Math.random();
		if(x<=0.33){
			return HEALTH;
		}
		else if (x<=0.66){
			return ATTACK;
		}
		else
			return DEFENSE;
		

		
		
	}
	
	public int determineEffect(){
		
		if(effectFound==true){
			return effect;
		}
		
		double x = Math.random();
		if(x<=0.5){
			return BUFF;
		}
		else{
			return NERF;
		}
		
	}
	
	public boolean isDone(){
		
		if(time<=0){
			return true;
		}
		else return false;
		
	}
	
	public int timeLeft(){
		return time;
	}
	
	public boolean isBeingUsed(){
		return beingUsed;
	}

}
