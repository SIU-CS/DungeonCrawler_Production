
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
			Skeleton = null;
			Ghost = null;
			Vampire = null;
			Golem = null;
			Zombie = null;
	}
	public void RaiseStats(){
		/*
		 * Class raises stats according to upgrades
		 * Class raises individual attributes based on potions acquired on the map
		 */
	}
	public void CharacterPlace(){
		/*
		 * Class preloads characters on the map in a default spot, the beginning of the dungeon
		 * http://spritedatabase.net/
		 */
	}
	
	/*public void moveCharacter(){
	/*
	 * Sprites already created, moving functionality is working,
	 *  but the background functionality still has yet to be finished
	 *  Later in the code we can change the preloaded sprites
		Moves characters and enemies around map class.
	 */
}
