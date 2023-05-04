
import java.util.Random;
import java.util.ArrayList;

/**
 * La classe RoomRandomiser renvoie une room au hasard
 *
 * @author Raj Teray
 * 
 */
public class RoomRandomizer
{

    ArrayList<Room> vtab;
    public RoomRandomizer(final ArrayList<Room> ptab)
    {
        vtab=new ArrayList<>(ptab);
    }    
/**
 * 
 * @return une room random
 */
public Room findRandomRoom()
{
    Random vrand=new Random();
    int vi=vrand.nextInt(14);
    return vtab.get(vi);

}
/**
 * 
* @return l'ArrayList des rooms
 */
public ArrayList<Room> getArrayList()
{
    return vtab;
}
}