package org.example.invitro.Controller;
import org.example.invitro.Models.Items;
import org.example.invitro.Models.Room;
import java.util.ArrayList;


public class RoomController {



    //Creating room objects. **NOTE** Cant pass in rooms for prev/next rooms until all rooms objects are instantiated
    //So we use setAdjacentRooms in GameApplication
    public static Room title = new Room("Title", "This is the title screen", false, "/org/example/invitro/Assets/room images/TitleCard.png",null);
    public static Room entrance = new Room("Entrance", "A cold metal room with a strange alien observing you through a window", false, "/org/example/invitro/Assets/room images/Entry.png",null);
    public static Room crate = new Room("Crate", "A mostly empty room with a crate directly in the middle and a door on the left", false,"/org/example/invitro/Assets/room images/Crate.png",null);
    public static Room chamber = new Room("Chamber", "A confined room with what looks to be some form of chamber and a control panel",true,"/org/example/invitro/Assets/room images/Chamber.png",null);
    public static Room window = new Room("Window", "A large window with 4 strange creatures that appear to be observing you", true,"/org/example/invitro/Assets/room images/Window.png",null);



    public static void initializeRooms(){
        title.setAdjacentRooms(entrance,null);
        entrance.setAdjacentRooms(crate, title);
        crate.setAdjacentRooms(chamber, entrance);
        chamber.setAdjacentRooms(window, crate);
        window.setAdjacentRooms(null, chamber);
    }
    public static void intializeRoomItems(){
        Items keycard = new Items("KeyCard","This keycard could grant access to a door");
        ArrayList<Items> crateRoomItems = new ArrayList<Items>();
        crateRoomItems.add(keycard);
        crate.setItems(crateRoomItems);
    }

}

