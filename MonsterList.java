import java.util.HashMap;
/**
 * La classe MonsterList cree une liste de monstre
 *
 * @author (votre nom)
 * 
 */
public class MonsterList
{
  HashMap<String,Monster> aMonsterList;

  public MonsterList()
  {
       this.aMonsterList=new HashMap<String,Monster>();

  }
  public HashMap<String,Monster> getHashMonster()
  {
      return this.aMonsterList;
  }
  public void addMonster(final String pMonsterName,final Monster pMonster)
    {
        
        
        this.aMonsterList.put(pMonsterName,pMonster);
    }
  public void removeMonster(final String pMonsterName)
    {
        this.aMonsterList.remove(pMonsterName);
    }
  public Monster getMonster(final String pMonsterName)
    {
        if (this.aMonsterList==null)
            return null;
        

        return this.aMonsterList.get(pMonsterName);
    } 
 public String getMonsterString(final String pMessage)
{
    StringBuilder stringretourne = new StringBuilder(pMessage);
    
   
    
        
        for(Monster m : this.aMonsterList.values())
            stringretourne.append(" " + m.getMonsterName() + " : "  +m.getQuoteMonster()+"\n");
           
          
            
        return stringretourne.toString();
}
public boolean containsMonster(final String ps)
{
    return aMonsterList.containsKey(ps);
}//containsItem
}
