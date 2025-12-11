package org.example.invitro.Models;
import static org.junit.jupiter.api.Assertions.*;

import org.example.invitro.Controller.MainWindowController;
import org.junit.jupiter.api.Test;

public class MainWindowInputTest {

    @Test //Ted - tests that the validate_input function is working correctly for a single word
    void validateOneWordInputTest(){
        MainWindowController mainWindowController = new MainWindowController();
        String[] test_string = mainWindowController.validate_input("look");
        String[] expected_string = {"look", null};
        assertArrayEquals(expected_string,test_string);

    }
    @Test //Ted - tests that the validate_input function is working correctly for  two words
    void validateTwoWordInputTest(){
        MainWindowController mainWindowController = new MainWindowController();
        String[] test_string = mainWindowController.validate_input("open door");
        String[] expected_string = {"open", "door"};
        assertArrayEquals(expected_string,test_string);
    }
    @Test //Ted tests that the validate_input function is throwing an error when an unrecognized word is put in
    void validateNonRecognizedOneWordInputTest(){
        MainWindowController mainWindowController = new MainWindowController();
        assertThrows(IllegalArgumentException.class, ()->{mainWindowController.validate_input("Hello");});
    }
    @Test //Ted tests that the validate_input function is throwing an error when two unrecognized words are put in
    void validateNonRecognizedTwoWordInputTest(){
        MainWindowController mainWindowController = new MainWindowController();
        assertThrows(IllegalArgumentException.class, ()->{mainWindowController.validate_input("Hello World");});
    }
    @Test //Ted tests that entering too many words is handled
    void validateThreeWordInputTest(){
        MainWindowController mainWindowController = new MainWindowController();
        assertThrows(IllegalArgumentException.class, ()->{mainWindowController.validate_input("Go to Door");});
    }

}
