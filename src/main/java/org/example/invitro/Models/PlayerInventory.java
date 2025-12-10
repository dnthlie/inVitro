package org.example.invitro.Models;

import java.util.ArrayList;

public class PlayerInventory {
    //singleton Instance of a player Inventory
    private static final PlayerInventory instance = new PlayerInventory();
    public static PlayerInventory getInstance() {return instance;}

    //Arraylist that hold all items
    private ArrayList<Items> items = new ArrayList<>();

    private PlayerInventory() {}

    //add item
    public void addItem(Items item) {
        items.add(item);
    }
    //remove item
    public boolean removeItem(Items item) {
        return items.remove(item);
    }

    //return the arralist of items
    public ArrayList<Items> getItems() {
        return items;
    }

    //check if player has item
    public boolean hasItem(Items item) {
        for (Items i : items) {
            if (i.getName().equals(item.getName())) {
                return true;
            }
        }
        return false;
    }
}
