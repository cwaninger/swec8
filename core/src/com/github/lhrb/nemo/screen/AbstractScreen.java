package com.github.lhrb.nemo.screen;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.github.lhrb.nemo.actors.PhysicalActor;

/**
 * Abstract class 
 * @author exa
 *
 */
public abstract class AbstractScreen implements Screen, InputProcessor{
    
    // stage to spawn "physical actors"
    protected Stage gameStage;
    // stage for ui elements like messages 
    protected Stage guiStage; 

    public AbstractScreen() {
        //Viewport?
        gameStage = new Stage();
        guiStage = new Stage();
        init();
    }
    
    /**
     * initialize all actors 
     */
    public abstract void init();
    
    /**
     * update loop
     * @param delta time
     */
    public abstract void update(float delta); 
    
    
    protected ArrayList<PhysicalActor> getPhysicalActors(){
       ArrayList<PhysicalActor> list = new ArrayList<PhysicalActor>();
       for(Actor e : gameStage.getActors()) {
           if(e instanceof PhysicalActor) {
               list.add( (PhysicalActor)e );
           }
       }
       return list;
    }
    
    
    public Stage getUiStage() {
        return guiStage;
    }
    
    public void setUiStage(Stage stage) {
        guiStage = stage;
    }
    
    public Stage getGameStage() {
        return gameStage;
    }
    
    public void setGameStage(Stage stage) {
        gameStage = stage;
    }
    
    /**
     * 
     */
    public void render(float delta) {
        guiStage.act(delta);
        gameStage.act(delta);
        
        update(delta);
        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        gameStage.draw();
        // draw ui elements on top 
        guiStage.draw();
    }
    
    /* (non-Javadoc)
     * @see com.badlogic.gdx.Game#resize(int, int)
     */
    @Override
    public void resize(int width, int height) {
        // maybe?
        gameStage.getViewport().update(width, height, true);
        guiStage.getViewport().update(width, height, true);
    }
    
    /* (non-Javadoc)
     * @see com.badlogic.gdx.Screen#show()
     * Setup input multiplexer when screen is called
     */
    @Override
    public void show() {
        InputMultiplexer iMultiplexer = (InputMultiplexer)Gdx.input.getInputProcessor();
        iMultiplexer.addProcessor(this);
        iMultiplexer.addProcessor(guiStage);
        iMultiplexer.addProcessor(gameStage);
        
    }

    /* (non-Javadoc)
     * @see com.badlogic.gdx.Screen#pause()
     */
    @Override
    public void pause() {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see com.badlogic.gdx.Screen#resume()
     */
    @Override
    public void resume() {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see com.badlogic.gdx.Screen#hide()
     * remove input multiplexer
     */
    @Override
    public void hide() {
        InputMultiplexer iMultiplexer = (InputMultiplexer)Gdx.input.getInputProcessor();
        iMultiplexer.removeProcessor(this);
        iMultiplexer.removeProcessor(guiStage);
        iMultiplexer.removeProcessor(gameStage);
        
    }

    /* (non-Javadoc)
     * @see com.badlogic.gdx.Screen#dispose()
     */
    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see com.badlogic.gdx.InputProcessor#keyDown(int)
     */
    @Override
    public boolean keyDown(int keycode) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.badlogic.gdx.InputProcessor#keyUp(int)
     */
    @Override
    public boolean keyUp(int keycode) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.badlogic.gdx.InputProcessor#keyTyped(char)
     */
    @Override
    public boolean keyTyped(char character) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.badlogic.gdx.InputProcessor#touchDown(int, int, int, int)
     */
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.badlogic.gdx.InputProcessor#touchUp(int, int, int, int)
     */
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.badlogic.gdx.InputProcessor#touchDragged(int, int, int)
     */
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.badlogic.gdx.InputProcessor#mouseMoved(int, int)
     */
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.badlogic.gdx.InputProcessor#scrolled(int)
     */
    @Override
    public boolean scrolled(int amount) {
        // TODO Auto-generated method stub
        return false;
    }


    
}
