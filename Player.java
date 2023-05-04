import java.util.Stack;


/**
 *La classe Player gere tout ce qui est propre au joueur    
 *
 * @author Raj Teray
 * 
 */
public class Player
{
    private Room aCurrentRoom;
    private String aPlayerName;
    private int aPlayerHP;
   // private UserInterface aGui;
    private Stack<Room> aBackRooms=new Stack<>();
    private ItemList aPlayerItem=new ItemList();
    private int aMaximumWeight=30;
    private int aWeightPlayer=0;
    /**
     * @param vPlayerName
     * @param pHp
     * Constructeur Naturel de la classe Player
     */
    public Player(final String vPlayerName,final int pHp)
    {
        this.aPlayerName=vPlayerName; 
        this.aPlayerHP=pHp;  
    }
    /**
     * la fonction getRoom permet d'acceder a la currentRoom
     * @return la room actuelle
     */
    public Room getRoom()
    {
        return this.aCurrentRoom;
    }//getRoom()
    /**
     * la procedure setRoom permet de mettre en place une room pour la room actuelle
     * @param pRoom une room 
     * 
     */
    public void setRoom(Room pRoom)
    {
        this.aCurrentRoom=pRoom;
        
    }//setRoom()
    /**
     * la fonction getPlayerName permet permet d'avoir le nom du joueur
     * @return le nom du joueur
     */
    public String getPlayerName()
    {
        return this.aPlayerName;
    }//getPlayerName()
    /**
     *  la procedure setBackRooms permet de stocker dans la pile les rooms precedentes
     * @param pRoom la room sera stockée dans une pile
     */
    public void setBackRooms(Room pRoom)
    {
        this.aBackRooms.push(pRoom);
    }//setBackRooms()
    /**
     * permet d'acceder a la pile Stack
     * @return la pile des rooms 
     */
    public Stack<Room> getBackRooms()
    {
        return this.aBackRooms;
    }//getBackRooms()

    /**
     *
     * la fonction popRoom permet d'enlever de la pile une roome et de la renvoyer  
     * @return la room sera renvoyée et enlevée de la pile
     */
    public Room popRoom()
    {
        return this.aBackRooms.pop();
    }//popRoom()

    /**
     * 
     * la procedure itemplayer permet de rajouter un item parmis ceux que le joueur porte
     * @param pItemName le nom de l'item a ajouter
     * 
     */
    
    public void addItemPlayer(final String pItemName)
    {
        Item ajoutItem=this.aCurrentRoom.getItem(pItemName);
        //this.aPlayerItem=addItem;
        this.aPlayerItem.addItem(pItemName,ajoutItem);
        // this.aCurrentRoom.getHashItems().put(pItemName,addItem);
    }//addItemPlayer()

    /**
     * la procedure removeItemPlayer permet d'enlever un item au joueur
     * @param pItemName le nom de l'item a enlever
     */
    public void removeItemPlayer(final String pItemName)
    {
        this.aPlayerItem.removeItem(pItemName);
    }//removeItemPlayer()
    /**
     * la procedure getItemPlayer permet de retourner un item que le joueur possede
     * @param pItemName le nom de l'item a retourner que le player possede
     */
    public Item getItemPlayer(final String pItemName)
    {
        if (this.aPlayerItem.getItem(pItemName)==null)
            return null;
            
        return this.aPlayerItem.getItem(pItemName);
    }//getIteamPlayer()
    
    /**
     * la methode getMaximumWeight permet de retourner le poids maximum
     * @return le poids maximal possible
     */

    public int getMaximumWeight()
    {
        return this.aMaximumWeight;

    }//getMaximumWeight()
    /**
     *  MaximumWeight permet de mettre en place un poid maximum
     * @param pWeight definit le poid maximal
     */
        public void MaximumWeight(final int pWeight)
    {
         this.aMaximumWeight=pWeight;
    }//MaximumWeight()
    /**
     * getWeightPlayer renvoie le podis des items que le joueur a sur lui au total
     * @return renvoie le poids du joueur
     */
    public int getWeightPlayer()
    {
        return this.aWeightPlayer;

    }//getWeightPlayer()
    /**
     * addWeightPlayer modifie le poids des items du joueur
     * @param pWeight le poids a ajouter au joueur
     */
        public void addWeightPlayer(final int pWeight)
    {
         this.aWeightPlayer+=pWeight;
    }//addWeightPlayer()
/**
     * Renvoie la liste d'items
     * @return La liste d'items
     */
    public ItemList getItemPlayerList()
    {
        return this.aPlayerItem;
    }//getItemPlayerList()
    /**
     * renvoie les hp du joueur
     * @return les hp du joueur
     */
    public int getPlayerHp()
    {
        return this.aPlayerHP;
    }
    /**
     * modifie les hp du joueur de maniere totale
     * @param pHp
     */
    public void setPlayerHp(int pHp)
    {
        this.aPlayerHP=pHp;
    }
    /**
     * ajoute ou enleve une quantitée de point de vie au joueur
     * @param pHp
     */
    public void addPlayerHp(int pHp)
    {
        this.aPlayerHP+=pHp;
    }
    /**
     * permet d'enfermer le joueur dans une room
     */
    public void lockPlayerRoom()
    {
        if(getRoom().getDescription().equals("Fighting Room 1")||getRoom().getDescription().equals("Fighting Room 2")||getRoom().getDescription().equals("Fighting Room 3"))   
        {
            
              for(Room pr : getBackRooms())
               pr.setAcessRoom(false);
             
        }
    }
    /**
     * 
     * @param pRoom
     * @return true si la room est accessible false sinon 
     */
    public boolean accessRoomTrue(Room pRoom) //room proom
    {  
        if (this.aPlayerItem.containsItem("key") &&getRoom().getDescription()=="Anthropos")
             {
             return true;
             }
        else 
            return false;

    } //accessRoomTrue()
}//Player