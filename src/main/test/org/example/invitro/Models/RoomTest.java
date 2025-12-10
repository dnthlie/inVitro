package org.example.invitro.Models;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// Andrew
// This test class was made to validate the functionality of
// our Room class. The main focus was on the ability to add adjacent
// Room objects to build out the map that the player can traverse
public class RoomTest {

    private static Room testRoom;

    @BeforeAll
    public static void testSetup() {
        testRoom = new Room("Title", "This is the title screen", false, "/org/example/invitro/Assets/room images/TitleCard.png",null);
    }

    @BeforeEach
    void init() {
    }

    @AfterAll
    public static void testCleanup() {
        // Do your cleanup here like close URL connection , releasing resources etc
    }

    // Andrew
    // Test the instantiation of Room objects along with their basic getters
    @Test
    public void test_getters() {
        assertEquals("Title", testRoom.getRoomName());
        assertEquals("This is the title screen", testRoom.getDescription());
        assertEquals("/org/example/invitro/Assets/room images/TitleCard.png", testRoom.getImageURL());
    }

    // Andrew
    // Test the ability to add adjacent Room objects and access those
    // Room objects
    @Test
    public void test_adjacent_rooms() {
        Room nextRoom = new Room("Entrance", "A cold metal room with a strange alien looking at you", false, "/org/example/invitro/Assets/room images/Entrance.png",null);

        testRoom.setAdjacentRooms(nextRoom,null);

        assertNotNull(testRoom.getNextRoom());
        assertEquals("Entrance", testRoom.getNextRoom().getRoomName());
    }

}