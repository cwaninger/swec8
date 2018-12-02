/**
 * 
 */
package com.github.lhrb.nemo;



/**
 * @author exa
 * 
 *  Manages the score and maybe more in future
 */
public class GameManager {
    
    private static GameManager gameMng;
    
    private int score;
    private String scoreTxt;
        
    private GameManager() {
        score = 0;
        scoreToString();
    }
    
    public static GameManager getInstance() {
        if(gameMng == null) {
            gameMng = new GameManager();
        }
        return gameMng;
    }
    
    public Integer getScore() {
        return score;
    }
    
    public String getScoreAsString() {
        return scoreTxt;
    }
           
    
    /**
     * increase score by 1
     */
    public synchronized void addScore() {
        addScore(1);
        scoreToString();
    }

    /**
     * increase score by i
     * @param i
     */
    public synchronized void addScore(int i) {
        score += i;
        scoreToString();
    }
    
    public synchronized void resetScore() {
        score = 0;
        scoreToString();
    }
    
    private void scoreToString() {
        scoreTxt = String.valueOf(score);
    }
    

    
}
