/**
 * 
 */
package com.github.lhrb.nemo.actors;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * @author exa
 *
 */
public class PhysicalActor extends ActorPrefab{
    
    private Polygon shape;
    
    public PhysicalActor() {
        super();
    }
    
    public PhysicalActor(float x, float y, Stage stage) {
        super(x,y,stage);
    }
    
    /**
     * ####################################
     * ####### COLLISION ##################
     * ####################################
     */
    
    /**
     * sets a basic polygon for collision detection
     * @param numEdges
     */
    public void setShapePolygon(int numEdges) {
        float width = getWidth();
        float height = getHeight();
        //System.out.println("width: " + width + " height: " + height);
        float[] vertices = new float[2*numEdges];
        for(int i = 0; i < numEdges; i++) {
            // 6.28 is ~360 degree in radian measure ;)
            float radians = i * 6.28f / numEdges; 
            vertices[2*i] = width/2 * MathUtils.cos(radians) + width/2;
            vertices[2*i+1] = height/2 * MathUtils.sin(radians) + height/2;
        }
        shape = new Polygon(vertices);
    }
    
    
    /**
     * ATTENTION
     * could possible return null 
     * adjusts the shape position according to the actors parameters
     * @return
     */
    public Polygon getShape() {
        if(shape != null) {
            shape.setPosition(getX(), getY());
            shape.setOrigin(getOriginX(), getOriginY());
            // probably not necessary 
            shape.setRotation(getRotation());
            shape.setScale(getScaleX(), getScaleY());
            
        }        
        return shape;
    }
    
    /**
     * Determines whether to polygons overlap or not
     * @param other 
     * @return
     */
    public boolean overlap(PhysicalActor other) {
        if(shape == null || other == null ) return false;
        Polygon p1 = this.getShape();
        Polygon p2 = other.getShape();
        
        //test rectangle first (performance)
        if( !p1.getBoundingRectangle().overlaps(p2.getBoundingRectangle())) {
            return false;
        }
        
        return Intersector.overlapConvexPolygons(p1, p2);
    }
    
    /**
     * do something specifc
     */
    public void collision() {
                
    }

}
