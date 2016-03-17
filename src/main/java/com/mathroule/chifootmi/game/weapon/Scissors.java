package com.mathroule.chifootmi.game.weapon;

/**
 * Implementation class for a scissors weapon.
 */
public class Scissors extends Weapon {

    public Scissors() {
        super("scissors");
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && (obj == this || obj instanceof Scissors);
    }
}
