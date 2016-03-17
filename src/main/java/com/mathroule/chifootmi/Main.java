package com.mathroule.chifootmi;

import com.mathroule.chifootmi.game.Game;
import com.mathroule.chifootmi.game.Result;
import com.mathroule.chifootmi.game.rule.Basic;

import java.util.Arrays;

/**
 * Application main CLI.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("args: " + Arrays.asList(args));


        Result result = Game.getInstance().autoPlay(3, new Basic());
        System.out.println(result);
    }
}
