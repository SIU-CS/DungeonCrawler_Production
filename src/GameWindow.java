import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class GameWindow extends JFrame
{
    private static final Random random = new Random();

    public static final int halfCycle = 4; // frames to open mouth
    public static final int openAngle = 90; // degrees

    private World world;
    private String gameOverMessage;
    private int chompCycle = halfCycle/2;
    private GamePanel gamePanel;
    private boolean[] keyPressed = new boolean[1024];

    
    public GameWindow(World world)
    {
        this.world = world;
        gamePanel = new GamePanel();
        add(gamePanel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setFocusable(true);

        addWindowListener(new WindowAdapter() {
                public void windowActivated(WindowEvent e) {
                    gamePanel.requestFocusInWindow();
                }});

        gamePanel.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) { keyPressed[e.getKeyCode()] = true; }
                public void keyReleased(KeyEvent e) { keyPressed[e.getKeyCode()] = false; }
            });

        pack();
        setVisible(true);
    }

    /**
     * This method generates a random number between 0 (inclusive) to range
     * (exclusive).
     * 
     * Here is an example showing how to use it:
     *
     * int n = GameWindow.random(100);
     *
     * if (n < 5)
     * {
     *   System.out.println("This happens 5% of the time");
     * }
     * else
     * {
     *   System.out.println("This happens 95% of the time");
     * }
     */
    public static int random(int range)
    {
        return random.nextInt(range);
    }

    /**
     * This method tests whether the given character is pressed.
     *
     * For example, isPressed('A') returns true if the 'A' key is pressed, or
     * otherwise returns false if the 'A' key is not pressed.
     */
    public boolean isPressed(char c)
    {
        return keyPressed[(int)Character.toUpperCase(c)];
    }

    /**
     * This method is similar to the one above, but it works for any keycode
     * that is defined in the java.awt.event.KeyEvent class. You can use this
     * method if you want to refer to arrow keys.
     */
    public boolean isPressed(int code)
    {
        return keyPressed[code];
    }

    /**
     * This method updates the screen.
     */
    public void updateScreen()
    {
        gamePanel.repaint();
    }

    /**
     * This method displays a game over message.
     */
    public void displayGameOver(String message)
    {
        gameOverMessage = message;
        updateScreen();
    }

    /**
     * This method causes the computer to sleep for "ms" milliseconds.
     */
    public void sleep(long ms)
    {
        try { Thread.sleep(ms); } catch (Exception e) {}
    }

    public class GamePanel extends JPanel
    {
        public GamePanel()
        {
            setPreferredSize(new Dimension(world.getWidth()+500, world.getHeight()));
        }

        public void paintComponent(Graphics g)
        {
            chompCycle++;
            paintBackground(g);
            paintWalls(g);
            paintItems(g);
            paintPlayer(g);
            paintEnemys(g);
            paintCombatScreen(g);
            if (gameOverMessage != null)
                paintMessage(g, gameOverMessage);
        }

        private void paintBackground(Graphics g)
        {
            Dimension size = getSize();
            ImageIcon pImg = new ImageIcon("Background.png");
        	Image sprite = pImg.getImage();
        	g.drawImage(sprite, 0, 0, null);
            //g.setColor(Color.black);
            //g.fillRect(0, 0, size.width, size.height);
        }

        
        
        private void paintCombatScreen(Graphics g)
        {
        	Dimension size = getSize();
        	g.setColor(Color.blue);
            g.drawRect(800, 100 , 300, 600);
            
            int playerHealth = world.getPlayer().getHealth();
            String message = "Player hp: " + playerHealth;
            g.setFont(new Font("SansSerif", Font.BOLD, 20));
            FontMetrics fm = g.getFontMetrics();
            int playerWidth = fm.stringWidth(message);
            int playerHeight = fm.getAscent();
            g.setColor(Color.blue);
            g.drawString(message, 810, 120);
            
            int playerAttack = world.getPlayer().getAttack();
            String message3 = "Player Attack: " + playerAttack;
            g.setFont(new Font("SansSerif", Font.BOLD, 20));
            int playerAttackWidth = fm.stringWidth(message3);
            int playerAttackHeight = fm.getAscent();
            g.setColor(Color.blue);
            g.drawString(message3, 810, 250);
            
            int playerDefense = world.getPlayer().getDefense();
            String message4 = "Player Defense: " + playerDefense;
            g.setFont(new Font("SansSerif", Font.BOLD, 20));
            int playerDefenseWidth = fm.stringWidth(message4);
            int playerDefenseHeight = fm.getAscent();
            g.setColor(Color.blue);
            g.drawString(message4, 810, 280);
        	
            int enemyHealth;
            if(world.currentlyFighting()==true)
            	enemyHealth = world.getEnemy().getHealth();
            else 
            	enemyHealth = 0;
            String message2 = "Enemy hp: " + enemyHealth;
            int enemyWidth = fm.stringWidth(message);
            int enemyHeight = fm.getAscent();
            g.setColor(Color.blue);
            g.drawString(message2, 810, 150);
            
        }
        
        
        private void paintWalls(Graphics g)
        {
            boolean[][] walls = world.getWalls();
            if (walls == null)
                return;

            for (int row = 0; row < walls.length; row++)
            {
                for (int col = 0; col < walls[row].length; col++)
                {
                    if (walls[row][col])
                    {
                        g.setColor(new Color(10, 10, 10));
                        int x = col*World.CELL_SIZE;
                        int y = row*World.CELL_SIZE;
                        g.fillRect(x, y, World.CELL_SIZE, World.CELL_SIZE);
                        g.setColor(Color.red);
                        int gap = 4;
                        // left
                        if (col-1 >= 0 && !walls[row][col-1])
                            g.fillRect(x, y, gap, World.CELL_SIZE);
                        // right
                        if (col+1 < World.COL_COUNT && !walls[row][col+1])
                            g.fillRect(x+World.CELL_SIZE-gap, y, gap, World.CELL_SIZE);
                        // top
                        if (row-1 >= 0 && !walls[row-1][col])
                            g.fillRect(x, y, World.CELL_SIZE, gap);
                        // bottom
                        if (row+1 < World.ROW_COUNT && !walls[row+1][col])
                            g.fillRect(x, y+World.CELL_SIZE-gap, World.CELL_SIZE, gap);
                    }
                }
            }
        }

        private void paintItems(Graphics g)
        {
            
        }

        private void paintPlayer(Graphics g)
        {
        	ImageIcon pImg = new ImageIcon("Player.png");
        	Image sprite = pImg.getImage();
            Player player = world.getPlayer();
            if (player == null)
                return;

            Body body = player.getBody();
            int x = body.getX();
            int y = body.getY();
            int radius = body.getRadius();
            g.drawImage(sprite, x, y, null);
            //g.setColor(Color.blue);
            //g.fillOval(x-radius, y-radius, radius*2, radius*2);

            

           /* switch (body.getDirection())
            {
                case right: quadrant = 0; break;
                case up: quadrant = 90; break;
                case left: quadrant = 180; break;
                case down: quadrant = 270; break;
                default: quadrant = 180; break;
            }
            g.setColor(Color.black);
            g.fillArc(x-radius, y-radius, radius*2, radius*2, quadrant + 360-chompAngle/2, chompAngle);
            */
        }

        private void paintEnemys(Graphics g)
        {
            Enemy[] Enemys = world.getEnemys();
            if (Enemys == null)
                return;

            for (Enemy Enemy : Enemys)
            {
            	ImageIcon eImg = new ImageIcon("Enemy.png");
            	Image sprite = eImg.getImage();
                int x = Enemy.getBody().getX();
                int y = Enemy.getBody().getY();
                int radius = Enemy.getBody().getRadius();
                Direction direction = Enemy.getBody().getDirection();
                if(Enemy.stillAlive()==true)
                {
                	g.drawImage(sprite, x, y, null);
                	//g.setColor(Color.GREEN);
                	//g.fillOval(x-radius, y-radius, radius*2, radius*2);
                    //g.setClip(x-radius, y-radius, radius*2, radius*2);
                }
                else g.setColor(Color.RED);
                //g.fillOval(x-radius, y-radius, radius*2, radius*2);
                //g.setClip(x-radius, y-radius, radius*2, radius*2);

                
                g.setClip(null);
            }
        }

        private void paintMessage(Graphics g, String message)
        {
            g.setFont(new Font("SansSerif", Font.BOLD, 34));
            FontMetrics fm = g.getFontMetrics();
            int width = fm.stringWidth(message);
            int height = fm.getAscent();
            Dimension size = getSize();
            g.setColor(Color.red);
            g.drawString(message, ((size.width-width)/2)+325, ((size.height-height)/2)-400 + height);
        }

        // You may use this method to paint an energiser onto the screen.
        private void paintEnergiser(Graphics g, Body body)
        {
            int x = body.getX();
            int y = body.getY();
            int radius = body.getRadius();
            g.setColor(Color.blue);
            g.fillOval(x-radius, y-radius, radius*2, radius*2);
        }
    }
}