import java.util.ArrayList;


/**
 * La classe Transporter Room qui renvoie vers une room aleatoirement
 *
 * @author Raj Teray
 * 
 */
public class TransporterRoom extends Room
{

    RoomRandomizer vRoomRandom;   
    String aAlea=null;
    /**
    * 
    * @param ps
    * @param pimage
    * @param vRd
    * Constructeur d'objets de classe TransporterRoom
    */
    public TransporterRoom(final String ps,final String pimage,ArrayList<Room> vRd)
    {
       super(ps, pimage);
       this.vRoomRandom=new RoomRandomizer(vRd);
       
    
    }
    /**
     * 
     * @return une sortie random de la liste des rooms
     */
    public Room getExit()
    {
        ArrayList<Room> vArrayRoom= vRoomRandom.getArrayList();
        Room vRoom;
        vRoom=vRoomRandom.findRandomRoom();

        


        if(this.aAlea!=null)
        {
            for(Room vr : vArrayRoom)
        {
            if (vr.getDescription().equals(aAlea))
            {
                vRoom=vr;
            }


            

        }
        }

        
        return vRoom;
    }
    /**
     * fixe la sortie aleatoire
     * @param ps
     */
    public void setAlea(final String ps)
    {
        this.aAlea=ps;
       
    }
   
}
