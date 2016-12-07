import static org.junit.Assert.*;

import org.junit.Test;


public class WorldTest {

	@Test
	public void test() {
		World w1 = new World(100);
		assertEquals(true,w1.gameWon);
	}

}
