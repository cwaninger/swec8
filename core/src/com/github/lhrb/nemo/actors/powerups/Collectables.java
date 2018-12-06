/**
 * 
 */
package com.github.lhrb.nemo.actors.powerups;

import java.util.HashMap;

/**
 * @author exa
 *
 */
public class Collectables {    
    
   private static Collectables collectables; 
   private HashMap<CType, String>  powerUp;
   
   private Collectables() {
       powerUp = new HashMap<CType, String>();
       init();
   }
   
   public static Collectables get() {
       if(collectables == null) {
           collectables = new Collectables();
       }
       return collectables;
   }
   
   private void init() {
       //Powerups
       powerUp.put(CType.Bomb, "powerup_bombe.png");
       powerUp.put(CType.Heart, "powerup_heart.png");
       powerUp.put(CType.Multiplicator, "powerup_multiplicator.png");
       powerUp.put(CType.Shield, "powerup_shield.png");
       powerUp.put(CType.Star, "powerup_star.png");
       
       //Weapons
       //powerUp.put(CType.Laser, "powerup_bombe.png");
       //powerUp.put(CType.Spread, "powerup_bombe.png");
       //powerUp.put(CType.Normal, "powerup_bombe.png");
   }
   
   /**
    * 
    * @param key
    * @return
    */
   public String getPath(CType key) {
       return powerUp.get(key);
   }
   
   
}
