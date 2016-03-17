package com.mathroule.chifootmi.weapon;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Test the paper class.
 */
public class PaperTest {

    @Test
    public void testEqualsWithPaper() throws Exception {
        Paper paper1 = new Paper();
        assertFalse(paper1.equals(null));
        assertTrue(paper1.equals(paper1));

        Paper paper2 = new Paper();
        assertTrue(paper1.equals(paper2));
        assertTrue(paper2.equals(paper1));

        Weapon paper3 = new Paper();
        assertFalse(paper3.equals(null));
        assertTrue(paper3.equals(paper3));
        assertTrue(paper1.equals(paper3));
        assertTrue(paper3.equals(paper1));
    }

    @Test
    public void testEqualsWithRock() throws Exception {
        Paper paper1 = new Paper();
        Rock rock1 = new Rock();
        assertFalse(paper1.equals(rock1));
        assertFalse(rock1.equals(paper1));

        Weapon paper2 = new Paper();
        assertFalse(paper2.equals(rock1));
        assertFalse(rock1.equals(paper2));

        Weapon rock2 = new Rock();
        assertFalse(rock2.equals(paper1));
        assertFalse(paper1.equals(rock2));
        assertFalse(rock2.equals(paper2));
        assertFalse(paper2.equals(rock2));
    }

    @Test
    public void testEqualsWithScissors() throws Exception {
        Paper paper1 = new Paper();
        Scissors scissors1 = new Scissors();
        assertFalse(paper1.equals(scissors1));
        assertFalse(scissors1.equals(paper1));

        Weapon paper2 = new Paper();
        assertFalse(paper2.equals(scissors1));
        assertFalse(scissors1.equals(paper2));

        Weapon scissors2 = new Scissors();
        assertFalse(scissors2.equals(paper1));
        assertFalse(paper1.equals(scissors2));
        assertFalse(scissors2.equals(paper2));
        assertFalse(paper2.equals(scissors2));
    }
}