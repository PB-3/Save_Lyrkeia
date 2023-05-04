
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;



/**
 * Classe Game - le moteur du jeu d'aventure Save Lyrkeia.
 *
 * @author Raj Teray
 */
public class GameEngine
{
    
    private Parser aParser;
    private UserInterface aGui;
    private Room aPreviousRoom;
    private ArrayList<Room> aListRooms=new ArrayList<Room>();
    private TransporterRoom vTransporterRoom;
    private boolean aModeTest;
    private int aMaximumBack;
   
    private Player aPlayer;
    /**
     * Constructeur de la classe GameEngine
     */
    public GameEngine()
    {
        String vPrenom = javax.swing.JOptionPane.showInputDialog( "What's your nickname ?" );

        this.aPlayer=new Player(vPrenom,30);
        this.aParser = new Parser();
        this.createRooms();
        
    }
    /**
     * genere une interface
     * @param pUserInterface
     */
    public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
          
        this.printWelcome();
    }
    /**
     * 
     * creation de toutes les rooms du jeu ainsi que mise en place de leurs sorties et entrees
     */   
    private void createRooms()
    {
        
        // LYRKEIA    
        
        Room vLyrkeia= new Room("Lyrkeia","Lyrkeia.jpg");
        aListRooms.add(vLyrkeia);
        // ITEMS LYRKEIA

        Item vSword=new Item("Sword",20);
        vLyrkeia.addItemRoom("sword", vSword);
        Item vShield=new Item("shield",10);
        vLyrkeia.addItemRoom("shield", vShield);
        
        // FORET
    
        Room vForet=new Room("the Forest","Foret.jpg");
        aListRooms.add(vForet);
    
        // MONSTRES FORET

        Monster vKloss=new Monster("Kloss",10,"");
        Monster vSion=new Monster("Sion",120,"Rest is for the living.");
        vForet.getMonsterList().addMonster("Kloss",vKloss);
        vForet.getMonsterList().addMonster("Sion",vSion);

        // ITEMS FORETS

        Item vBois=new Item("Bois",20);
        vForet.addItemRoom("bois",vBois);
        Item vTronc=new Item("Tronc",100);
        vForet.addItemRoom("tronc",vTronc);
        Beamer vBeamer=(Beamer)new Beamer("Beamer",2);
        vForet.addItemRoom("beamer",(Beamer) vBeamer);
        // EXITS LYRKEIA 
         
        vLyrkeia.setExits("north",vForet); // direction la foret depuis Lyrkeia
        
        // ANTHROPOS FRONT OF THE MOUNTAIN
        
        Room vAnthropos=new Room("Anthropos","Montagne.jpg" );
        aListRooms.add(vAnthropos);
        // EXITS FORETS

        vForet.setExits("south",vLyrkeia); // direction la foret depuis Lyrkeia
        vForet.setExits("north",vAnthropos); // direction la foret depuis Lyrkeia
        
        // ITEMS FRONT ANTHROPOS

        Item vKeyAnthropos= new Item("Cle_Montagne",1);
        vAnthropos.addItemRoom("key", vKeyAnthropos);

        // MONSTRES ANTHROPOS
      
        Monster vPepsi=new Monster("Pepsi",1000,"May the destiny be with you");
        vAnthropos.getMonsterList().addMonster("Pepsi",vPepsi);


        // SALLES DE L'ETAGE 1

        Room vEtage1=new Room("The first level of the mountain","salle_etage.jpg");
        Room vEnigme1 = new Room("Enigma Room 1","salle_enigme.png");
        Room vCombat1 = new Room ("Fighting Room 1","salle_combat.jpg");
        vEtage1.setAcessRoom(false);
        aListRooms.add(vEtage1);
        aListRooms.add(vEnigme1);
        aListRooms.add(vCombat1);

    
        // ANTHROPOS EXITS

        vAnthropos.setExits("south",vForet);
        vAnthropos.setExits("level1",vEtage1);
    
        // MONSTRES DE LA SALLE DE COMBAT 1

        Monster vWarwick=new Monster("Warwick",50,"They fear me. They should.");
        vCombat1.getMonsterList().addMonster("Warwick",vWarwick);

        // SALLES DANS L'ETAGE 2

        Room vEtage2=new Room("The ShopKeeper's level","level2.png");
        Room vCombat2=new Room("Fighting Room 2","salle_combat.jpg");
        Room vEnigme2=new Room("Enigma Room 2","salle_enigme.png");
        vEtage2.setAcessRoom(false);
        aListRooms.add(vEtage2);
        aListRooms.add(vCombat2);
        aListRooms.add(vEnigme2);
  

        // MONSTRES DE LA SALLE DE COMBAT 2

        Monster vAatrox=new Monster("Aatrox",50,"I bring silence! I am the World-Ender!");
        vCombat2.getMonsterList().addMonster("Aatrox",vAatrox);
        
        // SALLES DE L'ETAGE 3 

        Room vEtage3=new Room("The Level 3 of the mountain","salle_etage.jpg");
        vEtage3.setAcessRoom(false);
        Room vCombat3=new Room("Fighting Room 3","salle_combat.jpg");
        vCombat3.setAcessRoom(false);
        Room vEnigme3=new Room("Enigma Room 3","salle_enigme.png");
        aListRooms.add(vEtage3);
        aListRooms.add(vCombat3);
        aListRooms.add(vEnigme3);
        vCombat3.setExits("teleportation",vEtage2);
        vEnigme3.setExits("teleportation",vEtage2);

        // MONSTRES DE LA SALLE DE COMBAT 3

        Monster vHecarim=new Monster("Hecarim",50,"Face death!");
        vCombat3.getMonsterList().addMonster("Hecarim",vHecarim);

         // EXITS DE L'ETAGE 1

        vEtage1.setExits("south",vAnthropos);
        vEnigme1.setExits("level2",vEtage2);
        vCombat1.setExits("level2",vEtage2);
        vEtage1.setExits("fightingroom1",vCombat1);
        vEtage1.setExits("enigmaroom1",vEnigme1);

        // SORTIES DE L'ETAGE 2

        //vEtage2.setExits("level3",vEtage3);
        vEtage2.setExits("enigmaroom2",vEnigme2);
       // vEtage2.setExits("fightingroom2",vCombat2);
        // SORTIES VCOMBAT2 ET VENIGME2
        vEnigme2.setExits("fightingroom2",vCombat2);
        vCombat2.setAcessRoom(false);
        vCombat2.setExits("level3",vEtage3);
        vEtage3.setAcessRoom(false);
        
        // SORTIES DE L'ETAGE 3  

        vEtage3.setExits("teleportation",vEtage2);
        vEtage3.setExits("level2",vEtage2);
        vEtage3.setExits("enigmaroom3",vEnigme3); // à definir des conditions d'accès dans go Room ?
   

       
        

       

        // SALLE FINALE 

        Room vSalleFinale = new Room("FinalStage","salle_recompense.png");
        aListRooms.add(vSalleFinale);
        Item vJar=new Item("jar",1);
        vSalleFinale.addItemRoom("jar",vJar);
        vSalleFinale.setExits("teleportation",vEtage2);


        // SORTIES DE LA SALLE DE L'UPGRADE DE STUFF PRE-BOSS FINAL

        Room vRoomUpgrade =new Room("The Reward Room","reward_room.png");
        vRoomUpgrade.setAcessRoom(false);
        vRoomUpgrade.setExits("finalRoom",vSalleFinale);
        vRoomUpgrade.setExits("teleportation",vEtage2);
        aListRooms.add(vRoomUpgrade);

         // ITEMS DE SALLE UPGRADE

         Item vSuperCheese=new Item("SuperCheese",1);
         vRoomUpgrade.addItemRoom("superCheese",vSuperCheese);
         Item vSword2=new Item("SuperSword",25);
         vRoomUpgrade.addItemRoom("SuperSword", vSword2);

        
        // SORTIES DE LA SALLE D'ENIGME 3

        vEnigme3.setExits("fightingroom3",vCombat3);
       
        // SORTIES DE LA SALLE DE COMBAT 3

         vCombat3.setExits("rewardobjectroom",vRoomUpgrade);
        
        // MONSTRES DE LA SALLE FINALE

        Monster vVolibear=new Monster("Volibear",75, "I am Valhir of the first thunder, destroyer of the white mountain, carver of the five Fjords!");
        vSalleFinale.getMonsterList().addMonster("Volibear",vVolibear);
        
        //positionnement des salles
        this.aPreviousRoom=null;
        this.aPlayer.setRoom(vLyrkeia);
        vTransporterRoom=new TransporterRoom("TransporterRoom","random.png",aListRooms);
        vForet.setExits("transportroom", vTransporterRoom);
        vTransporterRoom.setExits("somewhere", vLyrkeia);
    }//createRoom()
    /**
     * La procedure goRoom permet de changer de salle
     * @param  pGo les commandes envoyes par le joueur
     * 
     */

    public void goRoom(final Command pGo)
    {
        if (pGo.getCommandWord().equals(("fire")))
        {
           Beamer vbim=(Beamer) this.aPlayer.getItemPlayer("beamer");
           aPreviousRoom=this.aPlayer.getRoom();
           this.aPlayer.setBackRooms((this.aPlayer.getRoom()));
           this.aPlayer.setRoom(vbim.fire());
           this.aGui.println( this.aPlayer.getRoom().getLongDescription());
           this.aGui.println(this.aPlayer.getRoom().getMonsterList().getMonsterString("Monsters here : \n"));
           if ( this.aPlayer.getRoom().getImageName() != null )
               this.aGui.showImage(this.aPlayer.getRoom().getImageName());
           return;
        }
        
        if(pGo.hasSecondWord()==false) 
        {this.aGui.println("go where ? ");
            return;
        }
        String vDirection=pGo.getSecondWord();
        
        Room vNextRoom =this.aPlayer.getRoom().getExits(vDirection); 
        
        if (vNextRoom==null)
            {this.aGui.println("There is no door!");
            return;
             }
       
        if (this.aPlayer.accessRoomTrue(this.aPlayer.getRoom())==true) // a l'item pour debloquer des salles
        {
            vNextRoom.setAcessRoom(true);
        }
        
 
         if (this.aPlayer.getRoom().getExits(vDirection).getAccessRoom()==false)
        {
            this.aGui.println("The room is not accessible for the moment");
            return;
        }
        
        if(this.aPlayer.getRoom().getDescription().equals("TransporterRoom"))

        {
            vNextRoom = vTransporterRoom.getExit() ;
            
        
        }
        
      
            
        aPreviousRoom=this.aPlayer.getRoom();
        this.aPlayer.setBackRooms((this.aPlayer.getRoom()));
        this.aPlayer.setRoom(vNextRoom);  
        this.aGui.println( this.aPlayer.getRoom().getLongDescription());
        this.aGui.println(this.aPlayer.getRoom().getMonsterList().getMonsterString("Monsters here : \n"));
        
        if(vNextRoom.getDescription()=="Enigma Room 1")
        {   
            this.aGui.println("The poor have it, the rich don't need it, I am worse than the devil and better than any god."+ "\n" +"Who am I?");
            
        } 
        if(vNextRoom.getDescription()=="Enigma Room 2")
        {   
            this.aGui.println("Everyone has it but no one can loose it."+ "\n" +"Who am I?");
            
        }
        if(vNextRoom.getDescription()=="Enigma Room 3")
        {   
            this.aGui.println("Everything, it devours. It gnaws at iron, makes steel disappear and turns stones to dust."+"\n" +"Who is it?");
            
        }
   


        if ( this.aPlayer.getRoom().getImageName() != null )
            this.aGui.showImage(this.aPlayer.getRoom().getImageName());
        
            if(this.aPlayer.getRoom().getDescription().equals("Fighting Room 1")||this.aPlayer.getRoom().getDescription().equals("Fighting Room 2")||this.aPlayer.getRoom().getDescription().equals("Fighting Room 3"))   
            {
                 this.aPlayer.lockPlayerRoom();
                this.aPreviousRoom=null;
                this.aGui.println("You are trapped here, you can't go back");
                this.aGui.println(" ");
             
                   
            }  
               
        
    }//goRoom()^

    /**
     * 
     * la procedure printWelcome permet d'afficher un message de bienvenue au debut du jeu
     */
    private void printWelcome() { 
        // this.aGui.println("Welcome to the World of Lyrkeia!");
        // this.aGui.println("You live in lyrkeia and the destiny choosed to change your life for ever.");
        fichier("welcome");
        this.aGui.println( this.aPlayer.getRoom().getDescription() );
        this.aGui.println(this.aPlayer.getRoom().getItemRoom().getItemString("Rooms items are: "));
        this.aGui.println("Type 'help' if you need help.");
      //  this.aGui.println(this.aPlayer.getRoom().getMonsterList().getMonsterString("Monsters here : ")); // Il n'y a pas de monstre  a lyrkeia
        this.aGui.showImage( this.aPlayer.getRoom().getImageName());
        
    }//printWelcome()
    /**
     *  la procedure printHelp affiche une aide pour le joueur
     *      
     */
    private void printHelp()
    {   
        this.aGui.println(" You are lost. You are alone.");
        this.aGui.println("You wander around at "+this.aPlayer.getRoom().getDescription()+ " ");
        this.aGui.println("Your command worlds are:");
        this.aGui.println(this.aParser.getCommandString());
        this.aGui.println(this.aPlayer.getRoom().getLongDescription());
        

    }//printHelp()
    
    /**
     * 
     * la procedure look permet de savoir ou est ce que l'on se trouve
     */
    private void look()
    {   
  
        this.aGui.println(this.aPlayer.getRoom().getLongDescription());
    }
    /**
     * 
     * la procedure eat permet de manger un item
     * @param pFood l'item a manger
     */
    
    private void eat(final String pFood)
    {   if(this.aPlayer.getItemPlayer(pFood)==null)
        {
            this.aGui.println("You don't have this item on you ");
            return;
        }
        
        Item vFood=this.aPlayer.getItemPlayer(pFood);
        if(vFood.getItemName()=="SuperCheese")
        {
            this.aGui.println("You ate the super food "+vFood.getItemName()+"!");
            this.aPlayer.removeItemPlayer(pFood);
            this.aGui.println(this.aPlayer.getItemPlayerList().getItemString("Players items : "));
            this.aPlayer.MaximumWeight(this.aPlayer.getMaximumWeight()*2);
            this.aGui.println("You can now carry a weight up to "+this.aPlayer.getMaximumWeight());
            this.aPlayer.getItemPlayer("sword").setWeight(25);
            this.aGui.println("Your sword does more damage from now");

        }
        this.aPlayer.addWeightPlayer(-(vFood.getWeight()));
        this.aGui.println("You ate "+vFood.getItemName());
        this.aPlayer.removeItemPlayer(pFood);
        this.aGui.println(this.aPlayer.getItemPlayerList().getItemString("Players items : "));
        
    }//eat()
    /**
     *  la procedure back permet de revenir en arrière
     * 
     */
    private void back()
    {
        if (this.aPreviousRoom==null || this.aPlayer.getBackRooms().empty()==true)
            {
                this.aGui.println("there is no previous Room");
                
            }
        else
        {
        this.aPlayer.setRoom(this.aPlayer.popRoom());
        
        this.aGui.println(" You came back to " + this.aPlayer.getRoom().getLongDescription() );
        this.aGui.println(this.aPlayer.getRoom().getMonsterList().getMonsterString("Monsters here : "));
        this.aGui.println(this.aPlayer.getRoom().getItemRoom().getItemString("The items of this room are : "));
        
        
        if ( this.aPlayer.getRoom().getImageName() != null )
                this.aGui.showImage( this.aPlayer.getRoom().getImageName() );
        }
        
    }//back()
    /**
     * la fonction processCommand permet d'effectuer les commandes presentes dans le jeu
     * @param pCom une String qui est la commande passée par le joueur
     */
    public boolean processCommand(final String pCom)
    {   
        this.aGui.println( "-> " + pCom );
        Command vCommand = this.aParser.getCommand( pCom );
        if(vCommand.isUnknown())
        {
            {this.aGui.println("I don't know what you mean...");
             this.aGui.println("try to write command like: go [...] or take [...] exemple go North or take Sword ");
            }
            return false;
        }
        switch (vCommand.getCommandWord())
        {
            case "quit": quit(vCommand);
            break;

            case "go": goRoom(vCommand);
            break;

            case"help": printHelp();
            break;

            case "look" :look();
            break;

            case "eat" :
            if(vCommand.getSecondWord()==null)
            {
                this.aGui.println("what do you want to eat ?");
            }
            else
            {eat(vCommand.getSecondWord());}
            break;

            case "back" :
            { aMaximumBack+=1;
                if (vCommand.getSecondWord()!=null)
                    {this.aGui.println(" back command doesn't need words after it has been casted");}
                else
                {if (aMaximumBack>3)
                {
                    this.aGui.println("You over used the command back. You lost");
                    this.aGui.entryfield(false);
                    return false;
                }
                back();
                }
                }
            break;

            case "test":
            {this.aModeTest=true;
                if (vCommand.getSecondWord()==null)
                {
                 this.aGui.println(" which test ?");
                 this.aModeTest=false;
                }
            else
            fichier(vCommand.getSecondWord());
            this.aModeTest=false;           
            }
            break;

            case "player":
            {this.aGui.println("Player name is -> "+this.aPlayer.getPlayerName());
            this.aGui.println("Hp : "+this.aPlayer.getPlayerHp());}
            break;

            case "take":  take(vCommand);
            break;

            case "drop": drop(vCommand);
            break;

            case "attack":
            if (vCommand.getSecondWord()==null)
                {this.aGui.println(" who do you want to attack?");}
            else
                { attack(vCommand.getSecondWord());}
            break;

            case "items":
            {this.aGui.println(this.aPlayer.getItemPlayerList().getItemString("Players items :  ")+" Current Weight -> "+this.aPlayer.getWeightPlayer());
            }
            break;
            

            case "answer": enigmes(vCommand);
            break;

            case "charge":
            {
                Beamer vbime;
                vbime=(Beamer)this.aPlayer.getItemPlayer("beamer");
                 vbime.charge(this.aPlayer.getRoom());
             }
            break;

            case "fire":
            {
                goRoom(vCommand);
            }
            break;

            case "alea":
            {
                if (aModeTest==true)
                {
                    if (vCommand.getSecondWord()!=null)
                    {
                        vTransporterRoom.setAlea(vCommand.getSecondWord());
                    }
                    else
                    {
                        vTransporterRoom.setAlea(null); 
                    }
                }
                else
                {
                    this.aGui.println("Can't use alea outside of a test");
                }
            }
            break;
        }
    return false;
    } //processCommand()
    /**
     *la procedure fichier permet de lire des fichiers et d'effectuer les commandes des fichiers
     * @param pFichier le nom du fichier
     */
    private void fichier(final String pFichier)
    {
        try
        {
            FileInputStream file= new FileInputStream("COMMANDES/"+pFichier+".txt");
            Scanner vscan=new Scanner(file);
            while (vscan.hasNextLine())
            {
                if (pFichier.equals("welcome") || pFichier.equals(("endgame")))
                {
                    this.aGui.println(vscan.nextLine());

                    
                }
                else
                this.processCommand(vscan.nextLine());
                this.aGui.println(vscan.nextLine());            
            }
            vscan.close();
        }
        
        catch (java.util.NoSuchElementException e)
        {
            this.aGui.println("");
        }
        catch (java.io.FileNotFoundException e)
        {
            this.aGui.println("no file");
        }
    }//fichier()


    /**
     * la procedure take permet de recuperer des objets dans une room
     * @param pItemName le nom de l'item sera extrait de cette Command
     */

    private void take(final Command pItemName)
    {    
        String vItem=pItemName.getSecondWord();
         if(pItemName.hasSecondWord()==false)
        {
            this.aGui.println("which item do you want to take ? ");
            return;
        }
        if (this.aPlayer.getRoom().ContainsItems(vItem)==false)
        {
            this.aGui.println("There is no such item here !");
            return;
        } 
        
        Item item=this.aPlayer.getRoom().getItem(vItem);
        
        if (item.getItemName().equals("jar")==true)
        {
            if(this.aPlayer.getRoom().getMonsterList().containsMonster("Volibear")==true)
             {
                 this.aGui.println("You can't take the jar, Volibear won't let you !");
                 return;
             }
        }
        
        if(this.aPlayer.getWeightPlayer()>this.aPlayer.getMaximumWeight())
        {
            this.aGui.println("You are carrying too much item the weight is too high drop something !");
           
            return;
        }
        
        
        else
        this.aPlayer.addItemPlayer(vItem);
        this.aPlayer.addWeightPlayer(item.getWeight());
        this.aPlayer.getRoom().removeItemRoom(vItem);
        this.aGui.println(this.aPlayer.getItemPlayerList().getItemString("Players items : "));
        if (this.aPlayer.accessRoomTrue(this.aPlayer.getRoom())==true) // a l'item pour debloquer des salles
        {
            this.aGui.println("The next room after : " + this.aPlayer.getRoom().getDescription() +" is unlocked");
        }
       
    }//take

    /**
     * Permet au joueur de deposer un item dans la room ou il se trouve
     * @param pItemName
     * 
     */
    private void drop(final Command pItemName)
    {
        String vItem=pItemName.getSecondWord();
        Item drop=this.aPlayer.getItemPlayer(vItem);
     if(pItemName.hasSecondWord()==false) 
        {
         this.aGui.println("which item do you want to drop? ");
         return;     
        }
     else if(this.aPlayer.getItemPlayer(vItem)==null)
         {
         this.aGui.println("You don't have this item on you ! ");
         return;
         }
     else
     this.aPlayer.getRoom().addItemRoom(vItem,drop);
     this.aPlayer.addWeightPlayer(-(drop.getWeight()));
     this.aPlayer.removeItemPlayer(vItem);
     this.aGui.println(this.aPlayer.getItemPlayerList().getItemString("Players items: "));
     this.aGui.println(this.aPlayer.getRoom().getItemRoom().getItemString("Items of the room: "));

    }//drop()

    /**
     * gere les attaques dans le jeu
     *  @param pmonstre
     *  
     */
    private void attack(final String pmonstre)
    {   if (this.aPlayer.getItemPlayer("sword")==null)
        {
            this.aGui.println("You don't have a sword to fight. The Monster killed you within a second" +"\n" + "You lost.");
            this.aGui.entryfield(false);
            return;
        }
        if( this.aPlayer.getRoom().getMonsterList().getMonster(pmonstre)==null)
        {
            this.aGui.println(pmonstre + " is not existing or not here");
            return;
                
            
        }
        int vSwordDmg=this.aPlayer.getItemPlayer("sword").getWeight();   
        Monster lemonstre=this.aPlayer.getRoom().getMonsterList().getMonster(pmonstre);
        this.aPlayer.getRoom().getMonsterList().getMonster(pmonstre).ReplaceHp(vSwordDmg);
        this.aGui.println(lemonstre.getMonsterName()+" has "+this.aPlayer.getRoom().getMonsterList().getMonster(pmonstre).getMonsterHP()+" HP left");

        if (lemonstre.getMonsterHP()==0)
    {
        if(lemonstre.monstremort(pmonstre)==0) // Warwick est mort
        {
            
                this.aPlayer.getRoom().getExits("level2").setAcessRoom(true);
                aGui.println("You can go to the next "+"level" +"of the mountain.");
            
                this.aGui.println(lemonstre.getMonsterName() + " is dead !");
                this.aPlayer.getRoom().getMonsterList().removeMonster(lemonstre.getMonsterName());
                this.aGui.println(this.aPlayer.getRoom().getMonsterList().getMonsterString("Monsters alive : 0"));
                this.aPlayer.setPlayerHp(30);
                this.aGui.println("Your hp are restaured : "+this.aPlayer.getPlayerHp());
        }
        if(lemonstre.monstremort(pmonstre)==1) // Aatrox est mort
        {
            
                this.aPlayer.getRoom().getExits("level3").setAcessRoom(true);
                aGui.println("You can go to the next "+"level" +"of the mountain.");
            
                this.aGui.println(lemonstre.getMonsterName() + " is dead !");
                this.aPlayer.getRoom().getMonsterList().removeMonster(lemonstre.getMonsterName());
                this.aGui.println(this.aPlayer.getRoom().getMonsterList().getMonsterString("Monsters alive : 0 "));
                this.aPlayer.setPlayerHp(30);
                this.aGui.println("Your hp are restaured : "+this.aPlayer.getPlayerHp());
        }
        if(lemonstre.monstremort(pmonstre)==2) // Hecarim est mort
        {
            
                this.aPlayer.getRoom().getExits("rewardobjectroom").setAcessRoom(true);
                aGui.println("You can go to the next "+"level" +"of the mountain.");
            
                this.aGui.println(lemonstre.getMonsterName() + " is dead !");
                this.aPlayer.getRoom().getMonsterList().removeMonster(lemonstre.getMonsterName());
                this.aGui.println(this.aPlayer.getRoom().getMonsterList().getMonsterString("Monsters alive : 0 "));
                this.aPlayer.setPlayerHp(30);
                this.aGui.println("Your hp are restaured : "+this.aPlayer.getPlayerHp());
        }
        
    }

        if(this.aPlayer.getRoom().getMonsterList().containsMonster("Warwick")==true)
        {
        this.aGui.println("Warwick strikes back !");
        this.aPlayer.addPlayerHp(-5);
        if (this.aPlayer.getPlayerHp()<=0)
        {
            this.aPlayer.setPlayerHp(0);
        }
        this.aGui.println("Your Hp are "+this.aPlayer.getPlayerHp());
        }

        if(this.aPlayer.getRoom().getMonsterList().containsMonster("Aatrox")==true)
        {
            this.aGui.println("Aatrox strikes back !");
            this.aPlayer.addPlayerHp(-7);
            if (this.aPlayer.getPlayerHp()<=0)
            {
                this.aPlayer.setPlayerHp(0);
            }
            this.aGui.println("Your Hp are "+this.aPlayer.getPlayerHp());

        }

        if(this.aPlayer.getRoom().getMonsterList().containsMonster("Hecarim")==true)
        
        {
            this.aGui.println("Hecarim strikes back !");
            this.aPlayer.addPlayerHp(-9);

            if (this.aPlayer.getPlayerHp()<=0)
            {
                this.aPlayer.setPlayerHp(0);
            }
            this.aGui.println("Your Hp are "+this.aPlayer.getPlayerHp());
        }
        if(lemonstre.monstremort(pmonstre)==3) // Volibear est mort
        {
            
                this.aPlayer.setPlayerHp(25);
                
                fichier("endgame");
                return;
        }
        
        if(this.aPlayer.getRoom().getMonsterList().containsMonster("Volibear")==true)
        
        {
            this.aGui.println("Volibear strikes back !");
            this.aPlayer.addPlayerHp(-10);

            if (this.aPlayer.getPlayerHp()<=0)
            {
                this.aPlayer.setPlayerHp(0);
            }
            this.aGui.println("Your Hp are "+this.aPlayer.getPlayerHp());  
        }
        
        if (this.aPlayer.getPlayerHp()<=0 )
        {   this.aPlayer.setPlayerHp(0);
            this.aGui.println("You are dead, Game Over");
            this.aGui.entryfield(false);
            return;
        }    
    }//attack()

    /**
     * fonction quit permet de quitter le jeu
     * @param pCom
     * @return true si on quitte le jeu et false sinon
     */

    private boolean quit(final Command pCom)
    {
        if(pCom.hasSecondWord()==false) {this.aGui.println("Quit what");
            return false;}
        
        if(pCom.getSecondWord()!="game" || pCom.getSecondWord()!="Game")
        {
            {  this.aGui.println( "Thank you for playing.  Good bye." );
               this.aGui.entryfield(false);
               return true;
            }
        }
        return false;

    }//quit()

    

