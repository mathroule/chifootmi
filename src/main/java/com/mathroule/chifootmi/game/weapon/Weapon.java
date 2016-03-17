package com.mathroule.chifootmi.game.weapon;

/**
 * Abstract class for a game weapon.
 */
public abstract class Weapon {

    private final String name;

    public Weapon(String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }

    @Override
    public final int hashCode() {
        return getName().hashCode();
    }

    /**
     * Used to force implement equals.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
     */
    @Override
    public abstract boolean equals(Object obj);

    @Override
    public final String toString() {
        return name;
    }
}
