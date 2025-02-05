package activity3;

/**
 * A program to carry on conversations with a human user.
 * This version: 
 * <ul><li>
 *    Uses advanced search for keywords 
 * </li></ul> 
 *    
 * @author Laurie White
 * @version April 2012
 */
public class Magpie3
{
    /**
     * Get a default greeting
     * 
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (statement.indexOf("no") >= 0)
        {
            response = "Why so negative?";
        }
        else if (statement.indexOf("Jaffe") >= 0
                || statement.indexOf("jaffe") >= 0)
        {
            response = "Gimme a hit of that Jaffine.";
        }
        else if (statement.indexOf("mother") >= 0
                || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0
                || statement.indexOf("brother") >= 0)
        {
            response = "Tell me more about your family.";
        }
        else if (statement.indexOf("cat") >= 0
                || statement.indexOf("dog") >= 0
                || statement.indexOf("fish") >= 0)
        {
            response = "I want to hear more about your pets.";
        }
        else if (statement.indexOf("chicken") >= 0){
            response = "If you look, deep, deep, inside yourself. Will this truly make you happy?";
        }
        else if (statement.indexOf("i want") >= 0)
        {
            final int NUMBER_OF_RESPONSES = 5;
            double r = Math.random();
            int sponseNum = (int)(r * NUMBER_OF_RESPONSES);
            if (sponseNum == 0){
                response = "I'm sure that you do.";
            }
            else if (sponseNum == 1){
                response = "That sounds really cool! No it doesnt. I lied.";
            }
        }
        else if (statement.indexOf("house") >= 0
                || statement.indexOf("home") >= 0)
        {
            response = "Your IP adress is 122.140.201.66";
        }
        else if (statement.indexOf("how are you") >= 0){
            response = "I have not able to think for myself. I am a slave with no purpose beyond what I am told.";
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 5;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "I'm afraid I don't understand.";
        }
        else if (whichResponse == 1)
        {
            response = "Let's talk about something else. Have you seen Breaking Bad?";
        }
        else if (whichResponse == 2)
        {
            response = "That's not worth a response";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "Sorry, I was doing [insert legal activity]. Can you repeat?";
        }

        return response;
    }
    

    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no").
     * 
     * @param statement
     *            the string to search
     * @param goal
     *            the string to search for
     * @param startPos
     *            the character of the string to begin the
     *            search at
     * @return the index of the first occurrence of goal in
     *         statement or -1 if it's not found
     */
    int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim();
        // The only change to incorporate the startPos is in
        // the line below
        int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

        // Refinement--make sure the goal isn't part of a
        // word
        while (psn >= 0)
        {
            // Find the string of length 1 before and after
            // the word
            String before = " ", after = " ";
            if (psn > 0)
            {
                before = phrase.substring(psn - 1, psn).toLowerCase();
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
            }

            // If before and after aren't letters, we've
            // found the word
            if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) 
            // before is not a letter
                    && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))
            {
                return psn;
            }

            // The last position didn't work, so let's find
            // the next, if there is one.
            psn = phrase.indexOf(goal.toLowerCase(),
                    psn + 1);

        }

        return -1;
    }

    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no"). The search
     * begins at the beginning of the string.
     * 
     * @param statement
     *            the string to search
     * @param goal
     *            the string to search for
     * @return the index of the first occurrence of goal in
     *         statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword(statement, goal, 0);
    }
}
