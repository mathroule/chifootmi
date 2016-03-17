package com.mathroule.chifootmi.game.weapon;

/**
 * Implementation class for a lizard weapon.
 */
public final class Lizard extends Weapon {

    public Lizard() {
        super("lizard");
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && (obj == this || obj instanceof Lizard);
    }
}
