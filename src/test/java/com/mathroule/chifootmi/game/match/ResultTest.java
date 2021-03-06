package com.mathroule.chifootmi.game.match;

import com.mathroule.chifootmi.game.player.Computer;
import com.mathroule.chifootmi.game.player.Human;
import com.mathroule.chifootmi.game.player.HumanCLI;
import com.mathroule.chifootmi.game.weapon.Paper;
import com.mathroule.chifootmi.game.weapon.Scissors;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Test a result between two players.
 */
public class ResultTest {

    private final Human human1 = new HumanCLI("Tom", new Scanner(System.in), "");

    private final Human human2 = new HumanCLI("Rob", new Scanner(System.in), "");

    private final Computer computer = new Computer();

    @Test
    public void testResult() throws Exception {
        try {
            List<Round> rounds = new ArrayList<>();
            rounds.add(new Round.Builder(human1, new Paper(), human2, new Paper()).build());
            rounds.add(new Round.Builder(human1, new Scissors(), human2, new Paper()).round(2).build());
            Result result = new Result.Builder(human1, human2).rounds(rounds).build();
            assertEquals(1, result.getDraw());
            assertEquals("--- Match Tom vs Rob ---\n" +
                    "Draw 1 times\n" +
                    "Tom wins 1 times\n" +
                    "Rob wins 0 times", result.toString());
        } catch (Exception exception) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void testResultWithNullPlayer1() throws Exception {
        try {
            new Result.Builder(null, computer).build();
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Player 1 should not be null", exception.getMessage());
        }
    }

    @Test
    public void testResultWithNullPlayer2() throws Exception {
        try {
            new Result.Builder(human1, null).build();
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Player 2 should not be null", exception.getMessage());
        }
    }

    @Test
    public void testResultWithNullPlayers() throws Exception {
        try {
            new Result.Builder(null, null).build();
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Player 1 should not be null", exception.getMessage());
        }
    }

    @Test
    public void testResultWithNullRounds() throws Exception {
        try {
            new Result.Builder(human1, computer).rounds(null).build();
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Rounds should not be null", exception.getMessage());
        }
    }

    @Test
    public void testGetDraw() throws Exception {
        List<Round> rounds = new ArrayList<>();
        rounds.add(new Round.Builder(human1, new Paper(), human2, new Paper()).build());
        rounds.add(new Round.Builder(human1, new Paper(), human2, new Paper()).build());
        rounds.add(new Round.Builder(human1, new Scissors(), human2, new Paper()).build());
        Result result = new Result.Builder(human1, computer).rounds(rounds).build();
        assertEquals(2, result.getDraw());
    }
}