import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.JFrame;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;




/**
 * La classe UserInterface cree une interface pour le jeu.
 * @author Raj Teray
 * 
 */
public class UserInterface implements ActionListener
{
    private GameEngine aEngine;
    private JFrame     aMyFrame;
    private JTextField aEntryField;
    private JTextArea  aLog;
    private JLabel     aImage;
    private JButton    aButton;

    /**
     * Constructeur de la classe UserInterface
     * 
     * 
     */
    public UserInterface( final GameEngine pGameEngine )
    {
        this.aEngine = pGameEngine;
        this.createGUI();
        //this.createButton();
    } // UserInterface(.)

    /**
     *renvoie du texte.
     */
    public void print( final String pText )
    {
        this.aLog.append( pText );
        this.aLog.setCaretPosition( this.aLog.getDocument().getLength() );
    } // print(.)

    /**
     * renvoie du text et va a la ligne
     */
    public void println( final String pText )
    {
        this.print( pText + "\n" );
    } // println(.)
    
    /**
     * Affiche une image
     */
    public void showImage( final String pImageName )
    {
            
        String vImagePath = "image/" + pImageName ; // chemin images
        URL vImageURL = this.getClass().getClassLoader().getResource( vImagePath );
        if ( vImageURL == null )
            System.out.println( "Image not found : " + vImagePath );
        else {
            ImageIcon vIcon = new ImageIcon( vImageURL );
            this.aImage.setIcon( vIcon );
            this.aMyFrame.pack();
        }
    } // showImage(.)

    /**
     * 
     * Permet d'afficher ou enlever l'ecran
     */
    public void enable( final boolean pOnOff )
    {
        this.aEntryField.setEditable( pOnOff ); 
        if ( ! pOnOff ) { // disable
            this.aEntryField.getCaret().setBlinkRate( 0 ); 
            this.aEntryField.removeActionListener( this ); 
            this.aMyFrame.setVisible( false );
        }
  
    } // enable(.)
    public void entryfield(final boolean pTrueFalse)
    {
        if (pTrueFalse==false)
        {
            this.aEntryField.setEditable(false);
        }
    }

    /**
     * Mets en place l'interface graphique
     */
    private void createGUI()
    {
        this.aMyFrame = new JFrame( "Save Lyrkeia" ); // change le titre
        this.aEntryField = new JTextField( 100 );
        this.aEntryField.setPreferredSize(new DimensionUIResource(50, 50)); // cree une dimension (x,y) pour avoir une taille precise 
        this.aLog = new JTextArea();
        this.aLog.setFont(new Font("Monocraft",Font.BOLD,20)); // change la police du texte et la taille
        this.aLog.setBackground(Color.black); // couleur du background ou est affiché le texte
        this.aLog.setForeground(Color.GRAY); // couleur du texte
        this.aEntryField.setForeground(Color.WHITE); // couleur du background de l'endroit ou le joueur ecrit du texte
        this.aEntryField.setBackground(Color.BLACK); // couleur du texte
        this.aEntryField.setFont(new Font("Monocraft",Font.BOLD,25)); // change la police du texte et la taille
        this.aLog.setEditable( false );
     
        JScrollPane vListScroller = new JScrollPane( this.aLog );
        vListScroller.setPreferredSize( new Dimension(1280, 500) );
        vListScroller.setMinimumSize( new Dimension(1200,500) );

        JPanel vPanel = new JPanel();
        this.aImage = new JLabel();
        
        aButton = new JButton("back");
        aButton.addActionListener(this);
        aButton.setBounds(1,1000,1,1);
        aMyFrame.setLayout(new FlowLayout());
        aMyFrame.add(aButton);
        
        
        vPanel.setLayout( new BorderLayout() ); // 5places
        vPanel.add( this.aImage, BorderLayout.WEST );
        vPanel.add( vListScroller, BorderLayout.CENTER );
        vPanel.add( this.aEntryField, BorderLayout.SOUTH );
        vPanel.add(this.aButton,BorderLayout.NORTH);
   
       this.aMyFrame.getContentPane().add( vPanel, BorderLayout.CENTER );

        this.aEntryField.addActionListener( this );

        // ferme le programme
        this.aMyFrame.addWindowListener( new WindowAdapter()
        {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        } );

        this.aMyFrame.pack();
        this.aMyFrame.setVisible( true );
        this.aEntryField.requestFocus();        
    } // createGUI()

    /**
     * Actionlistener interface pour l'input entree lorsque une commande est solicite par le joueur
     */
    public void actionPerformed( final ActionEvent pE ) 
    {
        if(pE.getActionCommand()=="back")
            this.aEngine.processCommand("back");
        else
        this.processCommand();
    } // actionPerformed(.)

    /**
     * une commande a ete donnee il faut donc effectuer ce qu'elle demande.
     */
    private void processCommand()
    {
        String vInput = this.aEntryField.getText();
        this.aEntryField.setText( "" );

        this.aEngine.processCommand( vInput );
    } // processCommand()

    public String getText()
    {
        return this.aEntryField.getText();
    }
    
} // UserInterface 
