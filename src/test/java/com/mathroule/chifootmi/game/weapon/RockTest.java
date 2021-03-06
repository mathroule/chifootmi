package com.mathroule.chifootmi.game.weapon;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the rock weapon.
 */
public class RockTest {

    @Test
    public void testGetName() throws Exception {
        Rock rock = new Rock();
        assertEquals("rock", rock.getName());
    }

    @Test
    public void testHashCode() throws Exception {
        Rock rock1 = new Rock();
        Rock rock2 = new Rock();
        Rock rock3 = new Rock();
        Paper paper = new Paper();

        assertNotEquals(rock1.hashCode(), paper.hashCode());
        assertEquals(rock1.hashCode(), rock2.hashCode());
        assertEquals(rock2.hashCode(), rock3.hashCode());
        assertEquals(rock1.hashCode(), rock3.hashCode());
    }

    @Test
    public void testEqualsWithRock() throws Exception {
        Rock rock1 = new Rock();
        assertFalse(rock1.equals(null));
        assertTrue(rock1.equals(rock1));

        Rock rock2 = new Rock();
        assertTrue(rock1.equals(rock2));
        assertTrue(rock2.equals(rock1));

        Weapon rock3 = new Rock();
        assertFalse(rock3.equals(null));
        assertTrue(rock3.equals(rock3));
        assertTrue(rock1.equals(rock3));
        assertTrue(rock3.equals(rock1));
    }

    @Test
    public void testEqualsWithPaper() throws Exception {
        Rock rock1 = new Rock();
        Paper paper1 = new Paper();
        assertFalse(paper1.equals(rock1));
        assertFalse(rock1.equals(paper1));

        Weapon rock2 = new Rock();
        assertFalse(rock2.equals(paper1));
        assertFalse(paper1.equals(rock2));

        Weapon paper2 = new Paper();
        assertFalse(paper2.equals(rock1));
        assertFalse(rock1.equals(paper2));
        assertFalse(paper2.equals(rock2));
        assertFalse(rock2.equals(paper2));
    }

    @Test
    public void testEqualsWithScissors() throws Exception {
        Rock rock1 = new Rock();
        Scissors scissors1 = new Scissors();
        assertFalse(rock1.equals(scissors1));
        assertFalse(scissors1.equals(rock1));

        Weapon rock2 = new Rock();
        assertFalse(rock2.equals(scissors1));
        assertFalse(scissors1.equals(rock2));

        Weapon scissors2 = new Scissors();
        assertFalse(scissors2.equals(rock1));
        assertFalse(rock1.equals(scissors2));
        assertFalse(scissors2.equals(rock2));
        assertFalse(rock2.equals(scissors2));
    }
}