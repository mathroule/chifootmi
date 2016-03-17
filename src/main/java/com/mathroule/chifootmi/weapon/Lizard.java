package com.mathroule.chifootmi.weapon;

/**
 * Implementation class for a lizard weapon.
 */
public class Lizard extends Weapon {

    public Lizard() {
        super("lizard");
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && (obj == this || obj instanceof Lizard);
    }
}
