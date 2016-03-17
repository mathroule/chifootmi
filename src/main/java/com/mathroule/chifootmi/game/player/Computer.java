package com.mathroule.chifootmi.game.player;

import java.util.Random;

/**
 * Implementation class for a computer player.
 */
public class Computer extends Player {

    /**
     * Computer available names.
     */
    private static final String[] AVAILABLE_NAMES = new String[]{
            "Ana",
            "Bob",
            "Paul"
    };

    /**
     * Random number generator used for name generation.
     */
    private static final Random random = new Random();

    /**
     * Computer player constructor using random name.
     */
    public Computer() {
        super(AVAILABLE_NAMES[random.nextInt(AVAILABLE_NAMES.length - 1)]);
    }
}
