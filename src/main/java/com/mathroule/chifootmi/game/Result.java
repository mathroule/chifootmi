package com.mathroule.chifootmi.game;

import com.mathroule.chifootmi.game.player.Player;
import com.mathroule.chifootmi.game.round.Draw;
import com.mathroule.chifootmi.game.round.Round;

import java.util.List;

/**
 * Implement a match result;
 */
public class Result extends Versus {

    /**
     * Rounds of the match.
     */
    private final List<Round> rounds;

    private int draw = 0;

    public Result(final Player player1, final Player player2, final List<Round> rounds) {
        super(player1, player2);
        this.rounds = rounds;

        // Compute the count of draw rounds
        for (Round round : rounds) {
            if (round instanceof Draw) {
                draw++;
            }
        }
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public int getDraw() {
        return draw;
    }

    @Override
    public String toString() {
        String strRounds = "";
        for (Round round : rounds) {
            strRounds += round + "\n";
        }
        return "Match " + super.toString()
                + "\n" + strRounds
                + "Draw " + draw + " times"
                + "\n" + player1 + " wins " + player1.getWin() + " times"
                + "\n" + player2 + " wins " + player2.getWin() + " times";
    }
}
