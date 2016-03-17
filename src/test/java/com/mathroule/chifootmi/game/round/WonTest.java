package com.mathroule.chifootmi.game.round;

import com.mathroule.chifootmi.player.Computer;
import com.mathroule.chifootmi.player.Human;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Test a won round between two players.
 */
public class WonTest {

    private Human human = new Human("Toto");

    private Computer computer = new Computer();

    @Test
    public void tesWinWithValidValues() throws Exception {
        try {
            // Test round won by human
            Won round1 = new Won(1, human, computer, human, "won by human");
            assertEquals(1, round1.getRound());
            assertEquals(human, round1.getPlayer1());
            assertEquals(computer, round1.getPlayer2());
            assertEquals(human, round1.getWinner());
            assertEquals("won by human", round1.getResult());

            // Test round won by computer
            Won round2 = new Won(2, human, computer, computer, "won by computer");
            assertEquals(2, round2.getRound());
            assertEquals(human, round2.getPlayer1());
            assertEquals(computer, round2.getPlayer2());
            assertEquals(computer, round2.getWinner());
            assertEquals("won by computer", round2.getResult());
        } catch (Exception exception) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void tesWinWithInvalidRound() throws Exception {
        try {
            new Won(0, human, computer, human, "");
            fail("An IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("Round number must be equal or greater than one", exception.getMessage());
        }

        try {
            new Won(-5, human, computer, human, "");
            fail("An IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("Round number must be equal or greater than one", exception.getMessage());
        }
    }

    @Test
    public void testWinWithNullPlayer1() throws Exception {
        try {
            new Won(1, null, human, human, "");
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Player 1 should not be null", exception.getMessage());
        }
    }

    @Test
    public void testWinWithNullPlayer2() throws Exception {
        try {
            new Won(1, computer, null, computer, "");
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Player 2 should not be null", exception.getMessage());
        }
    }

    @Test
    public void testWinWithNullPlayers() throws Exception {
        try {
            new Won(1, null, null, human, "");
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Player 1 should not be null", exception.getMessage());
        }
    }

    @Test
    public void testWinWithNullWinner() throws Exception {
        try {
            new Won(1, computer, human, null, "");
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Winner should not be null", exception.getMessage());
        }
    }

    @Test
    public void testWinWithSamePlayers() throws Exception {
        try {
            new Won(1, human, human, human, "");
            fail("An IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("Players should be different", exception.getMessage());
        }
    }

    @Test
    public void testWinWithWinnerNotPlayers() throws Exception {
        try {
            new Won(1, human, computer, new Human("Toto"), "");
            fail("An IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("Winner should be a player of the round", exception.getMessage());
        }
    }
}