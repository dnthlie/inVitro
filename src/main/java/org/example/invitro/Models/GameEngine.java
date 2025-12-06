package org.example.invitro.Models;


import java.util.Scanner;

public class GameEngine {
    public static Room currentRoom = new Room("Entrance", "A cold metal room with a strange alien looking at you", false, "@Assets/1_Alien_Image.png", null, null);

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
}
