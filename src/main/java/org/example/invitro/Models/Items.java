package org.example.invitro.Models;

public class Items {
    //Attributes
    String name;
    String description;
    boolean playerHas;

    //Constructor
    public Items(String name,String description){
        this.name=name;
        this.description=description;
        this.playerHas=false;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }

}
