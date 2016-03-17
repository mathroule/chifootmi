package com.mathroule.chifootmi.game.player;

import com.mathroule.chifootmi.game.player.Human;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test the human class.
 */
public class HumanTest {

    @Test
    public void testHuman() throws Exception {
        Human human = new Human("Toto");
        assertEquals("Toto", human.getName());
    }
}