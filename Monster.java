
/**
 *La classe Monster cree des monstres.
 *
 * @author Raj Teray
 * 
 */
public class Monster
{
    private String aMonsterName;
    private int aMonsterHP;
    private String aQuoteMonster;
    public Monster(final String pName,final int pHP,final String pQuote)
    {
        this.aMonsterName=pName;
        this.aMonsterHP=pHP;
        this.aQuoteMonster=pQuote;
        



    }
    /**
     * 
     * @return renvoie les hp du monstre
     */
public int getMonsterHP()
{
    return this.aMonsterHP;
}
/**
 * 
 * @return le nom du monstre
 */
public String getMonsterName()
{
    return this.aMonsterName;
}
/**
 * 
 * @return la citation du monstre
 */

public String getQuoteMonster() // retourne la citation
{
    return this.aQuoteMonster;
}
/**
 * change les hp du monstre
 * @param pHp
 */
public void ReplaceHp(int pHp)
{
    this.aMonsterHP-=pHp;
    if(this.aMonsterHP<0)
    {
        this.aMonsterHP=0;

    }
 
}// ReplaceHp()

/**
 * 
 * @param monstre
 * @return un entier specifique en fonction du monstre mort
 */
public int monstremort(final String monstre)
{           

    int a;
    
    if(getMonsterName().equals("Warwick") );
    {a=0;}
    
    if(getMonsterName().equals("Aatrox"))
    {a=1;}

    if( getMonsterName().equals("Hecarim"))
    {a=2; }
    if(getMonsterName().equals("Volibear"))
    {a=3;}
    return a;
}

} // Monster
