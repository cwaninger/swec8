package com.github.lhrb.nemo.actors.shots;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.github.lhrb.nemo.actors.ActorPrefab;
import com.github.lhrb.nemo.util.AnimationLoader;

public class SingleShot extends Shots {

    //private final float angle;

    public SingleShot(float x, float y, Stage stage, float angle) {
        super(x, y, stage, angle);

        setAnimation(AnimationLoader.get().texture("SchussStandart.png"));
        setSpeedMax(800);
        setAcceleration(30000);
        setShapePolygon(8);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
