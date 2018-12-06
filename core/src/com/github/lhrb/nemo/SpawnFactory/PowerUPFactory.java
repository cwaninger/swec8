package com.github.lhrb.nemo.SpawnFactory;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.github.lhrb.nemo.actors.powerups.CType;
import com.github.lhrb.nemo.actors.powerups.PowerUP;

import java.util.Random;

public class PowerUPFactory {


    public PowerUPFactory() {
    }


    public static void spawnPU(float x, float y, Stage stage) {
        
        Random rand = new Random();
        //if ((rand.nextInt(10)+1) < 9) {
        CType type;
            switch (rand.nextInt(5) + 1) {
                case 1:
                    type = CType.Bomb;
                    break;
                case 2:
                    type = CType.Heart;
                    break;
                case 3:
                    type = CType.Multiplicator;
                    break;
                case 4:
                    type = CType.Shield;
                    break;
                case 5:
                    type = CType.Star;
                    break;
                default:
                    type = CType.Bomb;
                    break;
            }
            PowerUP pu = new PowerUP(x, y, stage, type);
            //stage.addActor(pu);;
      
    }
}