package com.github.lhrb.nemo.actors.enemies;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.github.lhrb.nemo.actors.weapons.Weapon;
import com.github.lhrb.nemo.actors.weapons.WeaponSpread;
import com.github.lhrb.nemo.util.AnimationLoader;

public class EnemyTwo extends Enemy {
    public EnemyTwo(Stage stage) {
        super(stage);
    }
    /**
     * Simple Enemie Implementation
     * @author Thorsten Rösler
     *
     */

    private Weapon weapon;

    public void setCharacteristics(Stage stage) {
        
        setAnimation(AnimationLoader.loadTexture("gegner2.png"));
        //setRotation(180);
        setAcceleration(30);
        setSpeedMax(30);
        setDeceleration(1000000);
        setShapePolygon(8);

        weapon = new WeaponSpread(stage,1.3f);
    }

    /**
     * input handling
     */
    @Override
    public void act(float delta) {
        super.act(delta);
        accelerationAtAngle(270);

        applyObjectPhysics(delta);

        weapon.fire(getX()+(getWidth()/2),getY()-40, 270);
    }
}