package org.example.invitro.Models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {


    Items testItem = new Items("TestItem","TestDescription");


    @Test
    public void getNameTest() {
        String testString = "TestItem";
        assertEquals(testString,testItem.getName());

    }

    @Test
    public void getDescriptionTestTest() {
        String testString = "TestDescription";
        assertEquals(testString,testItem.getDescription());

    }

}
