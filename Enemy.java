import java.awt.Color;

public class Enemy
{
    public static final int RADIUS = World.CELL_SIZE / 2;
    private static final Color[] colors = { Color.red, Color.pink, Color.cyan, Color.orange };
    private static int colorIdx = 0;

    private World world;
    private Body body;
    private Color color;
    private Direction direction;
    
    private boolean isAlive = true;
    
    private int hp, attack, defense;

    public Enemy(World world, int x, int y)
    {
        this.world = world;
        body = new Body(world, x, y, RADIUS);
        direction=Direction.random();
        body.turn(direction);
        color = colors[colorIdx++ % colors.length];
        hp = 10;
        attack = 5;
        defense = 5;
    }

    public Body getBody() { return body; }
    public Color getColor() { return color; }

    public void autoMove()
    {
    	
        Player player;
        //Direction direction;
        
        player = world.getPlayerUnderEnemy();
        if(player != null)
        {
            eat(player);
        }
        
        //preventing 180 turn

            Direction newDirection=Direction.random();
            direction=newDirection;
            
            

        body.turn(direction);
        /*direction = direction.random();
        if(world.walls != null)
        {
            body.canMove(direction);
        }*/
        // This is the normal speed of a Enemy
        if(isAlive==true){
            body.move(30);
        }
    }

    private void eat(Player player)
    {
        player.die();
    }
    
    public int getAttack()
    {
    	return attack;
    }
    
    public int getDefense()
    {
    	return defense;
    }
    
    public void takeDamage(int dmg)
    {
    	hp-=dmg;
    	if(hp<=0)
    	{
    		isAlive=false;
    	}
    }
    
    public boolean stillAlive()
    {
    	return isAlive;
    }
    
    public int getHealth()
    {
    	return hp;
    }
}
