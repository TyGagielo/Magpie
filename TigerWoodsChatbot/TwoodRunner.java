package TigerWoodsChatbot;

import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class TwoodRunner
{

    /**
     * Create a Magpie, give it user input, and print its replies.
     */
    public static void main(String[] args)
    {
        TWood wood = new TWood();
        //instantiate TWood class
        
        System.out.println (wood.getGreeting());
        Scanner in = new Scanner (System.in);
        String statement = in.nextLine();
        
        while (!statement.equals("Bye"))
        {
            System.out.println (wood.getResponse(statement));
            statement = in.nextLine();
        }
    }

}