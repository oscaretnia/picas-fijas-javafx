/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author oscaretnia
 */
public class Attempt {
    
    private SimpleIntegerProperty number;
    private SimpleIntegerProperty hits;
    private SimpleIntegerProperty rights;

    public Attempt(Integer number, Integer hits, Integer rights) {
        this.number = new SimpleIntegerProperty(number);
        this.hits = new SimpleIntegerProperty(hits);
        this.rights = new SimpleIntegerProperty(rights);
    }
    
    

    public Integer getNumber() {
        return number.get();
    }

    public void setNumber(Integer number) {
        this.number.set(number);
    }

    public Integer getHits() {
        return hits.get();
    }

    public void setHits(Integer hits) {
        this.hits.set(hits);
    }

    public Integer getRights() {
        return rights.get();
    }

    public void setRights(Integer rights) {
        this.rights.set(rights);
    }
    
}
