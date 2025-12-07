// 11/12/25 - may change later for something more simplified for UI?

package org.example.invitro.Models;

public class Room {

    ///////// DATA VARIABLES
    private String roomName;                                    //Room name
    private String description;                                 //Description of room
    private boolean isLocked;                                   //Is room locked
    private Room nextRoom;
    private Room prevRoom;
    private String imageURL;
    //Add more later

    ///////// FULL CONSTRUCTOR
    public Room(String roomName, String description, boolean isLocked, String imageURL) {
        this.roomName = roomName;
        this.description = description;
        this.isLocked = isLocked;
        this.imageURL = imageURL;
        this.nextRoom = nextRoom;
        this.prevRoom = prevRoom;
    }

    ///////// DEFAULT CONSTRUCTOR
    public Room() {
        this.roomName = "";
        this.description = "";
        this.isLocked = false;
        this.imageURL = "";
        this.nextRoom = null;
        this.prevRoom = null;
    }

    ///////// COPY CONSTRUCTOR
    public Room(Room otherRoom) {
        this.roomName = otherRoom.roomName;
        this.description = otherRoom.description;
        this.isLocked = otherRoom.isLocked;
        this.imageURL = otherRoom.imageURL;
        this.nextRoom = otherRoom.nextRoom;
        this.prevRoom = otherRoom.prevRoom;
    }

    ///////// GETTERS
    public String getRoomName() {
        return roomName;
    }

    public String getDescription() {
        return description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public Room getNextRoom() {
        return nextRoom;
    }
    public Room getPrevRoom() {
        return prevRoom;
    }


    public boolean isLocked() {
        return isLocked;
    }

    ///////// SETTERS
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public void setAdjacentRooms(Room nextRoom, Room prevRoom) {
        this.nextRoom = nextRoom;
        this.prevRoom = prevRoom;
    }

    /*********** TESTING ***********/
    //@Test
    public void enterRoom() {
        if (isLocked) {
            System.out.println("LOCKED ROOM: " + roomName);
        } else {
            System.out.println("UNLOCKED ROOM: " + roomName);
        }
    }


    @Override
    public String toString() {
        return String.format("Room: %s - %s%n %s", roomName, description, isLocked);
    }

}
