import java.util.HashMap;
/**
 * La classe ItemList gere toutes les methodes et procedures pour les listes d'items.
 *
 * @author Raj Teray
 */
  public class ItemList
  {
  HashMap<String,Item> aItem=new HashMap<String,Item>();

  public ItemList()
  {
       

  }
   /**
     * getHashItem renvoie la HashMap d'items
     * @return la HashMap
     */
  public HashMap<String,Item> getHashItem()
  {
      return this.aItem;
  }//getHashItem()
   /**
     * addItem rajoute un item a la HashMap d'items
     * @param pItem la clé 
     * @param pItem l'item 
     */
  public void addItem(final String pItemName,final Item pItem)
    {
        
        
        this.aItem.put(pItemName,pItem);
    }//addItem()
     /**
     * removeItem enleve un item de la HashMap
     * @param pItemName le nom de l'item
     */
  public void removeItem(final String pItemName)
    {
        this.aItem.remove(pItemName);
    }//removeItem()
    /**
     * getItem renvoie un item de la HashMap
     * @param pItemName nom de l'item
     */
  public Item getItem(final String pItemName)
    {
        if (this.aItem==null)
            return null;
  

        return this.aItem.get(pItemName);
    } // getItem()
    /**
     * getItemString renvoie la liste d'item de la HashMap Sous forme d'une string
     *  @param pMessage message qu'on veut envoyer au début de l'affichage des items
     */
 public String getItemString(final String pMessage)
{
    StringBuilder stringretourne = new StringBuilder(pMessage);
   
    
        for ( String ex : this.aItem.keySet() )
            stringretourne.append( " " + ex );
          
       
        return stringretourne.toString();
}//getItemsString
/**
 * verifie si l'item est dans la liste d'item
 * @param ps nom d'un item 
 */
public boolean containsItem(final String ps)
{
    return aItem.containsKey(ps);
}//containsItem
}//ItemList()
