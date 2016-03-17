package com.mathroule.chifootmi.game.weapon;

import com.mathroule.chifootmi.game.weapon.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test the lizard weapon.
 */
public class LizardTest {

    @Test
    public void testGetName() throws Exception {
        Lizard lizard = new Lizard();
        assertEquals("lizard", lizard.getName());
    }

    @Test
    public void testEqualsWithRock() throws Exception {
        Lizard spock1 = new Lizard();
        Rock rock1 = new Rock();
        assertFalse(spock1.equals(rock1));
        assertFalse(rock1.equals(spock1));

        Weapon spock2 = new Lizard();
        assertFalse(spock2.equals(rock1));
        assertFalse(rock1.equals(spock2));

        Weapon rock2 = new Rock();
        assertFalse(rock2.equals(spock1));
        assertFalse(spock1.equals(rock2));
        assertFalse(rock2.equals(spock2));
        assertFalse(spock2.equals(rock2));
    }

    @Test
    public void testEqualsWithPaper() throws Exception {
        Lizard lizard1 = new Lizard();
        Paper paper1 = new Paper();
        assertFalse(paper1.equals(lizard1));
        assertFalse(lizard1.equals(paper1));

        Weapon lizard2 = new Lizard();
        assertFalse(lizard2.equals(paper1));
        assertFalse(paper1.equals(lizard2));

        Weapon paper2 = new Paper();
        assertFalse(paper2.equals(lizard1));
        assertFalse(lizard1.equals(paper2));
        assertFalse(paper2.equals(lizard2));
        assertFalse(lizard2.equals(paper2));
    }

    @Test
    public void testEqualsWithScissors() throws Exception {
        Lizard lizard1 = new Lizard();
        Scissors scissors1 = new Scissors();
        assertFalse(lizard1.equals(scissors1));
        assertFalse(scissors1.equals(lizard1));

        Weapon lizard2 = new Lizard();
        assertFalse(lizard2.equals(scissors1));
        assertFalse(scissors1.equals(lizard2));

        Weapon scissors2 = new Scissors();
        assertFalse(scissors2.equals(lizard1));
        assertFalse(lizard1.equals(scissors2));
        assertFalse(scissors2.equals(lizard2));
        assertFalse(lizard2.equals(scissors2));
    }

    @Test
    public void testEqualsWithLizard() throws Exception {
        Lizard lizard1 = new Lizard();
        assertFalse(lizard1.equals(null));
        assertTrue(lizard1.equals(lizard1));

        Lizard lizard2 = new Lizard();
        assertTrue(lizard1.equals(lizard2));
        assertTrue(lizard2.equals(lizard1));

        Weapon lizard3 = new Lizard();
        assertFalse(lizard3.equals(null));
        assertTrue(lizard3.equals(lizard3));
        assertTrue(lizard1.equals(lizard3));
        assertTrue(lizard3.equals(lizard1));
    }

    @Test
    public void testEqualsWithSpock() throws Exception {
        Lizard lizard1 = new Lizard();
        Spock spock1 = new Spock();
        assertFalse(lizard1.equals(spock1));
        assertFalse(spock1.equals(lizard1));

        Weapon lizard2 = new Lizard();
        assertFalse(lizard2.equals(spock1));
        assertFalse(spock1.equals(lizard2));

        Weapon spock2 = new Spock();
        assertFalse(spock2.equals(lizard1));
        assertFalse(lizard1.equals(spock2));
        assertFalse(spock2.equals(lizard2));
        assertFalse(lizard2.equals(spock2));
    }
}