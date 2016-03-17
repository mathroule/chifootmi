package com.mathroule.chifootmi.game;

import com.mathroule.chifootmi.game.match.Result;

import java.util.ArrayList;

/**
 * Implement game statistics.
 */
public class Statistics extends ArrayList<Result> {

    private Statistics() {
    }

    private static class StatisticsHolder {
        private final static Statistics instance = new Statistics();
    }

    public static Statistics getInstance() {
        return StatisticsHolder.instance;
    }

    @Override
    public String toString() {
        String statistics = "";
        for (Result result : this) {
            statistics += "\n" + result;
        }
        return "Statistics:" + statistics;
    }
}