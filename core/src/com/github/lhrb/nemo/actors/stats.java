package com.github.lhrb.nemo.actors;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.IOException;
import java.io.File;


public class stats implements Serializable{
    //stores the players current health
    public int health;
    //stores the highest lvl the player currently reached
    public int lvl;
    //stores the players score
    public int score;
    //Stores the current selected Weapon
    //TODO Change into Weapon type when merged
    public Object Weapon;
    //Stores the Players currently selected Item
    //TODO Needs to be changed into item class when merged
    public Object PowerUP;
    public stats(int health,int lvl,int score,Object Weapon,Object PowerUP){
        this.health=health;
        this.lvl=lvl;
        this.score=score;
        this.Weapon=Weapon;
        this.PowerUP =PowerUP;
    }

    public void serialise(){
        try {
            FileOutputStream fs = new FileOutputStream("stats.s");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(this);
            os.close();
        }catch (IOException e) {
            //TODO optimise exception handling
        e.printStackTrace();
    }
    }

    public void deserialise(){
        File test = new File("stats.s");
        try {
            if (test.exists()) {
                FileInputStream fs = new FileInputStream("stats.s");
                try (ObjectInputStream objectInputStream = new ObjectInputStream(fs)) {
                    //TODO implement lust or something to deserialise
                     (stats) objectInputStream.readObject();
                }
            }
        }catch (IOException|ClassNotFoundException e){
            //TODO optimise exception handling
            e.printStackTrace();
        }

    }
}
