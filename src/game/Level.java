/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author oscaretnia
 */
public class Level {
    
    private Integer level;
    private Integer time;
    private Integer figures;

    public Level(Integer level) {
        this.level = level;
    }
    
    public Integer getLevel() {
        return level;
    }
    
    public void upLevel() {
        this.level++;
    }
    
    public Integer getTime() {
        
        if (level == 1) return 60;
        if (level == 2) return 50;
        if (level == 3) return 45;
        if (level == 4) return 45;
        if (level == 5) return 40;
        if (level == 6) return 35;
        if (level == 7) return 25;
        
        return time;
    }

    public int getFigures() {
        if (level == 1) return 1;
        if (level == 2) return 1;
        if (level == 3) return 1;
        if (level == 4) return 2;
        if (level == 5) return 2;
        if (level == 6) return 3;
        if (level == 7) return 3;
        
        return figures;
    }
}
