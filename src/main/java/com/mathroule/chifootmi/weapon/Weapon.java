package com.mathroule.chifootmi.weapon;

/**
 * Abstract class for a game weapon.
 */
public abstract class Weapon {

    private String name;

    public Weapon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
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
    public String toString() {
        return name;
    }
}
