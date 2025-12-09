package org.example.invitro.Models;
import static org.junit.jupiter.api.Assertions.*;

import org.example.invitro.Controller.MainWindowController;
import org.junit.jupiter.api.Test;

public class MainWindowInputTest {

    @Test //Ted
    void validateOneWordInputTest(){
        MainWindowController mainWindowController = new MainWindowController();
        String[] test_string = mainWindowController.validate_input("look");
        String[] expected_string = {"look", null};
        assertArrayEquals(expected_string,test_string);

    }
    @Test //Ted
    void validateTwoWordInputTest(){
        MainWindowController mainWindowController = new MainWindowController();
        String[] test_string = mainWindowController.validate_input("open door");
        String[] expected_string = {"open", "door"};
        assertArrayEquals(expected_string,test_string);
    }
    @Test //Ted
    void validateNonRecognizedOneWordInputTest(){
        MainWindowController mainWindowController = new MainWindowController();
        assertThrows(IllegalArgumentException.class, ()->{mainWindowController.validate_input("Hello");});
    }
    @Test //Ted
    void validateNonRecognizedTwoWordInputTest(){
        MainWindowController mainWindowController = new MainWindowController();
        assertThrows(IllegalArgumentException.class, ()->{mainWindowController.validate_input("Hello World");});
    }
    @Test //Ted
    void validateThreeWordInputTest(){
        MainWindowController mainWindowController = new MainWindowController();
        assertThrows(IllegalArgumentException.class, ()->{mainWindowController.validate_input("Go to Door");});
    }

}
