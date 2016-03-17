package com.mathroule.chifootmi.player;

import org.junit.Test;

import java.util.Arrays;

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
}