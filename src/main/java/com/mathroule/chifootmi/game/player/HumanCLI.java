package com.mathroule.chifootmi.game.player;

import com.mathroule.chifootmi.game.weapon.Weapon;

import java.util.List;
import java.util.Scanner;

/**
 * Implementation class for an human player playing in CLI.
 */
public final class HumanCLI extends HumanDecorator {

    /**
     * The input scanner.
     */
    private final Scanner scanner;

    /**
     * The choose weapons shell input.
     */
    private final String chooseWeapons;

    /**
     * Human player constructor using name.
     *
     * @param name the player name
     */
    public HumanCLI(String name, Scanner scanner, String chooseWeapons) {
        super(name);
        this.scanner = scanner;
        this.chooseWeapons = chooseWeapons;
    }

    /**
     * Pick a weapon from a list available of weapons.
     *
     * @param weapons the list available of weapons
     * @return the picked weapon
     */
    @Override
    public Weapon pickWeapon(List<Weapon> weapons) {
        // Get player weapon
        int move = 1;
        do {
            System.out.print(chooseWeapons);
            if (scanner.hasNextInt()) {
                move = scanner.nextInt();
            }
        } while (move < 1 || weapons.size() < move);
        System.out.println(weapons.get(move - 1));
        return weapons.get(move - 1);
    }
}
