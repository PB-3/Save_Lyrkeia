/**
 * La classe item cree des items avec un nom et un poids.
 * @author Raj Teray
 * 
 */
public class Item {
private String aItem;
private int aWeight;
/**
 * Constructeur naturel de la classe item
 * @param pItemName
 * @param pWeight
 */    
public Item(final String pItemName,final int pWeight)
{
     this.aItem=pItemName;
     this.aWeight=pWeight;
}
/**
 * renvoie le nom de l'item 
 * @return String aItem
 */
public String getItemName()
{
    return  this.aItem;
}
/**
 * renvoie le poids de l'item qui est aussi le nombre de dégat qu'inflige l'item pour l'epee par exemple
 * @return aWeight
 */
public int getWeight()
{
    return this.aWeight;
}
/**
 * renvoie la description de l'item
 * @return Name : [...]  Weight [...]
 */
public String getNameDescription()
{
    return "Name --> " + this.aItem + "Weight --> " + this.aWeight;
}
public void setWeight(final int pint)
{
    this.aWeight=pint;
}// setWeight()
}

