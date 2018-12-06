package com.github.lhrb.nemo.actors.shots;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.github.lhrb.nemo.actors.ActorPrefab;
import com.github.lhrb.nemo.util.AnimationLoader;

public class Laser extends Shots {

    public Laser(float x, float y, Stage stage, float angle) {
        super(x, y, stage, angle);

        setAnimation(AnimationLoader.get().texture("SchussLaser.png"));
        setSpeedMax(1600);
        setAcceleration(30000);
        setShapePolygon(8);

        setX(getX()-(getWidth()/2)+1);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void collision() {
        // Don't remove laser when enemy is hit
    }
}
