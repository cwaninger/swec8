package com.github.lhrb.nemo.util;

import java.io.*;
import java.util.ArrayList;

public class Serialization {
    public void serialise(ArrayList<Highscore> toSave){
        try {
            FileOutputStream fs = new FileOutputStream("Highscore.s");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(toSave);
            os.close();
        }catch (IOException e) {
            //TODO optimise exception handling
            e.printStackTrace();
        }
    }

    public ArrayList<Highscore>  deserialise(){
        File test = new File("Highscore.s");
        try {
            if (test.exists()) {
                FileInputStream fs = new FileInputStream("Highscore.s");
                try (ObjectInputStream objectInputStream = new ObjectInputStream(fs)) {
                    return (ArrayList<Highscore> ) objectInputStream.readObject();
                }
            }
        }catch (IOException|ClassNotFoundException e){
            //TODO optimise exception handling
            e.printStackTrace();
        }
        return new ArrayList<Highscore>();
    }
}
