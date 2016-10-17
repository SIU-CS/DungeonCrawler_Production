package edu.siu.cs435;

import static org.junit.Assert.*;

import org.junit.Test;
import javax.swing.*;

public class ObstaclesTest {

	public static final int CELL_SIZE = 30;
    public static final int ROW_COUNT = 19;
    public static final int COL_COUNT = 17;
    public static final int centre = COL_COUNT/2;
    //public GameWindow gamePanel;
    
    public boolean _ = false;
    public boolean X = true;
    public boolean[][] walls = {{X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X},
                                 {X,_,_,_,_,_,_,_,X,_,_,_,_,_,_,_,X},
                                 {X,_,X,_,X,X,X,_,X,_,X,X,X,_,X,_,X},
                                 {X,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,X},
                                 {X,_,X,_,X,_,X,X,X,X,X,_,X,_,X,_,X},
                                 {X,_,_,_,X,_,_,_,X,_,_,_,X,_,_,_,X},
                                 {X,X,X,_,X,X,X,_,X,_,X,X,X,_,X,X,X},
                                 {X,X,X,_,X,_,_,_,_,_,_,_,X,_,X,X,X},
                                 {X,X,X,_,X,_,X,X,X,X,X,_,X,_,X,X,X},
                                 {X,_,_,_,_,_,X,X,X,X,X,_,_,_,_,_,X},
                                 {X,X,X,_,X,_,X,X,X,X,X,_,X,_,X,X,X},
                                 {X,X,X,_,X,_,_,_,_,_,_,_,X,_,X,X,X},
                                 {X,X,X,_,X,X,X,_,X,_,X,X,X,_,X,X,X},
                                 {X,_,_,_,X,_,_,_,X,_,_,_,X,_,_,_,X},
                                 {X,_,X,_,X,_,X,X,X,X,X,_,X,_,X,_,X},
                                 {X,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,X},
                                 {X,_,X,_,X,X,X,_,X,_,X,X,X,_,X,_,X},
                                 {X,_,_,_,_,_,_,_,X,_,_,_,_,_,_,_,X},
                                 {X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X}
                                };
	

    public boolean o = true;
	public boolean[][] itemmap = {{_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_},
            					   {_,o,o,o,o,o,o,o,_,o,o,o,o,o,o,o,_},
                                   {_,o,_,o,_,_,_,o,_,o,_,_,_,o,_,o,_},
                                   {_,o,o,o,o,o,o,o,o,o,o,o,o,o,o,o,_},
                                   {_,o,_,o,_,o,_,_,_,_,_,o,_,o,_,o,_},
                                   {_,o,o,o,_,o,o,o,_,o,o,o,_,o,o,o,_},
                                   {_,_,_,o,_,_,_,_,_,_,_,_,_,o,_,_,_},
                                   {_,_,_,o,_,_,_,_,_,_,_,_,_,o,_,_,_},
                                   {_,_,_,o,_,_,_,_,_,_,_,_,_,o,_,_,_},
                                   {_,_,_,o,_,_,_,_,_,_,_,_,_,o,_,_,_},
                                   {_,_,_,o,_,_,_,_,_,_,_,_,_,o,_,_,_},
                                   {_,_,_,o,_,_,_,_,_,_,_,_,_,o,_,_,_},
                                   {_,_,_,o,_,_,_,_,_,_,_,_,_,o,_,_,_},
                                   {_,o,o,o,_,o,o,o,_,o,o,o,_,o,o,o,_},
                                   {_,o,_,o,_,o,_,_,_,_,_,o,_,o,_,o,_},
                                   {_,o,o,o,o,o,o,o,o,o,o,o,o,o,o,o,_},
            		               {_,o,_,o,_,_,_,o,_,o,_,_,_,o,_,o,_},
            		               {_,o,o,o,o,o,o,o,_,o,o,o,o,o,o,o,_},
            		               {_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_}    
         						  };
	
	
		
	@Test
	public void testWalls() {
		
		boolean wall = false;
		
		if(X = true) {
	      wall = true;	
		}
		
		else 
			wall = false;
		
	}
	
  

	
	@Test
	public void testTrapDoors() {
		
		boolean trapDoor;
		
		if (o = true){
			trapDoor = true;			
		}
		else{
			trapDoor = false;
		}

	}
	
	
	
	
	@Test
	public void testSwingBlades() {
		
	}
	
	
	
	
	
	@Test
	public void testBombs() {
		
	}
	
	
	

}
