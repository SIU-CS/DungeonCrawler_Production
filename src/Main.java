

public class Main
{
    public static void main(String[] args)
    {
        int floor = 90;
        World world = new World(floor);
        
        boolean result;
        result = world.play();
        while(result==true)
        {
        	floor++;
        	world = new World(floor);
        	result = world.play();
        }
       
       //world.setGhosts(getGhost("Please choose a level between 0 and 15"));
       // JOptionPane.showInputDialog(null, "Please choose a level between 0 and 15"); 
       
      
      // for (int i = 0; )
      //  {
        
      //  }
    }
    
    //private static int getGhosts(String prompt)
   // {
   //     String str = JOptionPane.showInputDialog(null, prompt);
   //     return Integer.parseInt(str);
   // }
    
}
