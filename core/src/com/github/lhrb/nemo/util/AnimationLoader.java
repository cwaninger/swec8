/**
 * 
 */
package com.github.lhrb.nemo.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author exa
 * 
 * Utility class to load animations 
 *
 */
public class AnimationLoader {
    
    
    private static AnimationLoader animationLoader;
    private HashMap<String, Animation<TextureRegion> > animStorage;
    
    private AnimationLoader() {
        animStorage = new HashMap<String, Animation<TextureRegion>>();
    }
    
    public static AnimationLoader get() {
        if(animationLoader == null) {
            animationLoader = new AnimationLoader();
        }
        return animationLoader;
    }
    
    /**
     * Method may return null
     * @param fileName
     * @return
     */
    public Animation<TextureRegion> texture(String fileName) {
        if(fileName == null) return null;
        Animation<TextureRegion> ret =  null;
        
        if(!animStorage.containsKey(fileName)) {
            try {
                ret = AnimationLoader.loadTexture(fileName);
                animStorage.put(fileName, ret);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        
        ret = animStorage.get(fileName);
        return ret;
    }
    
    
    /**
     * Method may return null
     * @param fileName
     * @param rows
     * @param cols
     * @param frameDuration
     * @param loop
     * @return
     */
    public Animation<TextureRegion> animation(String fileName,
                                            int rows, int cols,
                                            float frameDuration, boolean loop){
        if(fileName == null) return null;
        Animation<TextureRegion> ret =  null;
        
        if(!animStorage.containsKey(fileName)) {
            try {
                ret = AnimationLoader
                      .loadAnimation(fileName, rows, cols, frameDuration, loop);
                animStorage.put(fileName, ret);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        
        ret = animStorage.get(fileName);
        return ret;
    }
    
    /**
     * Returns an animation based on a sequence inside a 
     * image file
     * 
     * be aware this method does not provide any security mechanism
     * pass an empty filename or null or a zero value as row/col
     * will cause an error
     * 
     * @param fileName
     * @param rows
     * @param cols
     * @param frameDuration
     * @param loop
     * @return
     * @throws FileNotFoundException 
     */
    public static Animation<TextureRegion> loadAnimation(String fileName, 
                                                  int rows, int cols, 
                                                  float frameDuration, boolean loop) 
                                                      throws FileNotFoundException{
        
        
        if(!Gdx.files.internal(fileName).exists()) {
            throw new FileNotFoundException("File does not exist");
        }
        
        Texture texture = new Texture(Gdx.files.internal(fileName), true);
        texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        int tileWidth = texture.getWidth() / cols;
        int tileHeight = texture.getHeight() / rows;
        TextureRegion[][] tmp = TextureRegion.split(texture, tileWidth, tileHeight);

        Array<TextureRegion> textureArray = new Array<TextureRegion>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                textureArray.add(tmp[i][j]);
            }
        }

        Animation<TextureRegion> tmpAnimation = new Animation<TextureRegion>
                (frameDuration, textureArray);

        if(loop) {
            tmpAnimation.setPlayMode(Animation.PlayMode.LOOP);
        }else {
            tmpAnimation.setPlayMode(Animation.PlayMode.NORMAL);
        }
        return tmpAnimation;

    }
    
    /**
     * Simple helper method 
     * for game objects that may be respresented
     * by a single image
     * 
     * @param fileName
     * @return
     * @throws FileNotFoundException 
     */
    public static Animation<TextureRegion> loadTexture(String fileName) 
                                          throws FileNotFoundException{
        return loadAnimation(fileName, 1, 1, 1, true);
    }
    

}
