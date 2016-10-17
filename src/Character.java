
public class Character extends Attributes {
public Attributes Player;
public Attributes Skeleton;
public Attributes Ghost;
public Attributes Vampire;
public Attributes Golem;
public Attributes Zombie;
		
	public void CreatePlayerr(){
		 Player =  new Attributes();
	}
	public void CreateEnemy(){
		Skeleton = new Attributes();
		Ghost = new Attributes();
		Vampire = new Attributes();
		Golem = new Attributes();
		Zombie = new Attributes();
	}
	public void DestroyPlayer(){
		Player = null;
	}
	
	public void DestroyEnemy(){
			/*
				Class allows you to destroy enemy from a list or array of enemies
			 */
	}
	public void RaiseStats(){
		/*
		 * Class raises stats according to upgrades
		 */
	}
	public void CharacterPlace(){
		/*
			Class places characters on a map according to where they should go
		 */
	}
	public void moveCharacter(){
	/*
		Moves characters and enemies around map class.
	 */
	}
}
