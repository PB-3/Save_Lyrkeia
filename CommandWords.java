
public class CommandWords

/**
 * La classe CommandWords verifie si une commande donnee est valide ou non
 */

{
    // a constant array that will hold all valid command words
   private static final String aValidCommands[] = {"go", "quit","help","look","eat","back","test","player","take","drop","attack","items","answer","charge","fire","alea"};

    /**
     * Constructor - initialise les command words.
     */
    public CommandWords() 
    {
    }      
        
    
  public boolean isCommand(String aString) 
             {
             for(int i = 0; i < aValidCommands.length; i++)
             {            if(aValidCommands[i].equals(aString))  
                          return true;  
             } 
             // if we get here, the string was not found in the commands  
             return false;
             }  
             /*     * returns a String of all valid commands.     */
  public String getCommandList() 
             {   StringBuilder commands = new StringBuilder();
                 for(int i = 0; i < aValidCommands.length; i++) 
                 {commands.append( aValidCommands[i] + "  " + "\n" );
                 }   
                 return commands.toString();
             }
}
// CommandWords