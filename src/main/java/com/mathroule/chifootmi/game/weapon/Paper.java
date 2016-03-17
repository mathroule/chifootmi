package com.mathroule.chifootmi.game.weapon;

/**
 * Implementation class for a paper weapon.
 */
public final class Paper extends Weapon {

    public Paper() {
        super("paper");
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && (obj == this || obj instanceof Paper);
    }
}
