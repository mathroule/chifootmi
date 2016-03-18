package com.mathroule.chifootmi.game.player;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Test the human class.
 */
public class HumanTest {

    @Test
    public void testHuman() throws Exception {
        Human human = new HumanCLI("Toto", new Scanner(System.in), "");
        assertEquals("Toto", human.getName());
    }

    @Test
    public void testWin() throws Exception {
        Human human = new HumanCLI("Toto", new Scanner(System.in), "");
        assertEquals(0, human.getWin());
        assertEquals(0, human.getLoose());
        human.won();
        human.won();
        assertEquals(2, human.getWin());
        assertEquals(0, human.getLoose());
    }

    @Test
    public void testLoose() throws Exception {
        Human human = new HumanCLI("Toto", new Scanner(System.in), "");
        assertEquals(0, human.getWin());
        assertEquals(0, human.getLoose());
        human.loose();
        human.loose();
        human.loose();
        assertEquals(0, human.getWin());
        assertEquals(3, human.getLoose());
    }
}