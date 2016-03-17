package com.mathroule.chifootmi;

import com.mathroule.chifootmi.game.Game;
import com.mathroule.chifootmi.game.Match;
import com.mathroule.chifootmi.game.rule.Basic;
import com.mathroule.chifootmi.game.rule.Extended;

import java.util.Arrays;

/**
 * Application main CLI.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("args: " + Arrays.asList(args));


        Game.getInstance().play(Match.Mode.COMPUTER_VS_COMPUTER, 3, new Basic());
        Game.getInstance().play(Match.Mode.COMPUTER_VS_COMPUTER, 5, new Extended());
    }
}
