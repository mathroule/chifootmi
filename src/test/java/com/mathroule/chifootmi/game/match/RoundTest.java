package com.mathroule.chifootmi.game.match;

import com.mathroule.chifootmi.game.player.Computer;
import com.mathroule.chifootmi.game.player.Human;
import com.mathroule.chifootmi.game.rule.Basic;
import com.mathroule.chifootmi.game.weapon.Paper;
import com.mathroule.chifootmi.game.weapon.Scissors;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Test a round between two players.
 */
public class RoundTest {

    private final Human human = new Human("Toto");

    private final Computer computer = new Computer();

    private final Basic basic = Basic.getInstance();

    @Test
    public void tesRoundWithDefaultValues() throws Exception {
        try {
            // Test round won by human
            Round round1 = new Round.Builder(human, new Scissors(), computer, new Paper()).build();
            assertEquals(1, round1.getRound());
            assertEquals(human, round1.getPlayer1());
            assertEquals(computer, round1.getPlayer2());
            assertEquals(Round.Result.PLAYER_1_WIN, round1.getResult());
        } catch (Exception exception) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void tesRoundWithValidValues() throws Exception {
        try {
            // Test round won by computer
            Round round2 = new Round.Builder(human, new Paper(), computer, new Scissors())
                    .round(2)
                    .rules(basic).build();
            assertEquals(2, round2.getRound());
            assertEquals(human, round2.getPlayer1());
            assertEquals(computer, round2.getPlayer2());
            assertEquals(Round.Result.PLAYER_2_WIN, round2.getResult());
        } catch (Exception exception) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void tesRoundWithInvalidRound() throws Exception {
        try {
            new Round.Builder(human, new Scissors(), computer, new Paper())
                    .round(0)
                    .rules(basic).build();
            fail("An IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("Round number must be equal or greater than one", exception.getMessage());
        }

        try {
            new Round.Builder(human, new Scissors(), computer, new Paper())
                    .round(-5)
                    .rules(basic).build();
            fail("An IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("Round number must be equal or greater than one", exception.getMessage());
        }
    }

    @Test
    public void testRoundWithNullRules() throws Exception {
        try {
            new Round.Builder(human, new Scissors(), computer, new Paper())
                    .round(2)
                    .rules(null).build();
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Rules should not be null", exception.getMessage());
        }
    }

    @Test
    public void testRoundWithNullPlayer1() throws Exception {
        try {
            new Round.Builder(null, new Scissors(), computer, new Paper()).build();
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Player 1 should not be null", exception.getMessage());
        }
    }

    @Test
    public void testRoundWithNullPlayer2() throws Exception {
        try {
            new Round.Builder(computer, new Scissors(), null, new Paper()).build();
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Player 2 should not be null", exception.getMessage());
        }
    }

    @Test
    public void testRoundWithNullPlayers() throws Exception {
        try {
            new Round.Builder(null, new Scissors(), null, new Paper()).build();
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Player 1 should not be null", exception.getMessage());
        }
    }

    @Test
    public void testRoundWithNullWeapons() throws Exception {
        try {
            new Round.Builder(human, null, computer, null).build();
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Weapon 1 should not be null", exception.getMessage());
        }
    }

    @Test
    public void testRoundWithSamePlayers() throws Exception {
        try {
            new Round.Builder(human, new Scissors(), human, new Paper()).build();
            fail("An IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("Players should be different", exception.getMessage());
        }
    }
}