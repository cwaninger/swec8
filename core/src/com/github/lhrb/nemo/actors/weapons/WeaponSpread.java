package com.github.lhrb.nemo.actors.weapons;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.github.lhrb.nemo.actors.shots.SingleShot;
import com.github.lhrb.nemo.util.SoundManager;

public class WeaponSpread extends Weapon {
    private float angleModifier;

    public WeaponSpread(Stage stage) {
        super(stage, 0.6f);
        angleModifier = 45;
    }

    public WeaponSpread(Stage stage, float cooldown) {
        super(stage, cooldown);
    }

    public WeaponSpread(Stage stage, float cooldown,float angleModifier) {
        super(stage, cooldown);
        this.angleModifier = angleModifier;
    }

    @Override
    public void fire(float x, float y, float angle) {
        if (isReady()) {
            new SingleShot(x, y, getStage(), angle - angleModifier);
            new SingleShot(x, y, getStage(), angle);
            new SingleShot(x, y, getStage(), angle + angleModifier);
            resetCooldownTimer();

            SoundManager.getInstance().playSound("laser");
        }
    }
}
