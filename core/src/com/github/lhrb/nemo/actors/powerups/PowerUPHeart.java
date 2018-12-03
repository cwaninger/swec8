package com.github.lhrb.nemo.actors.powerups;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.github.lhrb.nemo.actors.Player;
import com.github.lhrb.nemo.util.AnimationLoader;

public class PowerUPHeart extends PowerUP {
        public PowerUPHeart(Stage stage) {
            super(stage);
        }

        public void setCharacteristics(Stage stage) {
            setAnimation(AnimationLoader.get().texture("powerup_heart.png"));
            setAcceleration(1000);
            setSpeedMax(75);
            setDeceleration(1000000);
            setShapePolygon(8);
        }

        /**
         * input handling
         */
        @Override
        public void act(float delta) {
            super.act(delta);
            accelerationAtAngle(270);
            applyObjectPhysics(delta);
        }
}