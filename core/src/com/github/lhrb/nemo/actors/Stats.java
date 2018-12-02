package com.github.lhrb.nemo.actors;
import com.github.lhrb.nemo.actors.weapons.Weapon;
import com.github.lhrb.nemo.actors.weapons.WeaponNormal;

import java.io.Serializable;

public class Stats implements Serializable{
    //stores the players current health
    public int health=0;
    //stores the highest lvl the player currently reached
    public int lvl=0;
    //stores the players score
    public int score=0;
    //Stores the current selected Weapon
    public Weapon weapon ;
    //Stores the Players currently selected Item
    //TODO Needs to be changed into item class when merged
    public Object PowerUP = null ;
    public Stats(int health, int lvl, int score, Weapon Weapon, Object PowerUP){
        this.health=health;
        this.lvl=lvl;
        this.score=score;
        this.weapon =Weapon;
        this.PowerUP =PowerUP;
    }
    public Stats(Stats stats){
        this.health=stats.health;
        this.lvl=stats.lvl;
        this.score=stats.score;
        this.weapon =stats.weapon;
        this.PowerUP =stats.PowerUP;
    }
    public Stats(Player player){
        weapon = new WeaponNormal(player.getStage());
        //TODO Needs to implemented when PowerUp is included
    }
}
