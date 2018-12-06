package com.github.lhrb.nemo.actors;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.github.lhrb.nemo.util.AnimationLoader;

public class Background extends ActorPrefab {
    // stores the starting positon of the background
    // as we need two backgrounds, this is important to save the start
    private static float initialPosition;

    public Background(float x, float y, Stage stage, int level) {
        super(x,y,stage);
        String fileName;
        initialPosition = y;

        switch (level) {
            case 1:
                fileName = "bg1.png";
                break;
            case 2:
                fileName = "bg2.png";
                break;
            case 3:
                fileName = "bg3.png";
                break;
            default:
                fileName = "bg1.png";
                break;
        }
        setAnimation(AnimationLoader.get().texture(fileName));
        setAcceleration(200);
        setSpeedMax(200);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (getY() <=  -initialPosition) {
            float yDelta = (getY() * -1) - initialPosition;
            setY(initialPosition - yDelta);
        }

        accelerationAtAngle(270);
        applyPhysics(delta);
    }



}
