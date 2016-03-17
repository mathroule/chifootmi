package com.mathroule.chifootmi.weapon;

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
        // TODO
    }

    @Test
    public void testEqualsWithPaper() throws Exception {
        // TODO
    }

    @Test
    public void testEqualsWithScissors() throws Exception {
        // TODO
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
        // TODO
    }
}