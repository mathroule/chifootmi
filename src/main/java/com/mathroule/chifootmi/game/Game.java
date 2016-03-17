package com.mathroule.chifootmi.game;


import com.mathroule.chifootmi.game.player.Computer;
import com.mathroule.chifootmi.game.player.Human;
import com.mathroule.chifootmi.game.rule.Rules;
import com.mathroule.chifootmi.game.weapon.Weapon;

import java.util.List;

/**
 * Implement a game.
 */
public class Game {

    private Game() {
    }

    private static class GameHolder {
        private final static Game instance = new Game();
    }

    public static Game getInstance() {
        return GameHolder.instance;
    }

    public Result autoPlay(int round, Rules rules) {
        // Play computer vs computer
        Computer computer1 = new Computer();
        Computer computer2 = new Computer();
        Match match = new Match.MatchBuilder(computer1, computer2)
                .round(round)
                .build();

        List<Weapon> weapons = rules.getAvailableWeapons();

        while (match.hasRemainingRound()) {
            Weapon weapon1 = computer1.getRandomWeapon(weapons);
            Weapon weapon2 = computer2.getRandomWeapon(weapons);
            match.playRound(weapon1, weapon2);
        }

        return match.getResult();
    }

    public Result play(Human human, int round, Rules rules) {
        // TODO
        return null;
    }
}
