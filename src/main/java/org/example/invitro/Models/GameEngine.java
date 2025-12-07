package org.example.invitro.Models;


import java.util.Scanner;

public class GameEngine {
    //Creating room objects. **NOTE** Cant pass in rooms for prev/next rooms until all rooms objects are instantiated
    //So we use setAdjacentRooms in GameApplication
    public static Room title = new Room("Title", "This is the title screen", false, "/org/example/invitro/Assets/room images/TitleCard.png");
    public static Room entrance = new Room("Entrance", "A cold metal room with a strange alien looking at you", false, "/org/example/invitro/Assets/room images/Entrance.png");
    public static Room crate = new Room("Crate", "A mostly empty room with a crate directly in the middle and a door on the left", false,"/org/example/invitro/Assets/room images/Crate.png");
    public static Room chamber = new Room("Chamber", "A confined room with what looks to be some form of chamber and a control panel",true,"/org/example/invitro/Assets/room images/Chamber.png");
    public static Room window = new Room("Window", "A large window with 4 strange creatures that appear to be observing you", true,"/org/example/invitro/Assets/room images/Window.png");



    public GameEngine() {
    }

    public static void main(String[] args) {


        //TESTING GAME LOGIC

        //INPUT SCANNER
        Scanner scanner = new Scanner(System.in);

        //LOOP INPUT SCAN
        while (true) {
            String input = scanner.nextLine();
            if(input.equals("quit")) {
                System.out.println("Goodbye! Thanks for playing.");
                break;
            }
            processCommand(input);
        }

        /////////// ROOM TEST
//        Room startRoom;
//
//        Room darkPlace = new Room("Dark place", "Can't see where I am, smells funny", false);
//        darkPlace.enterRoom();
    }

    //METHODS FOR COMMANDS
    private static void processCommand(String command) {
        switch (command.toLowerCase()) {
            //DISPLAY COMMANDS
            case "help":
                break;
            case "inventory":
                break;
            default:
                System.out.println("Unkown command. Type 'help' to see command list");
        }
    }
    public static void initializeRooms(){
        title.setAdjacentRooms(entrance,null);
        entrance.setAdjacentRooms(crate, title);
        crate.setAdjacentRooms(chamber, entrance);
        chamber.setAdjacentRooms(window, crate);
        window.setAdjacentRooms(null, chamber);
    }
}

