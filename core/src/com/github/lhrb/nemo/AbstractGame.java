/**
 * 
 */
package com.github.lhrb.nemo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.github.lhrb.nemo.screen.AbstractScreen;

/**
 * @author exa
 * abtract class to simplify creating different "Games" mostly for debug puposes
 * 
 */
public abstract class AbstractGame extends Game {
    
    //defined as static to simplify usage
    private static AbstractGame game;
    
    
    
    public AbstractGame() {
        game = this;
    }

    /* (non-Javadoc)
     * @see com.badlogic.gdx.ApplicationListener#create()
     */
    @Override
    public void create() {
        InputMultiplexer iMultiplexer = new InputMultiplexer();
        Gdx.input.setInputProcessor(iMultiplexer);
        
       
    }
    
    
    
    public static void setActiveScreen(AbstractScreen screen) {
        if(screen == null) return;
        game.setScreen(screen);
    }

}