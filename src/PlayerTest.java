import static org.junit.Assert.*;

import org.junit.Test;


public class PlayerTest {

	@Test
	public void test1() {
		World w1 = new World(1);
		Player p1 = new Player(w1,50,50);
		if(p1.getHealth()<=0)
		{
			assertEquals(false,p1.isAlive());
		}
	}

}
