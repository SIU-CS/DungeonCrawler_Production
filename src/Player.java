
public class Player
{
    public static final int RADIUS = World.CELL_SIZE / 2;

    private World world;
    private Body body;
    private boolean alive;
    private int hp, attack, defense;

    public Player(World world, int x, int y)
    {
        this.world = world;
        body = new Body(world, x, y, RADIUS);
        alive = true;
        hp = 50;
        attack = 8;
        defense =8;
    }

    public boolean isAlive() { return alive; }
    public Body getBody() { return body; }
    public Direction getDirection() { return body.getDirection(); }

    public void turn(Direction direction)
    {
        body.turn(direction);
    }

    public void move()
    {
        Item item;
        item = world.getItemUnderPlayer();
        if(item != null)
        {
            eat(item);
        }
        // This is the normal speed of a player
        body.move(4);
    }
    public void moveDown(int x, int y, boolean[][] walls)
    {
        Item item;
        item = world.getItemUnderPlayer();
        if(item != null)
        {
            eat(item);
        }
        // This is the normal speed of a player
        //if(walls[x][y+1])
        body.move(30);
    }
    public void moveUp(int x, int y, boolean[][] walls)
    {
        Item item;
        item = world.getItemUnderPlayer();
        if(item != null)
        {
            eat(item);
        }
        // This is the normal speed of a player
        //if(walls[x][y-1])
        body.move(30);
    }
    public void moveLeft(int x, int y, boolean[][] walls)
    {
        Item item;
        item = world.getItemUnderPlayer();
        if(item != null)
        {
            eat(item);
        }
        // This is the normal speed of a player
        //if(walls[x-1][y])
        body.move(30);
    }
    public void moveRight(int x, int y, boolean[][] walls)
    {
        Item item;
        item = world.getItemUnderPlayer();
        if(item != null)
        {
            eat(item);
        }
        // This is the normal speed of a player
       // if(walls[x+1][y])
        body.move(30);
    }

    public void eat(Item item)
    {
        
    }

    public void die()
    {
        alive = false;
    }
    
    public int getAttack()
    {
    	return attack;
    }
    
    public int getDefense()
    {
    	return defense;
    }
    public void setAttack(int x)
    {
    	attack+=x;
    }
    
    public void setDefense(int x)
    {
    	defense+=x;
    }
    
    public void takeDamage(int dmg)
    {
    	hp-=dmg;
    	if(hp<=0)
    	{
    		this.die();
    	}
    }
    
    public int getHealth()
    {
    	return hp;
    }
    

}
