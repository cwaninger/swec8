package com.github.lhrb.nemo.actors.powerups;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.github.lhrb.nemo.actors.ActorPrefab;
import com.github.lhrb.nemo.util.AnimationLoader;

public class ActivePowerUPIcon extends ActorPrefab {
    public ActivePowerUPIcon(String type, Stage stage){
        super(725, 100, stage);
        switch (type) {
                case "bomb":
                    setAnimation(AnimationLoader.get().texture("powerup_bombe.png"));
                    break;
                case "multiplicator":
                    setAnimation(AnimationLoader.get().texture("powerup_multiplicator.png"));
                    break;
                case "shield":
                    setAnimation(AnimationLoader.get().texture("powerup_shield.png"));
                    break;
                case "star":
                    setAnimation(AnimationLoader.get().texture("powerup_star.png"));
                    break;
                default:
                    // no texture
            }
        }
    }
