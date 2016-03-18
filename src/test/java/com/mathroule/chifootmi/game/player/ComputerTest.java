package com.mathroule.chifootmi.game.player;

import com.mathroule.chifootmi.game.weapon.Paper;
import com.mathroule.chifootmi.game.weapon.Rock;
import com.mathroule.chifootmi.game.weapon.Scissors;
import com.mathroule.chifootmi.game.weapon.Weapon;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test the computer class.
 */
public class ComputerTest {

    /**
     * Computer available names.
     */
    private static final String[] AVAILABLE_NAMES = new String[]{
            "Ana",
            "Bob",
            "Paul"
    };

    @Test
    public void testComputer() throws Exception {
        Computer computer1 = new Computer();
        assertTrue(Arrays.asList(AVAILABLE_NAMES).contains(computer1.getName()));


        Computer computer2 = new Computer();
        assertTrue(Arrays.asList(AVAILABLE_NAMES).contains(computer2.getName()));
    }

    @Test
    public void testWin() throws Exception {
        Computer computer = new Computer();
        assertEquals(0, computer.getWin());
        assertEquals(0, computer.getLoose());
        computer.won();
        computer.won();
        assertEquals(2, computer.getWin());
        assertEquals(0, computer.getLoose());
    }

    @Test
    public void testLoose() throws Exception {
        Computer computer = new Computer();
        assertEquals(0, computer.getWin());
        assertEquals(0, computer.getLoose());
        computer.loose();
        computer.loose();
        computer.loose();
        assertEquals(0, computer.getWin());
        assertEquals(3, computer.getLoose());
    }

    @Test
    public void testPickWeaponWeapon() throws Exception {
        List<Weapon> weapons = new ArrayList<>();
        weapons.add(new Rock());
        weapons.add(new Paper());
        weapons.add(new Scissors());
        Computer computer = new Computer();
        assertTrue(weapons.contains(computer.pickWeapon(weapons)));
    }
}