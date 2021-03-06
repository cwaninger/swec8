package com.github.lhrb.nemo.actors.shots;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.github.lhrb.nemo.actors.CollisionEvent;
import com.github.lhrb.nemo.actors.PhysicalActor;
import com.github.lhrb.nemo.actors.powerups.CType;

public abstract class Shots extends PhysicalActor {

    private final float angle;
    public boolean isPlayerShot;

    public Shots(float x, float y, Stage stage, float angle) {
        super(x, y, stage);

        this.angle = angle;
        if (angle > 0 && angle < 180) isPlayerShot = true;
        else isPlayerShot = false;
        rotateBy(angle-90);
        setX(getX()-(getWidth()/2));
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        accelerationAtAngle(angle);

        if (getY() <= getStage().getHeight()) {
            applyPhysics(delta);
        }
        else {
            remove();
        }

        /**
         * ATTENTION
         * this method does not provide any security mechanism
         */
        //setWorldBounds();

    }

    /* (non-Javadoc)
     * @see com.github.lhrb.nemo.actors.PhysicalActor#collision()
     */
    @Override
    public void collision() {
        if (!(this instanceof Bomb.Explosion))
            remove();
    }

    public boolean isPlayerShot() { return isPlayerShot; }

}
