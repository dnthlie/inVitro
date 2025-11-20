// 11/12/25 - may change later for something more simplified for UI?

package org.example.invitro.Models;

public class Room {

    ///////// DATA VARIABLES
    private String roomName;                                    //Room name
    private String description;                                 //Description of room
    private boolean isLocked;                                   //Is room locked
    //Add more later

    ///////// FULL CONSTRUCTOR
    public Room(String roomName, String description, boolean isLocked) {
        this.roomName = roomName;
        this.description = description;
        this.isLocked = isLocked;
    }

    ///////// DEFAULT CONSTRUCTOR
    public Room() {
        this.roomName = "";
        this.description = "";
        this.isLocked = false;
    }

    ///////// COPY CONSTRUCTOR
    public Room(Room otherRoom) {
        this.roomName = otherRoom.roomName;
        this.description = otherRoom.description;
        this.isLocked = otherRoom.isLocked;
    }

    ///////// GETTERS
    public String getRoomName() {
        return roomName;
    }

    public String getDescription() {
        return description;
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
