package com.mathroule.chifootmi.game.round;

import com.mathroule.chifootmi.game.Match;
import com.mathroule.chifootmi.player.Computer;
import com.mathroule.chifootmi.player.Human;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Test a draw round between two players.
 */
public class DrawTest {
    private Human human = new Human("Toto");

    private Computer computer = new Computer();

    @Test
    public void tesDrawWithValidValues() throws Exception {
        try {
            // Test draw round
            Draw round = new Draw(1, human, computer);
            assertEquals(1, round.getRound());
            assertEquals(human, round.getPlayer1());
            assertEquals(computer, round.getPlayer2());
            assertEquals("draw", round.getResult());
        } catch (Exception exception) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void tesDrawWithInvalidRound() throws Exception {
        try {
            new Draw(0, null, computer);
            fail("An IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("Round number must be equal or greater than one", exception.getMessage());
        }

        try {
            new Draw(-5, null, computer);
            fail("An IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("Round number must be equal or greater than one", exception.getMessage());
        }
    }

    @Test
    public void testDrawWithNullPlayer1() throws Exception {
        try {
            new Draw(1, null, computer);
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Player 1 should not be null", exception.getMessage());
        }
    }

    @Test
    public void testDrawWithNullPlayer2() throws Exception {
        try {
            new Draw(1, human, null);
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Player 2 should not be null", exception.getMessage());
        }
    }

    @Test
    public void testDrawWithNullPlayers() throws Exception {
        try {
            new Draw(1, null, null);
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Player 1 should not be null", exception.getMessage());
        }
    }

    @Test
    public void testDrawWithSamePlayers() throws Exception {
        try {
            new Draw(1, human, human);
            fail("An IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("Players should be different", exception.getMessage());
        }
    }
}