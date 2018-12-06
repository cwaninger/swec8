package com.github.lhrb.nemo.actors.enemies;

import com.github.lhrb.nemo.actors.weapons.Weapon;
import com.github.lhrb.nemo.actors.weapons.WeaponNormal;
import com.github.lhrb.nemo.util.AnimationLoader;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class EnemyOne extends Enemy {
    public EnemyOne(Stage stage) {
        super(stage);
    }
    /**
     * Simple Enemie Implementation
     * @author Thorsten Rösler
     *
     */

    private Weapon weaponleft;
    private Weapon weaponright;

    public void setCharacteristics(Stage stage) {
        setAnimation(AnimationLoader.get().texture("gegner1.png"));
        setRotation(180);
        setAcceleration(1000);
        setSpeedMax(75);
        setDeceleration(1000000);
        setShapePolygon(8);

        hp = 2;
        scoreValue = 1;

        weaponleft = new WeaponNormal(stage, 2f);
        weaponright = new WeaponNormal(stage, 2f);
    }

        /**
         * input handling
         */
        @Override
        public void act(float delta) {
            super.act(delta);
            accelerationAtAngle(270);

            applyObjectPhysics(delta);

            if (getStage() != null && getY()+20 < getStage().getHeight()) {
                weaponleft.fire(getX() + (getWidth() / 2) - 20, getY() - 30, 270);
                weaponright.fire(getX() + (getWidth() / 2) + 20, getY() - 30, 270);
            }
        }

}
