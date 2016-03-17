package com.mathroule.chifootmi.weapon;

/**
 * Implementation class for a Spock weapon.
 */
public class Spock extends Weapon {

    public Spock() {
        super("spock");
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && (obj == this || obj instanceof Spock);
    }
}
