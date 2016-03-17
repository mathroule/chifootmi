package com.mathroule.chifootmi.game;

import com.mathroule.chifootmi.player.Computer;
import com.mathroule.chifootmi.player.Human;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Test the match class.
 */
public class MatchTest {

    private Human human = new Human("Toto");

    private Computer computer1 = new Computer();

    private Computer computer2 = new Computer();

    @Test
    public void testMatchWithDefaultValues() throws Exception {
        Match match = new Match.MatchBuilder(computer1, computer2).build();
        assertEquals(computer1, match.getPlayer1());
        assertEquals(computer2, match.getPlayer2());
        assertEquals(1, match.getRound());
        assertEquals(Match.Mode.COMPUTER_VS_COMPUTER, match.getMode());
        assertEquals(false, match.hasIA());
    }

    @Test
    public void testMatchWithValidValues() throws Exception {
        Match match = new Match.MatchBuilder(human, computer1)
                .round(5)
                .mode(Match.Mode.HUMAN_VS_COMPUTER)
                .hasIA(true).build();
        assertEquals(human, match.getPlayer1());
        assertEquals(computer1, match.getPlayer2());
        assertEquals(5, match.getRound());
        assertEquals(Match.Mode.HUMAN_VS_COMPUTER, match.getMode());
        assertEquals(true, match.hasIA());
    }

    @Test
    public void testMatchWithNullPlayer1() throws Exception {
        try {
            new Match.MatchBuilder(null, computer2).build();
            fail("An IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("Player 1 should not be null", exception.getMessage());
        }
    }

    @Test
    public void testMatchWithNullPlayer2() throws Exception {
        try {
            new Match.MatchBuilder(computer1, null).build();
            fail("An IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("Player 2 should not be null", exception.getMessage());
        }
    }

    @Test
    public void testMatchWithNullPlayers() throws Exception {
        try {
            new Match.MatchBuilder(null, null).build();
            fail("An IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("Player 1 should not be null", exception.getMessage());
        }
    }

    @Test
    public void testMatchWithSamePlayers() throws Exception {
        try {
            new Match.MatchBuilder(human, human).build();
            fail("An IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("Players should be different", exception.getMessage());
        }
    }

    @Test
    public void testMatchWithInvalidRound() throws Exception {
        try {
            new Match.MatchBuilder(human, computer1).round(-5).build();
            fail("An IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("Number of round must be greater than zero", exception.getMessage());
        }
    }

    @Test
    public void testMatchWithInvalidAIMode() throws Exception {
        try {
            new Match.MatchBuilder(computer1, computer2)
                    .mode(Match.Mode.COMPUTER_VS_COMPUTER)
                    .hasIA(true).build();
            fail("An IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("IA mode is only available in Human vs Computer match", exception.getMessage());
        }
    }
}
