import java.awt.Color;
import java.util.Random;

public class Item {

    public static final int RADIUS = World.CELL_SIZE / 2;
    private static final Color[] colors = { Color.red, Color.pink, Color.cyan, Color.orange };
    private static int colorIdx = 0;

    private World world;
    private Body body;
    private Color color;
	
	public static final int ATTACK = 1;
	public static final int DEFENSE = 2;
	
	public int type,value;
	
	public Item(World world,int x)
	{
		Random rand = new Random();
		type = rand.nextInt(3);
		if(x<=25)
		{
			value=1;
		}
		else if(x<=50)
		{
			value=2;
		}
		else if(x<=75)
		{
			value=3;
		}
		else if(x<=100)
		{
			value=4;
		}
		
		if(type==1)
		{
			world.getPlayer().setAttack(value);
		}
		else if(type==2)
		{
			world.getPlayer().setDefense(value);
		}
	}
	
	
	
	
}
