package com.mathroule.chifootmi.weapon;

/**
 * Implementation class for a paper weapon.
 */
public class Paper extends Weapon {

    public Paper() {
        super("paper");
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && (obj == this || obj instanceof Paper);
    }
}
