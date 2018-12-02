package com.github.lhrb.nemo.util;

import com.github.lhrb.nemo.actors.Player;
import com.github.lhrb.nemo.actors.Stats;

import java.io.*;

public class Serialization {
    public void serialise(Stats toSave){
        try {
            FileOutputStream fs = new FileOutputStream("Stats.s");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(toSave);
            os.close();
        }catch (IOException e) {
            //TODO optimise exception handling
            e.printStackTrace();
        }
    }

    public Stats deserialise(Player player){
        File test = new File("Stats.s");
        try {
            if (test.exists()) {
                FileInputStream fs = new FileInputStream("Stats.s");
                try (ObjectInputStream objectInputStream = new ObjectInputStream(fs)) {
                    return (Stats) objectInputStream.readObject();
                }
            }
        }catch (IOException|ClassNotFoundException e){
            //TODO optimise exception handling
            e.printStackTrace();
        }
        return new Stats(player);
    }
}
