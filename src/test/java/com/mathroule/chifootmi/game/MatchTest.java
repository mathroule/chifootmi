package com.mathroule.chifootmi.game;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the match class.
 */
public class MatchTest {

    @Test
    public void testMatchWithDefaultValues() throws Exception {
        Match match = new Match.MatchBuilder().build();
        assertEquals(1, match.getRound());
        assertEquals(Match.Mode.COMPUTER_VS_COMPUTER, match.getMode());
        assertEquals(false, match.hasIA());
    }

    @Test
    public void testMatchWithValidValues() throws Exception {
        Match match = new Match.MatchBuilder().round(5).mode(Match.Mode.HUMAN_VS_COMPUTER).hasIA(true).build();
        assertEquals(5, match.getRound());
        assertEquals(Match.Mode.HUMAN_VS_COMPUTER, match.getMode());
        assertEquals(true, match.hasIA());
    }

    @Test
    public void testMatchWithInvalidRound() throws Exception {
        try {
            new Match.MatchBuilder().round(-5).build();
            fail("An IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("Number of round must be greater than zero", exception.getMessage());
        }
    }

    @Test
    public void testMatchWithInvalidAIMode() throws Exception {
        try {
            new Match.MatchBuilder().mode(Match.Mode.COMPUTER_VS_COMPUTER).hasIA(true).build();
            fail("An IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("IA mode is only available in Human vs Computer match", exception.getMessage());
        }
    }
}