package com.github.lhrb.nemo.actors.weapons;

import com.github.lhrb.nemo.actors.ActorPrefab;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.github.lhrb.nemo.util.AnimationLoader;

public class ActiveWeaponIcon extends ActorPrefab {
    public ActiveWeaponIcon(String type, Stage stage){
        super(0,0,stage);

        switch (type) {
            case "normal":
                setAnimation(AnimationLoader.get().texture("IconNormal.png"));
                break;
            case "spread":
                setAnimation(AnimationLoader.get().texture("IconSpread.png"));
                break;
            case "laser":
                setAnimation(AnimationLoader.get().texture("IconLaser.png"));
                break;
            default:
                // no texture
        }
    }
}
