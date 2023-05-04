import java.util.HashMap;


/**
 * Classe Room - gere tout les lieux du jeu
 *
 * @author votre nom
 */
public class Room

{   
    private HashMap<String,Room> exits;  
    private String aDescription; 
    private String aImageName;
    private ItemList aItemRoom=new ItemList();
    private MonsterList aMonsterRoom=new MonsterList();
    private boolean aAccessRoom;
    public Room( final String pDescription , final String pImage ) 
    {
        this.aDescription = pDescription;
        this.exits = new HashMap<String,Room>();
        
        this.aItemRoom=new ItemList();
        
        this.aImageName = pImage;
        this.aAccessRoom=true;
     
     
    }//Room
public HashMap<String,Room> getHashRoom()
{
    return this.exits;
}
/**
 *  acquerir le nom du lieu actuel
 * @return la description du lieu
 */
public String getDescription() 
    {return this.aDescription;
        } // getDescription()


/**
 * mise en place des sorites de chaque lieu
 * @param pKey
 * @param pRoom
 */
public void setExits(final String pKey,final Room pRoom)
{
    exits.put(pKey,pRoom);
    
}//setExits(à)


/**
 *  Retourne la Room qui se trouve dans cette direction.
 * @param vDescription la cle pour renvoyer la room correspondante
 */
public Room getExits(String vDescription)
{
return exits.get(vDescription);
}

/**
 *  recuperation des sorties disponibles de la pièce.
 * @return la liste des sorties de la room
 */
 
    private String getExitsString()
    {
        StringBuilder stringretourne = new StringBuilder( "Exits:" );
        for ( String ex : this.exits.keySet() )
            stringretourne.append( " " + ex );
        return stringretourne.toString();
    }//getExitsString()
    /**
     * renvoie une description complete
     * @return une description de la room et des items dedans
     */

    public String getLongDescription()
  {
   
        
    return "You are at "+this.aDescription+ "\n"+getExitsString()+"\n"+aItemRoom.getItemString("The items of the Room are ");
        
  }//getLondDescription()

    /**
     * Retourne une le nom de l'image 
     * @return le nom de l'image
     */
     public String getImageName()
     {
         return  this.aImageName;
     }
     /**
     * getItem renvoie un item de la room
     * @param pItemName le nom de l'item
     * @return l'item que l'on veut 
     */
    public Item getItem(String pItemName)
    {
    return this.aItemRoom.getItem(pItemName);
    }//getItem()
    /**
     * ajoute l'item dans la room
     * @param pName
     * @param pItem
     */
    public void addItemRoom(final String pName,final Item pItem)
    {
         
         this.aItemRoom.addItem(pName,pItem);
                        

    }//addItemRoom()
    /**
     * getItemString permet d'avoir la liste des items presents dans la Room
     * @return la liste d'items de la room
     */
    public ItemList getItemRoom()
    {
        ;
        return this.aItemRoom;
    }//getItemString()
    /**
     * ContainsItems verifie que l'item est bien present dans la Room
     * @param pItem le nom de l'item
     * @return true si l'item est dedans false sinon
     */
    public boolean ContainsItems(final String pItem)
    {
        return this.aItemRoom.getHashItem().containsKey(pItem);
    }//ContainsItems()
    /**
     * RemoveItemRoom permet d'enlenver un item de la room
     * @param pItemName le nom de l'item
     */
    public void removeItemRoom(final String pItemName)
        {
            this.aItemRoom.removeItem(pItemName);
            
    }//removeItemRoom()
    /**
     * getMonsterList renvoie la liste des monstres presents dans la Room
     * @return la liste des monstres
     */
    public MonsterList getMonsterList()
    {
        return this.aMonsterRoom;
    }//getMonsterList()

    /**
     * getAcessRoom() renvoie le booleen qui permet de savoir si une salle est accessible ou non
     * @return true si la room est acessible false sinon
     */
    public boolean getAccessRoom()
    {
        return this.aAccessRoom;
    }//getAccessRoom()
    /**
     * permet de definir si l'accesseur vaudra true or false
     * @param pBool booléen pour fixer la room a l'etat acessible ou non
     */
    public void setAcessRoom(final boolean pBool)
    {
        this.aAccessRoom=pBool;
    }//setAcessRoom()

    }//Room()
