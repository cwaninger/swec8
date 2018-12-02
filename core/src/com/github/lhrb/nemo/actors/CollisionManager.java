/**
 * 
 */
package com.github.lhrb.nemo.actors;

import java.util.ArrayList;

import com.github.lhrb.nemo.actors.enemies.Enemy;
import com.github.lhrb.nemo.actors.shots.Shots;

/**
 * @author exa
 *
 */
public class CollisionManager {
    
    public static void checkCollision(ArrayList<PhysicalActor> list) {
        ArrayList<Player> player = new ArrayList<Player>();
        ArrayList<Shots> shots = new ArrayList<Shots>();
        ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        for(PhysicalActor e : list) {
            if(e instanceof Player) {
                player.add( (Player)e );
            }
            if(e instanceof Shots) {
                shots.add( (Shots)e);
            }
            if(e instanceof Enemy) {
                enemies.add( (Enemy)e );
            }
        }
        
        /**
         * grade brain fuck
         * sollte effizienter gehen?
         */

        for(Player p : player) {
            for (Enemy e : enemies) {
                // Enemy collosion with player
                if(e.overlap((PhysicalActor)p)) {
                    if (e != null) { e.collision(); }
                    if (p != null) { p.collision(); }
                }
                // Enemy collosion with Shots
                for (Shots s : shots) {
                    if(e.overlap(s) && s.isPlayerShot()) {
                        if(e != null) { e.collision(); }
                        if(s != null) { s.collision(); }
                    }
                }
            }
            for (Shots s : shots) {
                // Player collision with Shots
                if(s.overlap((PhysicalActor)p) && !s.isPlayerShot()) {
                    if(p != null) { p.collision(); }
                    if(s != null) { s.collision(); }
                }
            }
            /*for (Powerups p : powerups) {

            }*/
        }
    }
}
