package com.mathroule.chifootmi.weapon;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test the scissors weapon.
 */
public class ScissorsTest {

    @Test
    public void testGetName() throws Exception {
        Scissors scissors = new Scissors();
        assertEquals("scissors", scissors.getName());
    }

    @Test
    public void testEqualsWithRock() throws Exception {
        Scissors scissors1 = new Scissors();
        Rock rock1 = new Rock();
        assertFalse(scissors1.equals(rock1));
        assertFalse(rock1.equals(scissors1));

        Weapon scissors2 = new Scissors();
        assertFalse(scissors2.equals(rock1));
        assertFalse(rock1.equals(scissors2));

        Weapon rock2 = new Rock();
        assertFalse(rock2.equals(scissors1));
        assertFalse(scissors1.equals(rock2));
        assertFalse(rock2.equals(scissors2));
        assertFalse(scissors2.equals(rock2));
    }

    @Test
    public void testEqualsWithPaper() throws Exception {
        Scissors scissors1 = new Scissors();
        Paper paper1 = new Paper();
        assertFalse(scissors1.equals(paper1));
        assertFalse(paper1.equals(scissors1));

        Weapon scissors2 = new Scissors();
        assertFalse(scissors2.equals(paper1));
        assertFalse(paper1.equals(scissors2));

        Weapon paper2 = new Paper();
        assertFalse(paper2.equals(scissors1));
        assertFalse(scissors1.equals(paper2));
        assertFalse(paper2.equals(scissors2));
        assertFalse(scissors2.equals(paper2));
    }

    @Test
    public void testEqualsWithScissors() throws Exception {
        Scissors scissors1 = new Scissors();
        assertFalse(scissors1.equals(null));
        assertTrue(scissors1.equals(scissors1));

        Scissors scissors2 = new Scissors();
        assertTrue(scissors1.equals(scissors2));
        assertTrue(scissors2.equals(scissors1));

        Weapon scissors3 = new Scissors();
        assertFalse(scissors3.equals(null));
        assertTrue(scissors3.equals(scissors3));
        assertTrue(scissors1.equals(scissors3));
        assertTrue(scissors3.equals(scissors1));
    }
}