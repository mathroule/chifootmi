package com.mathroule.chifootmi.game.rule;


import com.mathroule.chifootmi.game.weapon.Paper;
import com.mathroule.chifootmi.game.weapon.Rock;
import com.mathroule.chifootmi.game.weapon.Scissors;

/**
 * Implement the basic games rules (i.e. Rock-paper-scissors).
 */
public class Basic extends Rules {


    // TODO @see: https://en.wikipedia.org/wiki/Interface_segregation_principle

    /**
     * Constructor of the basic game rules (i.e. Rock-paper-scissors).
     */
    public Basic() {
        // Scissors cuts paper
        this.add(new Rule(new Scissors(), "cuts", new Paper()));

        // Paper covers rock
        this.add(new Rule(new Paper(), "covers", new Rock()));

        // Rock crushes scissors
        this.add(new Rule(new Rock(), "crushes", new Scissors()));
    }
}
