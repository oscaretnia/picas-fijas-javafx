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
public class Data {
    
    private static Player player;
    
    public static void setPlayer(String name, Integer level) {
        player = new Player(name, new Level(level));
    }
    
    public static Player getPlayer() {
        return player;
    }
    
    public static void upLevel() {
        player.getLevel().upLevel();
    }
    
}
