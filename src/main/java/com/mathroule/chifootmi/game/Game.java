package com.mathroule.chifootmi.game;


import com.mathroule.chifootmi.game.player.Computer;
import com.mathroule.chifootmi.game.rule.Rules;
import com.mathroule.chifootmi.game.weapon.Weapon;

import java.util.List;

public class Game {

    private Game() {
    }

    private static class GameHolder {
        private final static Game instance = new Game();
    }

    public void play(Match.Mode mode, int round, Rules rules) {
        // Play computer vs computer
        if (mode.equals(Match.Mode.COMPUTER_VS_COMPUTER)) {
            Computer computer1 = new Computer();
            Computer computer2 = new Computer();
            Match match = new Match.MatchBuilder(computer1, computer2)
                    .round(round)
                    .build();

            List<Weapon> weapons = rules.getAvailableWeapons();

            while (match.hasRemainingRound()) {
                Weapon weapon1 = computer1.getRandomWeapon(weapons);
                Weapon weapon2 = computer2.getRandomWeapon(weapons);
                System.out.println(match.playRound(weapon1, weapon2));
            }

            System.out.println(match.getResult());
        }
    }

    public static Game getInstance() {
        return GameHolder.instance;
    }
}
