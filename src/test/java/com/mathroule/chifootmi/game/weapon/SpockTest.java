package com.mathroule.chifootmi.game.weapon;

import com.mathroule.chifootmi.game.weapon.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the Spock weapon.
 */
public class SpockTest {

    @Test
    public void testGetName() throws Exception {
        Spock spock = new Spock();
        assertEquals("spock", spock.getName());
    }

    @Test
    public void testEqualsWithRock() throws Exception {
        Spock spock1 = new Spock();
        Rock rock1 = new Rock();
        assertFalse(spock1.equals(rock1));
        assertFalse(rock1.equals(spock1));

        Weapon spock2 = new Spock();
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
        Spock spock1 = new Spock();
        Paper paper1 = new Paper();
        assertFalse(paper1.equals(spock1));
        assertFalse(spock1.equals(paper1));

        Weapon spock2 = new Spock();
        assertFalse(spock2.equals(paper1));
        assertFalse(paper1.equals(spock2));

        Weapon paper2 = new Paper();
        assertFalse(paper2.equals(spock1));
        assertFalse(spock1.equals(paper2));
        assertFalse(paper2.equals(spock2));
        assertFalse(spock2.equals(paper2));
    }

    @Test
    public void testEqualsWithScissors() throws Exception {
        Spock spock1 = new Spock();
        Scissors scissors1 = new Scissors();
        assertFalse(spock1.equals(scissors1));
        assertFalse(scissors1.equals(spock1));

        Weapon spock2 = new Spock();
        assertFalse(spock2.equals(scissors1));
        assertFalse(scissors1.equals(spock2));

        Weapon scissors2 = new Scissors();
        assertFalse(scissors2.equals(spock1));
        assertFalse(spock1.equals(scissors2));
        assertFalse(scissors2.equals(spock2));
        assertFalse(spock2.equals(scissors2));
    }

    @Test
    public void testEqualsWithLizard() throws Exception {
        Spock spock1 = new Spock();
        Lizard lizard1 = new Lizard();
        assertFalse(spock1.equals(lizard1));
        assertFalse(lizard1.equals(spock1));

        Weapon spock2 = new Spock();
        assertFalse(spock2.equals(lizard1));
        assertFalse(lizard1.equals(spock2));

        Weapon lizard2 = new Lizard();
        assertFalse(lizard2.equals(spock1));
        assertFalse(spock1.equals(lizard2));
        assertFalse(lizard2.equals(spock2));
        assertFalse(spock2.equals(lizard2));
    }

    @Test
    public void testEqualsWithSpock() throws Exception {
        Spock spock1 = new Spock();
        assertFalse(spock1.equals(null));
        assertTrue(spock1.equals(spock1));

        Spock spock2 = new Spock();
        assertTrue(spock1.equals(spock2));
        assertTrue(spock2.equals(spock1));

        Weapon spock3 = new Spock();
        assertFalse(spock3.equals(null));
        assertTrue(spock3.equals(spock3));
        assertTrue(spock1.equals(spock3));
        assertTrue(spock3.equals(spock1));
    }
}