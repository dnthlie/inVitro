package org.example.invitro.Models;

import java.util.ArrayList;
import java.util.Iterator;
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
    private ArrayList<Items> items;
    //Add more later

    ///////// FULL CONSTRUCTOR
    public Room(String roomName, String description, boolean isLocked, String imageURL, ArrayList<Items> items) {
        this.roomName = roomName;
        this.description = description;
        this.isLocked = isLocked;
        this.imageURL = imageURL;
        this.items = items;
        this.nextRoom = nextRoom;
        this.prevRoom = prevRoom;
        this.unlockedMessage = "Room is unlocked!!";
        this.lockedMessage = "This room is locked!";

    }

    ///////// DEFAULT CONSTRUCTOR
    public Room() {
        this.roomName = "";
        this.description = "";
        this.isLocked = false;
        this.imageURL = "";
        this.nextRoom = null;
        this.prevRoom = null;
        this.items = null;
    }

    ///////// COPY CONSTRUCTOR
    public Room(Room otherRoom) {
        this.roomName = otherRoom.roomName;
        this.description = otherRoom.description;
        this.isLocked = otherRoom.isLocked;
        this.imageURL = otherRoom.imageURL;
        this.nextRoom = otherRoom.nextRoom;
        this.prevRoom = otherRoom.prevRoom;
        this.items = otherRoom.items;

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
    public ArrayList<Items> getItems() {
        return items;
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
    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    public boolean removeRoomItem(String itemName) {
        Iterator<Items> it = items.iterator();
        while (it.hasNext()) {
            Items item = it.next();
            if (item.getName().equalsIgnoreCase(itemName)) {
                it.remove();
                System.out.println("Item with name " + itemName + " removed");
                return true;
            }
        }
        System.out.println("Item with name " + itemName + " not found");
        return false;
    }
/*
    public void addItem(String item) {
        items.add(item);
    }*/


/*
    public boolean hasAllKeyItems(List<String> itemInInventory) {
        return itemInInventory.containsAll(keyItems);
    }*/

    @Override
    public String toString() {
        return String.format("Room: %s - %s%n %s", roomName, description, isLocked);
    }

}
