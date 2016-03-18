package com.mathroule.chifootmi;

import com.mathroule.chifootmi.game.Statistics;
import com.mathroule.chifootmi.game.match.Match;
import com.mathroule.chifootmi.game.match.Result;
import com.mathroule.chifootmi.game.player.Computer;
import com.mathroule.chifootmi.game.player.HumanCLI;
import com.mathroule.chifootmi.game.player.Player;
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

    private static final String SHELL_INPUT = "\n> ";

    private static final int HUMAN_VS_COMPUTER = 1;
    private static final int COMPUTER_VS_COMPUTER = 2;
    private static final int DISPLAY_STATISTICS = 3;

    public static void main(String[] args) {
        System.out.println("Welcome in chifootmi");

        boolean playAgain = false;
        String playerName = null;

        do {
            // Get game mode (play Human vs Computer by default)
            System.out.print("Choose mode:\n1) Human vs Computer\n2) Computer vs Computer\n3) Show statistic" + SHELL_INPUT);
            Scanner scanner = new Scanner(System.in);
            int mode = 0;
            if (scanner.hasNextInt()) {
                mode = scanner.nextInt();
            }
            if (mode < 1 || mode > 3) {
                mode = HUMAN_VS_COMPUTER;
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

                // Get available weapons for the selected game rules
                List<Weapon> weapons = rules.getAvailableWeapons();

                // Create players
                Player player1 = null;
                Player player2 = new Computer();

                // Play Human vs Computer
                if (mode == HUMAN_VS_COMPUTER) {
                    // Get player name if not already done
                    if (playerName == null) {
                        System.out.print("Enter your name" + SHELL_INPUT);
                        if (scanner.hasNext()) {
                            playerName = scanner.next();
                        }
                    }

                    // Generate weapons choice
                    String chooseWeapons = "Choose a weapon:";
                    int i = 1;
                    for (Weapon weapon : weapons) {
                        chooseWeapons += "\n" + (i++) + ") " + weapon;
                    }
                    chooseWeapons += SHELL_INPUT;

                    player1 = new HumanCLI(playerName, scanner, chooseWeapons);
                } else if (mode == COMPUTER_VS_COMPUTER) { // Play Computer vs Computer
                    player1 = new Computer();
                }

                // Get number of rounds (play 1 round by default)
                System.out.print("Enter number of rounds" + SHELL_INPUT);
                int round = 1;
                if (scanner.hasNextInt()) {
                    round = scanner.nextInt();
                }

                // Create the match
                Match match = new Match.Builder(player1, player2)
                        .round(round)
                        .rules(rules)
                        .build();
                System.out.println(match);

                // Play all the rounds of the match
                while (match.hasRemainingRound()) {
                    // Play the round
                    assert player1 != null;
                    System.out.println(match.playRound(player1.pickWeapon(weapons), player2.pickWeapon(weapons)));
                }

                // Display match result
                Result result = match.getResult();
                System.out.println(result);

                // Save result for statistics
                Statistics.getInstance().add(result);
            }

            // Ask play again (default is true)
            System.out.print("\nPlay again (y/n)?" + SHELL_INPUT);
            if (scanner.hasNext()) {
                playAgain = !scanner.next().toLowerCase().equals("n");
            }
        } while (playAgain);
    }
}
