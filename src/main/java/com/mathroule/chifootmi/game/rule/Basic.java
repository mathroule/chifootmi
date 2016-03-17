package com.mathroule.chifootmi.game.rule;


import com.mathroule.chifootmi.weapon.Paper;
import com.mathroule.chifootmi.weapon.Rock;
import com.mathroule.chifootmi.weapon.Scissors;
import com.mathroule.chifootmi.weapon.Weapon;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement the basic games rules.
 */
public class Basic implements Rules {
    // TODO convert to singleton

    /**
     * Represent all winning moves.
     */
    // TODO put in parent and use same key for multiple winning moves
    // private Map<Weapon, List<Weapon>> winningMoves = new HashMap<>(3);
    private Map<Weapon, Weapon> winningMoves = new HashMap<>(3);

    public Basic() {
        // Scissors cuts paper
        winningMoves.put(new Scissors(), new Paper());

        // Paper covers rock
        winningMoves.put(new Paper(), new Rock());

        // Rock crushes scissors
        winningMoves.put(new Rock(), new Scissors());
    }

    @Override
    public int compare(Weapon o1, Weapon o2) {
        // Return draw if weapons are equals
        if (o1.equals(o2)) {
            return 0;
        }

        // Return win if first weapon beat second weapon
        if (winningMoves.containsKey(o1)) {
            Weapon o3 = winningMoves.get(o1);
            if (o3 != null && o2.equals(o3)) {
                return 1;
            }
        }

        // Return lose otherwise
        return -1;
    }
}
