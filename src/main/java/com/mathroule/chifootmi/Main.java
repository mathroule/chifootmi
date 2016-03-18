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

    // TODO improve CLI
    private static final String SHELL_INPUT = "\n> ";

    private static final int HUMAN_VS_COMPUTER = 1;
    private static final int COMPUTER_VS_COMPUTER = 2;
    private static final int DISPLAY_STATISTICS = 3;

    public static void main(String[] args) {
        System.out.println("Welcome in chifootmi");

        boolean playAgain = false;

        do {
            // Get game mode (play Human vs Computer by default) // FIXME
            System.out.print("Choose mode:\n1) Human vs Computer\n2) Computer vs Computer\n3) Show statistic" + SHELL_INPUT);
            Scanner scanner = new Scanner(System.in);
            int mode = HUMAN_VS_COMPUTER;
            if (scanner.hasNextInt()) {
                mode = scanner.nextInt();
            }

            // Display statistics
            if (mode == DISPLAY_STATISTICS) {
                System.out.println(Statistics.getInstance());
            } else {
                // Get game rules (use basic rules by default)
                System.out.print("Choose rules:\n1) Rock-paper-scissors\n2) Rock-paper-scissors-lizard-Spock" + SHELL_INPUT);
                int rule = 1;
                if (scanner.hasNextInt()) {
                    rule = scanner.nextInt();
                }
                Rules rules = rule == 2 ? Extended.getInstance() : Basic.getInstance();

                // Get number of rounds (play 1 round by default)
                System.out.print("Enter number of rounds" + SHELL_INPUT);
                int round = 1;
                if (scanner.hasNextInt()) {
                    round = scanner.nextInt();
                }

                // Play the match
                Match match = null;
                List<Weapon> weapons = rules.getAvailableWeapons();

                // Play Human vs Computer
                if (mode == HUMAN_VS_COMPUTER) {
                    // Get player name // TODO persist name
                    System.out.print("Enter your name" + SHELL_INPUT);
                    String name = null;
                    if (scanner.hasNext()) {
                        name = scanner.next();
                    }

                    // Generate weapons choice
                    String chooseWeapons = "Choose a weapon:";
                    int i = 1;
                    for (Weapon weapon : weapons) {
                        chooseWeapons += "\n" + (i++) + ") " + weapon;
                    }
                    chooseWeapons += SHELL_INPUT;

                    // Create the match
                    Computer computer = new Computer();
                    match = new Match.Builder(new Human(name), computer)
                            .round(round)
                            .rules(rules)
                            .build();
                    System.out.println(match);

                    // Play all the rounds
                    while (match.hasRemainingRound()) {
                        // Get player weapon
                        int move = 1;
                        do {
                            System.out.print(chooseWeapons);
                            if (scanner.hasNextInt()) {
                                move = scanner.nextInt();
                            }
                        } while (move < 1 || weapons.size() < move);
                        Weapon humanWeapon = weapons.get(move - 1);

                        // Generate computer weapon
                        Weapon computerWeapon = computer.getRandomWeapon(weapons);

                        // Play the round
                        System.out.println(match.playRound(humanWeapon, computerWeapon));
                    }
                } else if (mode == COMPUTER_VS_COMPUTER) { // Play Computer vs Computer
                    // Create the match
                    Computer computer1 = new Computer();
                    Computer computer2 = new Computer();
                    match = new Match.Builder(computer1, computer2)
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

            // Ask play again (default is true)
            System.out.print("\nPlay again (y/n)?" + SHELL_INPUT);
            if (scanner.hasNext()) {
                playAgain = !scanner.next().toLowerCase().equals("n");
            }
        } while (playAgain);
    }
}
