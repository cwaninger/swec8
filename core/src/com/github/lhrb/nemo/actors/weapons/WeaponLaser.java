package com.github.lhrb.nemo.actors.weapons;


import com.badlogic.gdx.scenes.scene2d.Stage;
import com.github.lhrb.nemo.actors.shots.Laser;
import com.github.lhrb.nemo.util.SoundManager;

public class WeaponLaser extends Weapon {
    public WeaponLaser(Stage stage) {
        super(stage, 2.0f);
    }

    public WeaponLaser(Stage stage, float cooldown) {
        super(stage, cooldown);
    }

    @Override
    public void fire(float x, float y, float angle) {
        if (isReady()) {
            new Laser(x, y, getStage(), angle);
            resetCooldownTimer();

            SoundManager.getInstance().playSound("laser");
        }
    }
}
