package edu.siu.cs435;

//import static org.junit.Assert.*;

import org.junit.Test;
//import javax.swing.*;
//import java.util.Random;

public class ObstaclesTest {

	public static final int CELL_SIZE = 30;
    public static final int ROW_COUNT = 19;
    public static final int COL_COUNT = 17;
    public static final int centre = COL_COUNT/2;
    //public GameWindow gamePanel;
    //private static final Random random = new Random();
    
    public boolean _ = false;
    public boolean X = true;
    public boolean[][] walls = { {X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X},
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
		
		
		//if(walls[4][3]) {
		if(walls[4][4]){
		
	      
	      System.out.println("This is a Wall!!!!");
		}
		
		else {
		
			System.out.println("This is walk space, put any obsticle here");
		}
		
	}
	
  

	
	@Test
	public void testTrapDoors() {
		
		
		//if (itemmap[2][2]){
		if(itemmap[1][1]){
			
			System.out.println("Trapdoor is an Option");
			
		}
		else{
			
			System.out.println("Can't put a trap door here");
		}

	}
	
	
	
	
	@Test
	public void testSwingBlades() {
		
	 
		//if (itemmap[5][4]){		
		if (itemmap[5][2]){
			System.out.println("Swingblade can be planted");
		}
		else {
			System.out.println("Position occupied, no swingblades");
		}
	}
	
	
		
	
	@Test
	public void testBombs() {
		
		
		  //if (itemmap[2][2]){
		  if(itemmap[1][1]){
					
					System.out.println("Can plant bomb");
					
				}
				else{
					
					System.out.println("Can't plant bomb here!!!");
				}

		
	}
	
	@Test
	public void testDisease(){
		
		
		//if (itemmap[2][2]){
		  if(itemmap[6][1]){
					
					System.out.println("Can catch a disease");
					
				}
				else{
					
					System.out.println("You are safe from illness");
				}
		
	}
	

}
