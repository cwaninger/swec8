package com.github.lhrb.nemo.actors.weapons;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.github.lhrb.nemo.actors.shots.SingleShot;
import com.github.lhrb.nemo.util.SoundManager;

public class WeaponNormal extends Weapon {
    public WeaponNormal(Stage stage) {
        super(stage, 0.4f);
    }

    public WeaponNormal(Stage stage, float cooldown) {
        super(stage, cooldown);
    }

    @Override
    public void fire(float x, float y, float angle) {
        if (isReady()) {
            new SingleShot(x, y, getStage(), angle);
            resetCooldownTimer();

            SoundManager.getInstance().playSound("laser");
        }
    }
}
