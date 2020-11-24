/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author oscaretnia
 */
public class Game {

    private Random random;
    private String input;
    private char generated[] = new char[4];
    private int hits, rights, step, figures = 0;
    private boolean state = false;

    public Game() {
        random = new Random();
        input = "";
        generate();
    }

    private void generate() {
        int i = 0, num;
        while (i < 4) {
            step = 0;
            num = random.nextInt(10);
            for (int j = 0; j < i; j++) {
                if (generated[j] == (char) (num + 48)) {
                    step = 1;
                }
            }
            if (step == 0) {
                generated[i] = (char) (num + 48);
                i++;
            }
        }
    }

    private void compare() {

        int i, j;
        char[] arrInput = input.toCharArray();
        rights = hits = 0;

        for (i = 0; i < generated.length; i++) {
            for (j = 0; j < 4; j++) {
                if (i == j) {
                    if (generated[i] == arrInput[j]) {
                        rights++;
                        break;
                    }
                } else if (generated[i] == arrInput[j]) {
                    hits++;
                    break;
                }
            }
        }
        
        hits += rights;
    }

    public void play(String number) {
        if (!state) {
            input = number;
            compare();
            
            if (rights == 4) {
                figures++;
                if (Data.getPlayer().getLevel().getFigures() == figures) {
                    state = true;
                } else {
                    generate();                    
                }
            }
            
        }
    }

    public String getGenerated() {
        return Arrays.toString(generated);
    }

    public int getHits() {
        return hits;
    }

    public int getRights() {
        return rights;
    }
    
    public int getFigures() {
        return figures;
    }

    public boolean getState() {
        return state;
    }

    public void finish() {
        this.state = true;
    }
    
    public Integer getPoints(int figures, int time) {
        return figures * 50 + time;
    }
}
