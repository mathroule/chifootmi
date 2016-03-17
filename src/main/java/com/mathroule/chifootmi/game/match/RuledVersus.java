package com.mathroule.chifootmi.game.match;

import com.mathroule.chifootmi.game.player.Player;
import com.mathroule.chifootmi.game.rule.Rules;

/**
 * Abstract a versus using rules between two players.
 */
public abstract class RuledVersus extends Versus {

    /**
     * Rules of the versus.
     */
    protected final Rules rules;

    /**
     * Versus with rules constructor.
     *
     * @param player1 the first player of the round
     * @param player2 the second player of the round
     * @param rules   the rules of the round
     */
    public RuledVersus(final Player player1, final Player player2, final Rules rules) {
        super(player1, player2);

        // Check rules is not null
        if (rules == null) {
            throw new NullPointerException("Rules should not be null");
        }

        this.rules = rules;
    }
}
