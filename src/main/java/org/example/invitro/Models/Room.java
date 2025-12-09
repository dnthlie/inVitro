package org.example.invitro.Models;

import java.util.ArrayList;
import java.util.List;

public class Room {

    ///////// DATA VARIABLES
    private String roomName;                                    //Room name
    private String description;                                 //Description of room
    private boolean isLocked;                                   //Is room locked
    private Room nextRoom;
    private Room prevRoom;
    private String unlockedMessage;
    private String lockedMessage;
    private String imageURL;
    private List<String> items;                                 //interactable items
    private List<String> keyItems;                              //items key to unlocking

    ///////// FULL CONSTRUCTOR
    public Room(String roomName, String description, boolean isLocked, String imageURL) {
        this.roomName = roomName;
        this.description = description;
        this.isLocked = isLocked;
        this.imageURL = imageURL;
        this.nextRoom = nextRoom;
        this.prevRoom = prevRoom;
        this.unlockedMessage = "Room is unlocked!!";
        this.lockedMessage = "This room is locked!";
        this.keyItems = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    ///////// DEFAULT CONSTRUCTOR
    public Room() {
        this.roomName = "";
        this.description = "";
        this.isLocked = false;
        this.imageURL = "";
        this.nextRoom = null;
        this.prevRoom = null;
        this.keyItems = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    ///////// COPY CONSTRUCTOR
    public Room(Room other) {
        this.roomName = other.roomName;
        this.description = other.description;
        this.isLocked = other.isLocked;
        this.imageURL = other.imageURL;
        this.nextRoom = other.nextRoom;
        this.prevRoom = other.prevRoom;
        this.items = new ArrayList<>(other.items);
        this.keyItems = new ArrayList<>(other.keyItems);

    }



    ///////// GETTERS
    public String getRoomName() {
        return roomName;
    }
    public String getDescription() {
        return description;
    }
    public boolean isLocked() { return isLocked; }
    public String getImageURL() {
        return imageURL;
    }
    public Room getNextRoom() {
        return nextRoom;
    }
    public Room getPrevRoom() {
        return prevRoom;
    }
    public String getUnlockedMessage() { return unlockedMessage; }
    public String getLockedMessage() { return lockedMessage; }

    ///////// SETTERS
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setLocked(boolean locked) {
        this.isLocked = locked;
    }
    public void setUnlockedMessage(String unlockedMessage) { this.unlockedMessage = unlockedMessage; }
    public void setLockedMessage(String lockedMessage) { this.lockedMessage = lockedMessage; }


    ///////// METHODS
    public void setAdjacentRooms(Room nextRoom, Room prevRoom) {
        this.nextRoom = nextRoom;
        this.prevRoom = prevRoom;
    }

    public void addItem(String item) {
        items.add(item);
    }

    public List<String> getItems() {
        return items;
    }

    public boolean hasAllKeyItems(List<String> itemInInventory) {
        return itemInInventory.containsAll(keyItems);
    }

    @Override
    public String toString() {
        return String.format("Room: %s - %s%n %s", roomName, description, isLocked);
    }

}
