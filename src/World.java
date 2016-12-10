import javax.swing.*;

import java.util.Random;

public class World
{
    public static final int CELL_SIZE = 30;
    public static final int ROW_COUNT = 29;
    public static final int COL_COUNT = 23;
    public static final int centre = COL_COUNT/2;
    public static final int DOOR_X_COOR = 11;
    public static final int DOOR_Y_COOR = 0;
    public static final int ENEMY_X_COOR1=1;
    public static final int ENEMY_X_COOR2=21;
    public static final int ENEMY_Y_COOR1=1;
    public static final int ENEMY_Y_COOR2=13;
    public static final int ENEMY_Y_COOR3=24;
    public GameWindow gamePanel;
    public boolean isFighting = false;
    public Enemy genericEnemy;
    public boolean gameWon=false;
    
    private boolean i = false;
    private boolean X = true;
    private boolean[][] walls = {{X,X,X,X,X,X,X,X,X,X,X,i,X,X,X,X,X,X,X,X,X,X,X},
                                 {X,i,i,i,i,i,i,X,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
                                 {X,i,i,i,i,i,i,X,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
                                 {X,i,i,i,i,i,i,X,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
                                 {X,i,i,i,i,i,i,X,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
                                 {X,i,i,i,i,i,i,X,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
                                 {X,X,X,i,i,X,X,X,i,i,i,i,i,i,i,X,X,X,i,i,X,X,X},
                                 {X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
                                 {X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
                                 {X,X,X,X,X,X,X,X,i,i,i,i,i,i,i,X,X,X,X,X,X,X,X},
                                 {X,i,i,i,i,i,i,X,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
                                 {X,i,i,i,i,i,i,X,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
                                 {X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
                                 {X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
                                 {X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
                                 {X,i,i,i,i,i,i,X,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
                                 {X,i,i,i,i,i,i,X,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
                                 {X,X,X,X,X,X,X,X,i,i,i,i,i,i,i,X,X,X,X,X,X,X,X},
                                 {X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
                                 {X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
                                 {X,X,X,X,X,X,X,X,i,i,i,i,i,i,i,X,X,X,X,X,X,X,X},
                                 {X,i,i,i,i,i,i,X,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
                                 {X,i,i,i,i,i,i,X,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
                                 {X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
                                 {X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
                                 {X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
                                 {X,i,i,i,i,i,i,X,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
                                 {X,i,i,i,i,i,i,X,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
                                 {X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X}
                                };
    
    
    private boolean[][] walls2 = {{X,X,X,X,X,X,X,X,X,X,X,i,X,X,X,X,X,X,X,X,X,X,X},
    								{X,i,i,i,i,i,i,i,i,X,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,X,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,X,X,X,X,X,X,X,X,X,X,X,i,i,X},
    								{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X,i,i,X},
    								{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,i,i,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X},
    								{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,X,X,i,i,X,X,i,i,i,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,X,X,i,i,X,X,i,i,i,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X,X,X,X,X},
    								{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,X,X,X,X,X,X,X,X,X,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,X,X,X,X,X,X,X,X,X,X,X,i,i,X},
    								{X,i,i,i,i,i,i,i,i,X,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,i,i,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X},
    								{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,X,i,i,i,i,i,X,i,i,i,i,i,i,X},
    								{X,i,i,X,X,X,X,X,X,X,i,i,i,i,i,X,i,i,i,i,i,i,X},
    								{X,i,i,X,i,i,i,i,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
    								{X,i,i,X,i,i,i,i,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
    								{X,i,i,X,i,i,X,i,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
    								{X,i,i,X,i,i,X,i,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
    								{X,i,i,X,i,i,X,i,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
    								{X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X}
    							};
           
    private boolean[][] walls5 = {{X,X,X,X,X,X,X,X,X,X,X,i,X,X,X,X,X,X,X,X,X,X,X},
									{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
									{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
									{X,X,X,X,X,X,i,i,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X},
									{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
									{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
									{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
									{X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,i,i,X},
									{X,i,i,i,i,i,i,i,i,i,i,X,X,i,i,i,i,i,i,i,i,i,X},
									{X,i,i,i,i,i,i,X,X,i,i,X,X,i,i,i,i,i,i,i,i,i,X},
									{X,i,i,i,i,i,i,X,X,i,i,X,X,i,i,i,i,i,i,i,i,i,X},
									{X,i,i,i,i,i,i,X,X,i,i,i,i,i,i,i,i,i,X,X,X,X,X},
									{X,i,i,i,i,i,i,X,X,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
									{X,i,i,i,X,X,X,X,X,X,i,i,i,i,i,i,i,i,i,i,i,i,X},
									{X,i,i,i,i,i,i,i,i,X,X,X,X,X,X,X,X,X,X,X,X,X,X},
									{X,i,i,i,i,i,i,i,i,X,i,i,i,i,i,i,i,i,i,i,i,i,X},
									{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
									{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
									{X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,i,i,X},
									{X,i,i,i,i,i,i,i,i,X,i,i,i,i,i,i,i,X,i,i,i,i,X},
									{X,i,i,i,i,i,i,i,i,X,i,i,i,i,i,i,i,X,i,i,i,i,X},
									{X,i,i,i,i,i,i,i,i,X,i,i,i,i,i,i,i,X,i,i,i,i,X},
									{X,i,i,X,X,X,X,X,X,X,i,i,i,X,X,X,X,X,i,i,i,i,X},
									{X,i,i,X,i,i,i,i,i,i,i,i,i,X,i,i,i,i,i,i,i,i,X},
									{X,i,i,X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
									{X,i,i,i,i,i,X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
									{X,i,i,i,i,i,X,i,i,i,i,i,i,X,i,i,i,i,i,i,i,i,X},
									{X,i,i,X,i,i,X,i,i,i,i,i,i,X,i,i,i,i,i,i,i,i,X},
									{X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X}
									};
    private boolean[][] walls4 = {{X,X,X,X,X,X,X,X,X,X,X,i,X,X,X,X,X,X,X,X,X,X,X},
    								{X,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,X,i,i,i,i,i,X,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,i,X,i,i,i,i,X,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,i,X,i,i,i,i,X,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,i,X,i,i,i,i,X,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,i,X,i,i,i,i,X,i,i,i,i,i,i,X},
    								{X,X,X,X,i,i,X,X,X,X,X,i,i,i,i,X,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,i,X,i,i,i,i,X,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,i,X,X,X,X,X,X,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,X,X,X,X,X,X,i,i,i,i,i,i,i,i,i,i,X,X,X,X,X,X},
    								{X,i,i,i,i,i,i,X,i,i,i,i,i,i,i,i,X,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,X,i,i,i,i,i,i,X,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,X,i,i,i,i,X,i,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,i,X,i,i,X,i,i,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,X,i,i,i,i,X,X,X,i,i,X,X,X,X},
    								{X,i,i,i,i,i,i,i,X,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,X,X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,i,i,i,i,X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,i,i,i,X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,i,i,i,X,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,X},
    								{X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X}
									};
    private boolean[][] walls3 = {{X,X,X,X,X,X,X,X,X,X,X,i,X,X,X,X,X,X,X,X,X,X,X},
									{X,i,i,i,i,i,i,i,i,X,i,i,i,i,i,i,i,i,i,i,i,i,X},
									{X,i,i,i,i,i,i,i,i,X,i,i,i,i,i,i,i,i,i,i,i,i,X},
									{X,i,i,i,i,i,i,i,i,X,i,i,i,i,i,i,i,i,X,X,i,i,X},
									{X,i,i,i,i,i,X,i,i,X,i,i,i,i,i,i,i,i,X,X,i,i,X},
									{X,i,i,i,i,i,X,i,i,i,X,i,i,i,i,i,i,i,X,X,i,i,X},
									{X,i,i,i,i,i,X,i,i,i,i,X,i,i,i,i,i,i,X,X,i,i,X},
									{X,i,i,i,i,i,X,i,i,i,i,X,i,i,i,i,i,i,X,X,i,i,X},
									{X,i,i,i,i,i,X,i,i,i,i,X,i,i,i,i,i,i,X,X,i,i,X},
									{X,i,i,i,i,i,X,i,i,i,i,X,i,i,i,i,i,i,X,X,i,i,X},
									{X,i,i,i,i,i,X,i,i,i,i,X,i,i,i,i,i,i,X,X,i,i,X},
									{X,i,i,i,i,i,X,i,i,i,i,X,X,X,X,X,i,i,X,X,i,i,X},
									{X,i,i,i,i,i,X,i,i,i,i,i,i,i,i,X,i,i,X,X,i,i,X},
									{X,i,i,i,i,i,X,i,i,i,i,i,i,i,i,X,i,i,X,X,i,i,X},
									{X,i,i,i,i,i,X,i,i,i,i,i,i,i,i,X,i,i,X,X,i,i,X},
									{X,i,i,i,i,i,X,X,X,X,X,X,X,i,i,X,i,i,X,X,i,i,X},
									{X,i,i,i,i,i,X,i,i,i,i,i,i,i,i,X,i,i,X,X,i,i,X},
									{X,i,i,i,i,i,X,i,i,i,i,i,i,i,i,X,i,i,X,X,i,i,X},
									{X,i,i,i,i,i,X,i,i,X,X,X,X,X,X,X,i,i,X,X,i,i,X},
									{X,i,i,i,i,i,X,i,i,i,i,i,i,i,i,X,X,X,X,X,i,i,X},
									{X,i,i,i,i,i,X,i,i,i,i,i,i,i,i,i,i,X,X,X,i,i,X},
									{X,i,i,i,i,i,X,i,i,i,i,i,i,i,i,i,i,X,X,X,i,i,X},
									{X,i,i,i,i,i,X,X,X,X,X,X,X,X,X,i,i,X,X,X,i,i,X},
									{X,i,i,i,i,i,i,i,i,i,i,i,i,i,X,i,i,X,X,X,i,i,X},
									{X,i,i,i,i,i,i,i,i,i,i,i,i,i,X,i,i,X,X,X,i,i,X},
									{X,i,i,i,i,i,i,i,i,i,i,i,i,i,X,i,i,X,X,X,i,i,X},
									{X,i,i,i,i,i,i,i,i,i,i,i,i,i,X,i,i,i,i,i,i,i,X},
									{X,i,i,i,i,i,i,i,i,i,i,i,i,i,X,i,i,i,i,i,i,i,X},
									{X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X}
									};

                                
    private int floor;                        
    private Item[] items;
    private Enemy[] Enemys;
    private Player player;                           
    private GameWindow gameWindow;
    private int rng;
    private int numEnemies;


    public World(int x)
    {
    	Random rand = new Random();
        player = new Player(this, coordinate(centre), coordinate(26));
        floor = x;
        //Enemys = new Enemy[0];
        
        rng = rand.nextInt(100);
        if(floor<=25)
        {
        	if(rng<=75){
        		Enemys = new Enemy[1];
        		numEnemies = 1;
        		if(rng>=50)
        			player.setAttack(-5);
        	}
        	else if(rng>75){
        		Enemys = new Enemy[2];
        		numEnemies = 2;
        		player.setDefense(-5);
        	}
        }
        else if(floor>25&&floor<=50)
        {
        	if(rng<=50){
        		Enemys = new Enemy[1];
        		numEnemies = 1;
        		if(rng>=25)
        			player.setAttack(-1);
        	}
        	else if(rng>50&&rng<=75){
        		Enemys = new Enemy[2];
        		numEnemies = 2;
        		player.setDefense(-1);
        	}
        	else if(rng>75){
        		Enemys = new Enemy[3];
        		numEnemies = 3;
        		player.setAttack(-1);
        	}
        }
        else if(floor>50&&floor<=75)
        {
        	if(rng<=25){
        		Enemys = new Enemy[1];
        		numEnemies = 1;
        		player.setAttack(-1);
        	}
        	else if(rng>25&&rng<=50){
        		Enemys = new Enemy[2];
        		numEnemies = 2;
        		player.setDefense(-1);
        	}
        	else if(rng>50&&rng<=75){
        		Enemys = new Enemy[3];
        		numEnemies = 3;
        		player.setAttack(1);
        	}
        	else{
        		Enemys = new Enemy[4];
        		numEnemies = 4;
        		player.setDefense(1);
        	}
        }
        else if(floor>75&&floor<=100)
        {
        	if(rng<=25){
        		Enemys = new Enemy[2];
        		numEnemies = 2;
        		player.setAttack(1);
        	}
        	else if(rng>25&&rng<=50){
        		Enemys = new Enemy[3];
        		numEnemies = 3;
        		player.setDefense(1);
        	}
        	else if(rng>50&&rng<=75){
        		Enemys = new Enemy[4];
        		numEnemies = 4;
        		player.setAttack(2);
        	}
        	
        	else {
        		Enemys = new Enemy[5];
        		numEnemies = 5;
        		player.setDefense(2);
        	}
        }
        else if(floor>100)
        {
        	gameWon=true;
        	gameWindow.displayGameOver("YOU CLEARED THE DUNGEON");
        }
        
        int start = centre - this.floor/2;
        int randCoorX,randCoorY,xCoor,yCoor;
        for (int i=0; i<(numEnemies); i++)
        {
        	randCoorX = rand.nextInt(2);
        	if(randCoorX==1)
        	{
        		xCoor = ENEMY_X_COOR1;
        	}
        	else xCoor = ENEMY_X_COOR2;
        	
        	randCoorY = rand.nextInt(3);
        	if(randCoorY==1)
        	{
        		yCoor = ENEMY_Y_COOR1;
        	}
        	else if(randCoorY==2)
        	{
        		yCoor = ENEMY_Y_COOR2;
        	}
        	else yCoor = ENEMY_Y_COOR3;
        	
            Enemy Enemy = new Enemy(this, coordinate(xCoor), coordinate(yCoor));
            Enemys[i] = Enemy;
        }
        
        int k =  0;
        
    
        
        // Put all of your constructor code before this line.
        gameWindow = new GameWindow(this); // Keep this line.
        
    }
    
    public int coordinate(int rowcol)
    {
        return rowcol*CELL_SIZE + CELL_SIZE/2;
    }
    
    public boolean iAvailable()
    {
      return true;
    }

    public boolean play()
    {
    	gameWindow.displayGameOver("Floor " + floor); 
        // Here is an example of how to make the player turn down:
        while (player.isAlive() && iAvailable())
        { 
        	                  
           if(gameWindow.isPressed('s'))
           {
                player.turn(Direction.down);
                player.moveDown(player.getBody().getX(),player.getBody().getY(),walls);
                gameWindow.updateScreen();
                for (int i=0; i < numEnemies; i++)
                {
                    Enemys[i].autoMove();
                }
                gameWindow.updateScreen();
                gameWindow.sleep(250);
           }
           else if (gameWindow.isPressed('w'))
           {
                player.turn(Direction.up);
                player.moveUp(player.getBody().getX(),player.getBody().getY(),walls);
                gameWindow.updateScreen();
                for (int i=0; i < numEnemies; i++)
                {
                    Enemys[i].autoMove();
                }
                gameWindow.updateScreen();
                gameWindow.sleep(250);
           }
           else if (gameWindow.isPressed('a'))
           {
                player.turn(Direction.left);
                player.moveLeft(player.getBody().getX(),player.getBody().getY(),walls);
                gameWindow.updateScreen();
                for (int i=0; i < numEnemies; i++)
                {
                    Enemys[i].autoMove();
                }
                gameWindow.updateScreen();
                gameWindow.sleep(250);
           }
           else if (gameWindow.isPressed('d'))
           {
                player.turn(Direction.right);
                player.moveRight(player.getBody().getX(),player.getBody().getY(),walls);
                gameWindow.updateScreen();
                for (int i=0; i < numEnemies; i++)
                {
                    Enemys[i].autoMove();
                }
                gameWindow.updateScreen();
                gameWindow.sleep(250);
           }
           if (player.getBody().getX()/30==DOOR_X_COOR&&player.getBody().getY()/30==DOOR_Y_COOR){
        	   gameWindow.displayGameOver("FLOOR CLEARED!");   
        	   Enemys = new Enemy[0];
        	   numEnemies=0;
        	   gameWindow.setVisible(false);
        	   return true;
           }
        //player.move();
        gameWindow.updateScreen();
        }
        
        if(iAvailable()==false)
       {
          gameWindow.displayGameOver("WIN!");     
       }
       else if (player.isAlive()==false)
       {
          gameWindow.displayGameOver("YOU LOSE!"); 
          return false;
       }
       return false;
    }

    public Player getPlayer()
    {
        return player;
    }

    public Item[] getItems()
    {        
        return items;
    }
    
    public Enemy[] getEnemys()
    {
        return Enemys;
    }

    public boolean[][] getWalls()
    {
    	
    	if( floor%10 == 1 || floor%10==6){
    	return walls;	
    	}
    	else if( floor%10 == 2 || floor%10==7){
        	return walls2;	
        }
    	else if( floor%10 == 3 || floor%10==8){
        	return walls3;	
        }
    	else if( floor%10 == 4 || floor%10==9){
        	return walls4;	
        }
    	else if( floor%10 == 5 || floor%10==0){
        	return walls5;	
        }
    	
    	else 
    		return walls;
    }

    public Item getItemUnderPlayer()
    {
        
        return null; 
    }
    
    public int getFloor()
    {
    	return floor;
    }
    
    public Player getPlayerUnderEnemy()
    {
        for(Enemy Enemy : Enemys)
        {
        	
            if(Enemy.getBody().intersects(player.getBody())){
            	if(Enemy.stillAlive()==true){
            		//Combat combat = new Combat(player,Enemys[i]);
            		genericEnemy = Enemy;
            		isFighting = true;
            		this.combat(Enemy);
            	}
            return player;
            }
        }
        return null; 
    }
    
    public Enemy getEnemy()
    {
    	return genericEnemy;
    }
    
    public void combat(Enemy a)
    {
    	double pAttack,pDefense,eAttack,eDefense;
    	pAttack=player.getAttack();
    	pDefense=player.getDefense();
    	eAttack=a.getAttack();
    	eDefense=a.getDefense();
    	
    	while(player.getHealth()>0&&a.getHealth()>0)
    	{
    		player.takeDamage((int)(5*(eAttack/pDefense)));
    		a.takeDamage((int)(5*(pAttack/eDefense)));
    		gameWindow.updateScreen();
    		gameWindow.sleep(1000);
    	}
    	

    }
    
    public boolean currentlyFighting()
    {
    	return isFighting;
    }
    
    public boolean bodyIntersectsWithWall(Body body)
    {
        int top = body.getY()-body.getRadius();
        int left = body.getX()-body.getRadius();
        int row = top/CELL_SIZE;
        int col = left/CELL_SIZE;
        int rowSpan = top % CELL_SIZE == 0 ? 1 : 2;
        int colSpan = left % CELL_SIZE == 0 ? 1 : 2;
        for (int i = 0; i < rowSpan; i++)
            for (int j = 0; j < colSpan; j++)
                if (wallAt(row+i, col+j))
                    return true;
        return false;
    }
    private boolean wallAt(int row, int col)
    { return row >= 0 && col >= 0 && row < ROW_COUNT && col < COL_COUNT && getWalls()[row][col]; }
    public int getWidth()
    { return CELL_SIZE * COL_COUNT; }
    public int getHeight()
    { return CELL_SIZE * ROW_COUNT; }    
}
