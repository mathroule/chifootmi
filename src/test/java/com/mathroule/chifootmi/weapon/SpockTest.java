package com.mathroule.chifootmi.weapon;

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
        // TODO
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