package org.example;

import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private int score;
    private boolean lastFrame;
    private IGenerateur generateur;
    private List<Roll> rolls;

    public Frame(IGenerateur generateur, boolean lastFrame) {
        this.lastFrame = lastFrame;
        this.generateur = generateur;
        rolls = new ArrayList<Roll>();
    }

    public boolean makeRoll(){
       int max = 10;
    if (!lastFrame){
            if (!rolls.isEmpty() && rolls.get(0).getPins() != 10) {
                max = max - rolls.get(0).getPins();
            }

            int result = generateur.randomPin(max);

            rolls.add(new Roll(result)); // on ajoute un nouveau roll à la liste
            if (rolls.get(0).getPins() == 10) { // si le premier lancer vaut 10
                setScore(10);
                return false;
            }
            if (rolls.size() > 2) {
                return false;
            }
            setScore(getScore() + result);

        }else {
        if (rolls.size() == 2 && rolls.get(0).getPins()==10){
            max = max - rolls.get(1).getPins();
        }
        if(rolls.size()==1 && rolls.get(0).getPins()!=10){
            max = max - rolls.get(0).getPins();
        }

        int result = generateur.randomPin(max);


        rolls.add(new Roll(result));
        setScore(getScore()+result);
        if (rolls.get(0).getPins()== 10 && rolls.size() <=3){

            return true;
        } else {

            if (rolls.size() == 3 && rolls.get(0).getPins() + rolls.get(1).getPins() == 10){
                return true;
            }
        }
    }


       return false;

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isLastFrame() {
        return lastFrame;
    }

    public void setLastFrame(boolean lastFrame) {
        this.lastFrame = lastFrame;
    }

    public IGenerateur getGenerateur() {
        return generateur;
    }

    public void setGenerateur(IGenerateur generateur) {
        this.generateur = generateur;
    }

    public List<Roll> getRolls() {
        return rolls;
    }

    public void setRolls(List<Roll> rolls) {
        this.rolls = rolls;
    }
}
