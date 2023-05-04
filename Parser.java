
import java.util.StringTokenizer;
/**
 * 
 * @author Raj Teray
 * 
 */
public class Parser
{
    private CommandWords aValidCommands;  // (voir la classe CommandWords)
   
       // permettra de lire les commandes au clavier
    /**
     * Constructeur par defaut qui cree les 2 objets prevus pour les attributs
     */
    public Parser() 
    {
        this.aValidCommands = new CommandWords();
        
       
    } // Parser()

    /**
     * @return The next command from the user.
     */
    public Command getCommand(final String pInputLine) 
    {

        String vWord1;
        String vWord2;
    
        StringTokenizer vTokenizer = new StringTokenizer( pInputLine );
      if ( vTokenizer.hasMoreTokens() )
            vWord1 = vTokenizer.nextToken();      // get first word
        else
            vWord1 = null;

        if ( vTokenizer.hasMoreTokens() )
            vWord2 = vTokenizer.nextToken();      // get second word
        else
            vWord2 = null;

        // Verifie si le premier mot est une commande connue.
        // Si oui, cree un objet Command avec ce mot. (vWord2 peut etre null)
        // Sinon, cree une commande vide avec "null" (pour dire 'commande inconnue').
        if ( this.aValidCommands.isCommand( vWord1 ) ) {
            return new Command( vWord1, vWord2 );
        }
        else {
            return new Command( null, vWord2 ); 
        }
    } // getCommand()
   
    public String getCommandString() // was showCommands()
    {
        return this.aValidCommands.getCommandList();
    } // getCommandString()

} // Parser               