package com.mathroule.chifootmi;

import com.mathroule.chifootmi.game.Statistics;
import com.mathroule.chifootmi.game.match.Match;
import com.mathroule.chifootmi.game.match.Result;
import com.mathroule.chifootmi.game.player.Computer;
import com.mathroule.chifootmi.game.player.Human;
import com.mathroule.chifootmi.game.rule.Basic;
import com.mathroule.chifootmi.game.rule.Extended;
import com.mathroule.chifootmi.game.rule.Rules;
import com.mathroule.chifootmi.game.weapon.Weapon;

import java.util.List;
import java.util.Scanner;

/**
 * Application main CLI.
 */
public class Main {

    private static final int HUMAN_VS_COMPUTER = 1;
    private static final int COMPUTER_VS_COMPUTER = 2;
    private static final int DISPLAY_STATISTICS = 3;

    public static void main(String[] args) {
        System.out.println("Welcome in chifootmi");

        boolean playAgain = false;

        do {
            // Get game mode
            System.out.println("Choose mode:\n1) Human vs Computer\n2) Computer vs Computer\n3) Show statistics");
            Scanner scanner = new Scanner(System.in);
            int mode = HUMAN_VS_COMPUTER;
            if (scanner.hasNextInt()) {
                mode = scanner.nextInt();
            }

            // Display statistics
            if (mode == DISPLAY_STATISTICS) {
                System.out.println(Statistics.getInstance());
            } else {
                // Get game rules
                System.out.println("Choose rules:\n1) Rock-paper-scissors\n2) Rock-paper-scissors-lizard-Spock");
                int rule = 1;
                if (scanner.hasNextInt()) {
                    rule = scanner.nextInt();
                }
                Rules rules = rule == 1 ? new Basic() : new Extended();

                // Get number of rounds
                System.out.print("Input number of rounds: ");
                int round = 1;
                if (scanner.hasNextInt()) {
                    round = scanner.nextInt();
                }

                // Play the match
                Match match = null;
                List<Weapon> weapons = rules.getAvailableWeapons();
                if (mode == HUMAN_VS_COMPUTER) { // Play Human vs Computer
                    // Get player name
                    System.out.print("Input your name: ");
                    String name = null;
                    if (scanner.hasNext()) {
                        name = scanner.next();
                    }

                    // Generate weapons choice
                    String strWeapons = "";
                    int i = 1;
                    for (Weapon weapon : weapons) {
                        strWeapons += "\n" + (i++) + ") " + weapon;
                    }

                    // Create the match
                    Computer computer = new Computer();
                    match = new Match.MatchBuilder(new Human(name), computer)
                            .round(round)
                            .rules(rules)
                            .build();
                    System.out.println(match);

                    // Play all the rounds
                    while (match.hasRemainingRound()) {
                        // Get player weapon
                        int move = 1;
                        do {
                            System.out.println("Choose a move:" + strWeapons);
                            if (scanner.hasNextInt()) {
                                move = scanner.nextInt();
                            }
                        } while (move < 1 || weapons.size() < move);
                        Weapon humanWeapon = weapons.get(move - 1); // TODO check param is valid

                        // Generate computer weapon
                        Weapon computerWeapon = computer.getRandomWeapon(weapons);

                        // Play the round
                        System.out.println(match.playRound(humanWeapon, computerWeapon));
                    }
                } else if (mode == COMPUTER_VS_COMPUTER) { // Play Computer vs Computer
                    // Create the match
                    Computer computer1 = new Computer();
                    Computer computer2 = new Computer();
                    match = new Match.MatchBuilder(computer1, computer2)
                            .round(round)
                            .rules(rules)
                            .build();
                    System.out.println(match);

                    // Play all the rounds
                    while (match.hasRemainingRound()) {
                        // Generate computers weapons
                        Weapon weapon1 = computer1.getRandomWeapon(weapons);
                        Weapon weapon2 = computer2.getRandomWeapon(weapons);

                        // Play the round
                        System.out.println(match.playRound(weapon1, weapon2));
                    }
                }

                // Display match result
                if (match != null) {
                    Result result = match.getResult();
                    System.out.println(result);

                    // Save result for statistics
                    Statistics.getInstance().add(result);
                }
            }

            // Ask play again
            System.out.print("\nPlay again (y/n)? ");
            if (scanner.hasNext()) {
                playAgain = scanner.next().toLowerCase().equals("y");
            }
        } while (playAgain);
    }
}
