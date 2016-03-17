package com.mathroule.chifootmi.game;

import com.mathroule.chifootmi.game.player.Computer;
import com.mathroule.chifootmi.game.player.Human;
import com.mathroule.chifootmi.game.round.Draw;
import com.mathroule.chifootmi.game.round.Round;
import com.mathroule.chifootmi.game.round.Win;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Test a result between two players.
 */
public class ResultTest {

    private Human human1 = new Human("Tom");
    private Human human2 = new Human("Toto");

    private Computer computer = new Computer();

    @Test
    public void testResult() throws Exception {
        try {
            List<Round> rounds = new ArrayList<>();
            rounds.add(new Draw(1, human1, human2));
            rounds.add(new Win(2, human1, human2, human1, ""));
            Result result = new Result(human1, human2, rounds);
            assertEquals(1, result.getDraw());
            assertEquals("Match Tom vs Toto\n" +
                    "Round #1: Tom vs Toto has been a draw\n" +
                    "Round #2: Tom vs Toto has been won by Tom with \n" +
                    "Draw 1 times\n" +
                    "Tom wins 1 times\n" +
                    "Toto wins 0 times", result.toString());
        } catch (Exception exception) {
            fail("Exception should not be thrown");
        }
    }


    @Test
    public void testGetDraw() throws Exception {
        List<Round> rounds = new ArrayList<>();
        rounds.add(new Draw(1, human1, computer));
        rounds.add(new Draw(2, human1, computer));
        rounds.add(new Win(2, human1, computer, human1, ""));
        Result result = new Result(human1, computer, rounds);
        assertEquals(2, result.getDraw());
    }

    @Test
    public void testGetRounds() throws Exception {
        List<Round> rounds = new ArrayList<>();
        rounds.add(new Draw(1, human1, computer));
        rounds.add(new Draw(2, human1, computer));
        rounds.add(new Win(2, human1, computer, human1, ""));
        Result result = new Result(human1, computer, rounds);
        assertEquals(rounds, result.getRounds());
    }
}