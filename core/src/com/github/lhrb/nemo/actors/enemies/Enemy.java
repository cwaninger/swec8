/**
 * 
 */
package com.github.lhrb.nemo.actors.enemies;

import java.util.Random;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.github.lhrb.nemo.GameManager;
import com.github.lhrb.nemo.SpawnFactory.PowerUPFactory;
import com.github.lhrb.nemo.actors.ActorPrefab;
import com.github.lhrb.nemo.actors.PhysicalActor;
import com.github.lhrb.nemo.actors.Player;
import com.github.lhrb.nemo.util.AnimationLoader;
import com.github.lhrb.nemo.util.SoundManager;

/**
 * @author exa
 *
 */
public abstract class Enemy extends PhysicalActor{

    public Enemy(Stage stage){
        super();
        setCharacteristics(stage);
    }
    
    public Enemy(float x, float y, Stage stage) {
        super(x,y,stage);
        setCharacteristics(stage);
    }
    
    int hp;
    int scoreValue;
    
    protected abstract void setCharacteristics(Stage stage);

    /* (non-Javadoc)
     * @see com.github.lhrb.nemo.actors.PhysicalActor#collision()
     */

    public void collision(Player p) {
        hp -= 1;
        setColor(255,0,0,hp*0.4f);
        if(hp <= 0) {
            if(getStage() != null) {
                //test for multiplicator
                if (p.multi() == true)
                    GameManager.getInstance().addScore(3 * scoreValue);
                else
                    GameManager.getInstance().addScore(scoreValue);
                SoundManager.getInstance().playSound("explosion");
                
                //code below is bad    
                new ActorPrefab(getX(), getY(), getStage())
                        .setAnimation(AnimationLoader.get().animation(
                                "explosion.png", 6, 6, 0.05f, false));
                //end 
                Random rand = new Random();
                if(rand.nextInt(10) <= 1) { // 20% chance to drop
                    PowerUPFactory.spawnPU(getX(), getY(), getStage());
                }
                remove();
            }
        }
    }
}
