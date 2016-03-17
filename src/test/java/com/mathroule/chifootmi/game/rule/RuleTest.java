package com.mathroule.chifootmi.game.rule;

import com.mathroule.chifootmi.game.weapon.Paper;
import com.mathroule.chifootmi.game.weapon.Rock;
import com.mathroule.chifootmi.game.weapon.Scissors;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test a game rule.
 */
public class RuleTest {

    @Test
    public void testRuleWithValidValues() throws Exception {
        try {
            new Rule(new Scissors(), "cuts", new Paper());
        } catch (IllegalArgumentException exception) {
            fail("IllegalArgumentException should not be thrown");
        }
    }

    @Test
    public void testRuleWithNullWinningWeapon() throws Exception {
        try {
            new Rule(null, "cuts", new Paper());
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Winning weapon should not be null", exception.getMessage());
        }
    }

    @Test
    public void testRuleWithNullLoosingWeapon() throws Exception {
        try {
            new Rule(new Paper(), "cuts", null);
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Loosing weapon should not be null", exception.getMessage());
        }
    }

    @Test
    public void testRuleWithSameWeapons() throws Exception {
        try {
            new Rule(new Paper(), "cuts", new Paper());
            fail("An IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("Weapons should be different", exception.getMessage());
        }
    }

    @Test
    public void testIsRespected() throws Exception {
        Rule rule = new Rule(new Scissors(), "cuts", new Paper());
        assertEquals("scissors cuts paper", rule.toString());
        assertTrue(rule.isRespected(new Scissors(), new Paper()));

        // Test violating rules are not respected
        assertFalse(rule.isRespected(new Rock(), new Rock()));
        assertFalse(rule.isRespected(new Rock(), new Paper()));
        assertFalse(rule.isRespected(new Rock(), new Scissors()));
        assertFalse(rule.isRespected(new Paper(), new Paper()));
        assertFalse(rule.isRespected(new Paper(), new Paper()));
        assertFalse(rule.isRespected(new Paper(), new Scissors()));
        assertFalse(rule.isRespected(new Scissors(), new Rock()));
        assertFalse(rule.isRespected(new Scissors(), new Scissors()));
    }
}