package com.mathroule.chifootmi.game;

import com.mathroule.chifootmi.game.round.Draw;
import com.mathroule.chifootmi.game.round.Round;
import com.mathroule.chifootmi.game.round.Won;
import com.mathroule.chifootmi.game.player.Computer;
import com.mathroule.chifootmi.game.player.Human;
import com.mathroule.chifootmi.game.weapon.Paper;
import com.mathroule.chifootmi.game.weapon.Rock;
import com.mathroule.chifootmi.game.weapon.Scissors;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test a match between two players.
 */
public class MatchTest {

    private Human human1 = new Human("Tom");

    private Human human2 = new Human("Bob");

    private Computer computer1 = new Computer();

    private Computer computer2 = new Computer();

    @Test
    public void testMatchWithDefaultValues() throws Exception {
        try {
            Match match = new Match.MatchBuilder(computer1, computer2).build();
            assertEquals(computer1, match.getPlayer1());
            assertEquals(computer2, match.getPlayer2());
            assertEquals(1, match.getRound());
            assertEquals(Match.Mode.COMPUTER_VS_COMPUTER, match.getMode());
            assertEquals(false, match.hasIA());
        } catch (Exception exception) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void testMatchWithValidValues() throws Exception {
        try {
            Match match = new Match.MatchBuilder(human1, computer1)
                    .round(5)
                    .mode(Match.Mode.HUMAN_VS_COMPUTER)
                    .hasIA(true).build();
            assertEquals(human1, match.getPlayer1());
            assertEquals(computer1, match.getPlayer2());
            assertEquals(5, match.getRound());
            assertEquals(Match.Mode.HUMAN_VS_COMPUTER, match.getMode());
            assertEquals(true, match.hasIA());
        } catch (Exception exception) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void testMatchWithNullPlayer1() throws Exception {
        try {
            new Match.MatchBuilder(null, computer2).build();
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Player 1 should not be null", exception.getMessage());
        }
    }

    @Test
    public void testMatchWithNullPlayer2() throws Exception {
        try {
            new Match.MatchBuilder(computer1, null).build();
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Player 2 should not be null", exception.getMessage());
        }
    }

    @Test
    public void testMatchWithNullPlayers() throws Exception {
        try {
            new Match.MatchBuilder(null, null).build();
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Player 1 should not be null", exception.getMessage());
        }
    }

    @Test
    public void testMatchWithSamePlayers() throws Exception {
        try {
            new Match.MatchBuilder(human1, human1).build();
            fail("An IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("Players should be different", exception.getMessage());
        }
    }

    @Test
    public void testMatchWithNullRules() throws Exception {
        try {
            new Match.MatchBuilder(human1, computer1).rules(null).build();
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Rules should not be null", exception.getMessage());
        }
    }

    @Test
    public void testMatchWithInvalidRound() throws Exception {
        try {
            new Match.MatchBuilder(human1, computer1).round(-5).build();
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

    @Test
    public void testHasRemainingRound() throws Exception {
        Match match = new Match.MatchBuilder(human1, computer1).round(2).build();
        assertTrue(match.hasRemainingRound());

        // Play round 1 and 2
        match.playRound(new Rock(), new Paper());
        match.playRound(new Paper(), new Scissors());
        assertFalse(match.hasRemainingRound());
    }

    @Test
    public void testPlayTooMuchRound() throws Exception {
        Match match = new Match.MatchBuilder(human1, computer1).round(2).build();

        // Play round 1 and 2
        try {
            match.playRound(new Rock(), new Paper());
            match.playRound(new Paper(), new Scissors());
        } catch (UnsupportedOperationException exception) {
            fail("UnsupportedOperationException should not be thrown");
        }

        // Try to play a third round
        try {
            match.playRound(new Rock(), new Paper());
            fail("UnsupportedOperationException should not be thrown");
        } catch (UnsupportedOperationException exception) {
            assertEquals("No more rounds to play", exception.getMessage());
        }
    }

    @Test
    public void testPlayRound() throws Exception {
        Match match = new Match.MatchBuilder(human1, human2).round(9).build();

        // Round 1 : rock vs rock
        Round round1 = match.playRound(new Rock(), new Rock());
        assertTrue(round1 instanceof Draw);
        assertEquals(1, round1.getRound());
        assertEquals(human1, round1.getPlayer1());
        assertEquals(human2, round1.getPlayer2());
        assertEquals("draw", round1.getResult());
        assertEquals("Round #1: Tom vs Bob has been a draw", round1.toString());

        // Round 2 : rock vs paper
        Round round2 = match.playRound(new Rock(), new Paper());
        assertTrue(round2 instanceof Won);
        assertEquals(2, round2.getRound());
        assertEquals(human1, round2.getPlayer1());
        assertEquals(human2, round2.getPlayer2());
        assertEquals(human2, ((Won) round2).getWinner());
        assertEquals("paper covers rock", round2.getResult());
        assertEquals("Round #2: Tom vs Bob has been won by Bob with paper covers rock", round2.toString());

        // Round 3 : rock vs scissors
        Round round3 = match.playRound(new Rock(), new Scissors());
        assertTrue(round3 instanceof Won);
        assertEquals(3, round3.getRound());
        assertEquals(human1, round3.getPlayer1());
        assertEquals(human2, round3.getPlayer2());
        assertEquals(human1, ((Won) round3).getWinner());
        assertEquals("rock crushes scissors", round3.getResult());
        assertEquals("Round #3: Tom vs Bob has been won by Tom with rock crushes scissors", round3.toString());

        // Round 4 : paper vs rock
        Round round4 = match.playRound(new Paper(), new Rock());
        assertTrue(round4 instanceof Won);
        assertEquals(4, round4.getRound());
        assertEquals(human1, round4.getPlayer1());
        assertEquals(human2, round4.getPlayer2());
        assertEquals(human1, ((Won) round4).getWinner());
        assertEquals("paper covers rock", round4.getResult());
        assertEquals("Round #4: Tom vs Bob has been won by Tom with paper covers rock", round4.toString());

        // Round 5 : paper vs paper
        Round round5 = match.playRound(new Paper(), new Paper());
        assertTrue(round5 instanceof Draw);
        assertEquals(5, round5.getRound());
        assertEquals(human1, round5.getPlayer1());
        assertEquals(human2, round5.getPlayer2());
        assertEquals("draw", round5.getResult());
        assertEquals("Round #5: Tom vs Bob has been a draw", round5.toString());

        // Round 6 : paper vs scissors
        Round round6 = match.playRound(new Paper(), new Scissors());
        assertTrue(round6 instanceof Won);
        assertEquals(6, round6.getRound());
        assertEquals(human1, round6.getPlayer1());
        assertEquals(human2, round6.getPlayer2());
        assertEquals(human2, ((Won) round6).getWinner());
        assertEquals("scissors cuts paper", round6.getResult());
        assertEquals("Round #6: Tom vs Bob has been won by Bob with scissors cuts paper", round6.toString());

        // Round 7 : scissors vs rock
        Round round7 = match.playRound(new Scissors(), new Rock());
        assertTrue(round7 instanceof Won);
        assertEquals(7, round7.getRound());
        assertEquals(human1, round7.getPlayer1());
        assertEquals(human2, round7.getPlayer2());
        assertEquals(human2, ((Won) round7).getWinner());
        assertEquals("rock crushes scissors", round7.getResult());
        assertEquals("Round #7: Tom vs Bob has been won by Bob with rock crushes scissors", round7.toString());

        // Round 8 : scissors vs paper
        Round round8 = match.playRound(new Scissors(), new Paper());
        assertTrue(round8 instanceof Won);
        assertEquals(8, round8.getRound());
        assertEquals(human1, round8.getPlayer1());
        assertEquals(human2, round8.getPlayer2());
        assertEquals(human1, ((Won) round8).getWinner());
        assertEquals("scissors cuts paper", round8.getResult());
        assertEquals("Round #8: Tom vs Bob has been won by Tom with scissors cuts paper", round8.toString());

        // Round 9 : scissors vs scissors
        Round round9 = match.playRound(new Scissors(), new Scissors());
        assertTrue(round9 instanceof Draw);
        assertEquals(9, round9.getRound());
        assertEquals(human1, round9.getPlayer1());
        assertEquals(human2, round9.getPlayer2());
        assertEquals("draw", round9.getResult());
        assertEquals("Round #9: Tom vs Bob has been a draw", round9.toString());
    }
}
