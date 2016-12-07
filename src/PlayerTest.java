import static org.junit.Assert.*;

import org.junit.Test;


public class PlayerTest {

	@Test
	public void test() {
		World w1 = new World(1);
		Player p1 = w1.getPlayer();
		if(p1.getHealth()==0)
		{
			assertEquals(p1.isAlive(),false);
		}
	}

}