private int aTentatives=3;
/**
 * gere les reponses d'enigmes dans le jeu
 * @param pCom
 * @return true or false 
 */
private boolean enigmes(final Command pCom)
{
    
    if(pCom.getSecondWord().equals("nothing") && this.aPlayer.getRoom().getDescription().equals("Enigma Room 1"))
    {
        this.aGui.println("Well done you can go.");
        this.aPlayer.getRoom().getExits("level2").setAcessRoom(true);
        this.aTentatives=3;
        return true;
    }
    
    if(pCom.getSecondWord().equals("shadow") && this.aPlayer.getRoom().getDescription().equals("Enigma Room 2"))
    {
        this.aGui.println("Well done you can go.");
        this.aPlayer.getRoom().getExits("fightingroom2").setAcessRoom(true);
        this.aTentatives=3;
        return true;
    }
    if(pCom.getSecondWord().equals("time") && this.aPlayer.getRoom().getDescription().equals("Enigma Room 3"))
    {
        this.aGui.println("Well done you can go.");
        this.aPlayer.getRoom().getExits("fightingroom3").setAcessRoom(true);
        this.aTentatives=3;
        return true;
    }
    
    else 
    {
        if(this.aPlayer.getRoom().getDescription().equals("Enigma Room 1") ||this.aPlayer.getRoom().getDescription().equals("Enigma Room 2")||this.aPlayer.getRoom().getDescription().equals("Enigma Room 3"))
        {
        this.aTentatives-=1;
        this.aGui.println("Wrong answer."+"\n"+"You have "+this.aTentatives+" try left.");
        }
        if(this.aTentatives==0)
        {
            this.aGui.println("You lost");
            this.aGui.entryfield(false);
        }
    return false;
    }
    
    

}



} // Game
