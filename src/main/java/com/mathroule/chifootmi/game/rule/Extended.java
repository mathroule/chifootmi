package com.mathroule.chifootmi.game.rule;


import com.mathroule.chifootmi.weapon.*;

/**
 * Implement the basic games rules (i.e. Rock-paper-scissors-lizard-Spock).
 */
public class Extended extends Basic {

    public Extended() {
        super();

        // Scissors decapitates lizard
        this.add(new Rule(new Scissors(), "decapitates", new Lizard()));

        // Paper disproves Spock
        this.add(new Rule(new Paper(), "disproves", new Spock()));

        // Rock crushes lizard
        this.add(new Rule(new Rock(), "crushes", new Lizard()));

        // Lizard eats paper
        this.add(new Rule(new Lizard(), "eats", new Paper()));

        // Lizard poisons Spock
        this.add(new Rule(new Lizard(), "poisons", new Spock()));

        // Spock smashes Scissors
        this.add(new Rule(new Spock(), "smashes", new Scissors()));

        // Spock vaporizes rock
        this.add(new Rule(new Spock(), "vaporizes", new Rock()));
    }
}
