/**
 * 
 */
package com.github.lhrb.nemo.actors;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.github.lhrb.nemo.GameManager;
import com.github.lhrb.nemo.KillingNemo;
import com.github.lhrb.nemo.actors.enemies.Enemy;
import com.github.lhrb.nemo.actors.powerups.*;
import com.github.lhrb.nemo.actors.weapons.*;
import com.github.lhrb.nemo.screen.GameOverScreen;
import com.github.lhrb.nemo.util.AnimationLoader;

/**
 * Simple player Implementation
 * @author exa
 * 
 */
public class Player extends PhysicalActor {

    private PropertyChangeSupport changes = new PropertyChangeSupport(this);
    
    private Weapon weapon;
    private PowerUP powerup;
    private int life;
    private boolean gotHit;
    private float hitDelta;
    public Player(float x, float y, Stage stage) {
        super(x,y,stage);

        setAnimation(AnimationLoader.get().animation("player_animation_feuer.png", 1, 3, 0.1f, true));


        setAcceleration(100000);
        setSpeedMax(500);
        setDeceleration(100000);
        life = 3;

        weapon = new WeaponNormal(getStage());
        powerup = null;
        setShapePolygon(8);
        gotHit = false;
        
        /**
         * ATTENTION
         * this method does not provide any security mechanism
         */
        setWorldDimension(stage.getWidth(), stage.getHeight());
        
       
    }
    
    
    public void addPropertyChangeListener(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener l) {
        changes.removePropertyChangeListener(l);
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
            weapon.remove();
            weapon = new WeaponNormal(getStage());
        }
        if(Gdx.input.isKeyPressed(Keys.F2)) {
            weapon.remove();
            weapon = new WeaponSpread(getStage());
        }
        if(Gdx.input.isKeyPressed(Keys.F3)) {
            weapon.remove();
            weapon = new WeaponLaser(getStage());
        }
        
        applyPhysics(delta);
        setBoundToWorld();
    
    }


    /* (non-Javadoc)
     * @see com.github.lhrb.nemo.actors.PhysicalActor#collision()
     */
    @Override
    public void collision() {
        if (getStage() == null) System.out.println("stage null");
        for (Actor a : getStage().getActors()) {
            if (a instanceof Enemy || a instanceof PowerUP) {
                a.remove();
                if (!gotHit) {
                    gotHit = true;
                    hitDelta = 0;
                    life -= 1;
                    if (life <= 0) {
                        playerDied();
                    }
                }
            }
        }
    }

    public void collision(PowerUP pu){
        if (getStage() == null) System.out.println("stage null");
        if (pu.getType() == CType.Bomb){
            if (powerup != null)
                powerup.remove();
            powerup = pu;

        }
        else if (pu.getType() == CType.Heart){
            life++;
        }
        else if (pu.getType() == CType.Multiplicator){
            if (powerup != null)
                powerup.remove();
            powerup = pu;

        }
        else if (pu.getType() == CType.Shield){
            if (powerup != null)
                powerup.remove();
            powerup = pu;

        }
        else if (pu.getType() == CType.Star){
            if (powerup != null)
                powerup.remove();
            powerup = pu;

        }
    }

    public void playerDied() {
        KillingNemo.setActiveScreen(new GameOverScreen());
        GameManager.getInstance().resetScore();
    }

    public boolean multi() {
        if (powerup != null)
            return (powerup.getType() == CType.Multiplicator);
        return false;
    }

}
