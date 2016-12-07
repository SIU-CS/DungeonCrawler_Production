import static org.junit.Assert.*;

import org.junit.Test;


public class WorldTest {

	@Test
	public void test() {
		World w1 = new World(1);
		if(w1.getFloor()<100)
		{
			assertEquals(w1.gameWon,false);
		}
		else if(w1.getFloor()>=100)
		{
			assertEquals(w1.gameWon,true);
		}
		
	}

}
