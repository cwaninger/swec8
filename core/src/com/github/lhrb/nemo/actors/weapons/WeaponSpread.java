package com.github.lhrb.nemo.actors.weapons;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.github.lhrb.nemo.actors.shots.SingleShot;
import com.github.lhrb.nemo.util.SoundManager;

public class WeaponSpread extends Weapon {
    public WeaponSpread(Stage stage) {
        super(stage, 0.6f);
    }

    public WeaponSpread(Stage stage, float cooldown) {
        super(stage, cooldown);
    }

    @Override
    public void fire(float x, float y, float angle) {
        if (isReady()) {
            new SingleShot(x, y, getStage(), angle-45);
            new SingleShot(x, y, getStage(), angle);
            new SingleShot(x, y, getStage(), angle+45);
            resetCooldownTimer();

            SoundManager.getInstance().playSound("laser");
        }
    }
}
