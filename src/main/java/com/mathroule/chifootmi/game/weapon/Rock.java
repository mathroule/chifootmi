package com.mathroule.chifootmi.game.weapon;

/**
 * Implementation class for a rock weapon.
 */
public final class Rock extends Weapon {

    public Rock() {
        super("rock");
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && (obj == this || obj instanceof Rock);
    }
}
