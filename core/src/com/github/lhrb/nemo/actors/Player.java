/**
 * 
 */
package com.github.lhrb.nemo.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.github.lhrb.nemo.actors.enemies.Enemy;
import com.github.lhrb.nemo.actors.weapons.*;
import com.github.lhrb.nemo.util.AnimationLoader;

/**
 * Simple player Implementation
 * @author exa
 * 
 */
public class Player extends PhysicalActor {

    private Weapon weapon;
    private ActiveWeaponIcon weaponIcon;
    boolean gotHit;
    float hitDelta;

    public Player(float x, float y, Stage stage) {
        super(x,y,stage);
        setAnimation(AnimationLoader.loadTexture("player.png"));

        setAcceleration(3600);
        setSpeedMax(800);
        setDeceleration(100000);

        weapon = new WeaponNormal(getStage());
        weaponIcon = new ActiveWeaponIcon("normal", getStage());
        setShapePolygon(8);
        gotHit = false;
        
        /**
         * ATTENTION
         * this method does not provide any security mechanism
         */
        setWorldDimension(stage.getWidth(), stage.getHeight());
        
       
    }

    private void hitAnimation(float delta) {
        if (hitDelta < 1.5f) {
            hitDelta += delta;

            if ((int) (hitDelta* 10) % 5 == 0 ) {
                if (this.getColor().a == 0) this.setOpacity(1);
                else this.setOpacity(0);
            }
        } else {
            gotHit = false;
            this.setOpacity(1);
        }
    }
    
 
    
    /**
     * input handling
     */
    @Override
    public void act(float delta) {
        if (gotHit) hitAnimation(delta);

        super.act(delta);
        
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            accelerationAtAngle(180);
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            accelerationAtAngle(0);
        }
        if(Gdx.input.isKeyPressed(Keys.UP)) {
            accelerationAtAngle(90);
        }
        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            accelerationAtAngle(270);
        }

        if(Gdx.input.isKeyPressed(Keys.SPACE)) {
            weapon.fire(getX()+(getWidth()/2), getY()+(getHeight()), 90);
        }

        // Zum Testen der Waffen! Sollte später über das gleiche System wie Power-Ups geregelt werden können
        if(Gdx.input.isKeyPressed(Keys.F1)) {
            weaponIcon.remove();
            weapon.remove();
            weapon = new WeaponNormal(getStage());
            weaponIcon = new ActiveWeaponIcon("normal", getStage());
        }
        if(Gdx.input.isKeyPressed(Keys.F2)) {
            weaponIcon.remove();
            weapon.remove();
            weapon = new WeaponSpread(getStage());
            weaponIcon = new ActiveWeaponIcon("spread", getStage());
        }
        if(Gdx.input.isKeyPressed(Keys.F3)) {
            weaponIcon.remove();
            weapon.remove();
            weapon = new WeaponLaser(getStage());
            weaponIcon = new ActiveWeaponIcon("laser", getStage());
        }
        
        applyPhysics(delta);
        setBoundToWorld();
    
    }



    /* (non-Javadoc)
     * @see com.github.lhrb.nemo.actors.PhysicalActor#collision()
     */
    @Override
    public void collision() {
        for (Actor a : getStage().getActors()) {
            if (a instanceof Enemy) {
                a.remove();
                gotHit = true;
                hitDelta = 0;
            }
        }
    }

}
