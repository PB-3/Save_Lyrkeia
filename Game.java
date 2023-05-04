/**
 * 
 * @author Raj Teray
 * Permet de lancer le jeu
 */
public class Game
{
    private UserInterface aGui;
    private GameEngine aEngine;
    
    
    /**
     * Crée un jeu et une interaface
     */
    public Game() 
    {
        
        this.aEngine = new GameEngine();
        
        this.aGui = new UserInterface( this.aEngine );
        this.aEngine.setGUI(this.aGui);
        
    }
}