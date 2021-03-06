package com.mathroule.chifootmi.game.weapon;

/**
 * Implementation class for a Spock weapon.
 */
public final class Spock extends Weapon {

    public Spock() {
        super("spock");
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && (obj == this || obj instanceof Spock);
    }
}
