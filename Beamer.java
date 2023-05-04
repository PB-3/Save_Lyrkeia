public class Beamer extends Item {
    private Room aRoom;
    public Beamer(final String pname,final int pWeight)
    {
        super(pname, pWeight);
        

    }


public void charge(final Room pRoom)
{
    this.aRoom=pRoom;

}
public Room fire()
{
   
    return this.aRoom;
    
}
}   

