package com.mathroule.chifootmi.game.rule;


import com.mathroule.chifootmi.game.weapon.*;

import java.util.List;

/**
 * Implement the extended games rules (i.e. Rock-paper-scissors-lizard-Spock).
 */
public final class Extended extends Rules {

    private final Rules base;

    /**
     * Constructor of the extended game rules (i.e. Rock-paper-scissors-lizard-Spock).
     */
    public Extended() {
        super();

        base = new Basic();

        // Rock crushes lizard
        this.add(new Rule(new Rock(), "crushes", new Lizard()));

        // Paper disproves Spock
        this.add(new Rule(new Paper(), "disproves", new Spock()));

        // Scissors decapitates lizard
        this.add(new Rule(new Scissors(), "decapitates", new Lizard()));

        // Lizard eats paper
        this.add(new Rule(new Lizard(), "eats", new Paper()));

        // Lizard poisons Spock
        this.add(new Rule(new Lizard(), "poisons", new Spock()));

        // Spock smashes scissors
        this.add(new Rule(new Spock(), "smashes", new Scissors()));

        // Spock vaporizes rock
        this.add(new Rule(new Spock(), "vaporizes", new Rock()));
    }

    @Override
    public final List<Weapon> getAvailableWeapons() {
        List<Weapon> weapons = base.getAvailableWeapons();
        weapons.add(new Lizard());
        weapons.add(new Spock());
        return weapons;
    }
}
