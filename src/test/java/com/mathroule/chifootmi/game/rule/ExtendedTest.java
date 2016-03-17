package com.mathroule.chifootmi.game.rule;

import com.mathroule.chifootmi.game.weapon.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test the extended game rules.
 */
public class ExtendedTest {

    private final Extended extended = new Extended();

    @Test
    public void testCompareNulls() throws Exception {
        try {
            extended.compare(null, null);
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Weapons should not be null", exception.getMessage());
        }
    }

    @Test
    public void testCompareRockAndLizard() throws Exception {
        assertEquals(1, extended.compare(new Rock(), new Lizard()));

        // Ensure that the relation is transitive
        Rock rock1 = new Rock();
        Rock rock2 = new Rock();
        assertEquals(0, extended.compare(rock1, rock2));
        Lizard lizard = new Lizard();
        assertTrue(Math.abs(extended.compare(rock1, lizard)) == Math.abs(extended.compare(rock2, lizard)));
    }

    @Test
    public void testCompareRockAndSpock() throws Exception {
        assertEquals(-1, extended.compare(new Rock(), new Spock()));

        // Ensure that the relation is transitive
        Rock rock1 = new Rock();
        Rock rock2 = new Rock();
        assertEquals(0, extended.compare(rock1, rock2));
        Spock spock = new Spock();
        assertTrue(Math.abs(extended.compare(rock1, spock)) == Math.abs(extended.compare(rock2, spock)));
    }

    @Test
    public void testComparePaperAndLizard() throws Exception {
        assertEquals(-1, extended.compare(new Paper(), new Lizard()));

        // Ensure that the relation is transitive
        Paper paper1 = new Paper();
        Paper paper2 = new Paper();
        assertEquals(0, extended.compare(paper1, paper2));
        Lizard lizard = new Lizard();
        assertTrue(Math.abs(extended.compare(paper1, lizard)) == Math.abs(extended.compare(paper2, lizard)));
    }

    @Test
    public void testComparePaperAndSpock() throws Exception {
        assertEquals(1, extended.compare(new Paper(), new Spock()));

        // Ensure that the relation is transitive
        Paper paper1 = new Paper();
        Paper paper2 = new Paper();
        assertEquals(0, extended.compare(paper1, paper2));
        Spock spock = new Spock();
        assertTrue(Math.abs(extended.compare(paper1, spock)) == Math.abs(extended.compare(paper2, spock)));
    }

    @Test
    public void testCompareScissorsAndLizard() throws Exception {
        assertEquals(1, extended.compare(new Scissors(), new Lizard()));

        // Ensure that the relation is transitive
        Scissors scissors1 = new Scissors();
        Scissors scissors2 = new Scissors();
        assertEquals(0, extended.compare(scissors1, scissors2));
        Lizard lizard = new Lizard();
        assertTrue(Math.abs(extended.compare(scissors1, lizard)) == Math.abs(extended.compare(scissors2, lizard)));
    }

    @Test
    public void testCompareScissorsAndSpock() throws Exception {
        assertEquals(-1, extended.compare(new Scissors(), new Spock()));

        // Ensure that the relation is transitive
        Scissors scissors1 = new Scissors();
        Scissors scissors2 = new Scissors();
        assertEquals(0, extended.compare(scissors1, scissors2));
        Spock spock = new Spock();
        assertTrue(Math.abs(extended.compare(scissors1, spock)) == Math.abs(extended.compare(scissors2, spock)));
    }

    @Test
    public void testCompareLizardAndRock() throws Exception {
        assertEquals(-1, extended.compare(new Lizard(), new Rock()));

        // Ensure that the relation is transitive
        Lizard lizard1 = new Lizard();
        Lizard lizard2 = new Lizard();
        assertEquals(0, extended.compare(lizard1, lizard2));
        Rock rock = new Rock();
        assertTrue(Math.abs(extended.compare(lizard1, rock)) == Math.abs(extended.compare(lizard2, rock)));
    }

    @Test
    public void testCompareLizardAndPaper() throws Exception {
        assertEquals(1, extended.compare(new Lizard(), new Paper()));

        // Ensure that the relation is transitive
        Lizard lizard1 = new Lizard();
        Lizard lizard2 = new Lizard();
        assertEquals(0, extended.compare(lizard1, lizard2));
        Paper paper = new Paper();
        assertTrue(Math.abs(extended.compare(lizard1, paper)) == Math.abs(extended.compare(lizard2, paper)));
    }

    @Test
    public void testCompareLizardAndScissors() throws Exception {
        assertEquals(-1, extended.compare(new Lizard(), new Scissors()));

        // Ensure that the relation is transitive
        Lizard lizard1 = new Lizard();
        Lizard lizard2 = new Lizard();
        assertEquals(0, extended.compare(lizard1, lizard2));
        Scissors scissors = new Scissors();
        assertTrue(Math.abs(extended.compare(lizard1, scissors)) == Math.abs(extended.compare(lizard2, scissors)));
    }

    @Test
    public void testCompareLizardAndLizard() throws Exception {
        Lizard lizard1 = new Lizard();
        Lizard lizard2 = new Lizard();
        assertEquals(0, extended.compare(lizard1, lizard1));
        assertEquals(0, extended.compare(lizard1, lizard2));
        assertEquals(0, extended.compare(lizard2, lizard1));

        // Ensure that the relation is transitive
        Lizard lizard3 = new Lizard();
        assertEquals(0, extended.compare(lizard2, lizard3));
        assertEquals(0, extended.compare(lizard1, lizard3));
    }

    @Test
    public void testCompareLizardAndSpock() throws Exception {
        assertEquals(1, extended.compare(new Lizard(), new Spock()));

        // Ensure that the relation is transitive
        Lizard lizard1 = new Lizard();
        Lizard lizard2 = new Lizard();
        assertEquals(0, extended.compare(lizard1, lizard2));
        Spock spock = new Spock();
        assertTrue(Math.abs(extended.compare(lizard1, spock)) == Math.abs(extended.compare(lizard2, spock)));
    }

    @Test
    public void testCompareLizardAndNull() throws Exception {
        Lizard lizard = new Lizard();
        try {
            extended.compare(null, lizard);
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Weapons should not be null", exception.getMessage());
        }
        try {
            extended.compare(lizard, null);
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Weapons should not be null", exception.getMessage());
        }
    }

    @Test
    public void testCompareSpockAndRock() throws Exception {
        assertEquals(1, extended.compare(new Spock(), new Rock()));

        // Ensure that the relation is transitive
        Spock spock1 = new Spock();
        Spock spock2 = new Spock();
        assertEquals(0, extended.compare(spock1, spock2));
        Rock rock = new Rock();
        assertTrue(Math.abs(extended.compare(spock1, rock)) == Math.abs(extended.compare(spock2, rock)));
    }

    @Test
    public void testCompareSpockAndPaper() throws Exception {
        assertEquals(-1, extended.compare(new Spock(), new Paper()));

        // Ensure that the relation is transitive
        Spock spock1 = new Spock();
        Spock spock2 = new Spock();
        assertEquals(0, extended.compare(spock1, spock2));
        Paper paper = new Paper();
        assertTrue(Math.abs(extended.compare(spock1, paper)) == Math.abs(extended.compare(spock2, paper)));
    }

    @Test
    public void testCompareSpockAndScissors() throws Exception {
        assertEquals(1, extended.compare(new Spock(), new Scissors()));

        // Ensure that the relation is transitive
        Spock spock1 = new Spock();
        Spock spock2 = new Spock();
        assertEquals(0, extended.compare(spock1, spock2));
        Scissors scissors = new Scissors();
        assertTrue(Math.abs(extended.compare(spock1, scissors)) == Math.abs(extended.compare(spock2, scissors)));
    }

    @Test
    public void testCompareSpockAndLizard() throws Exception {
        assertEquals(-1, extended.compare(new Spock(), new Lizard()));

        // Ensure that the relation is transitive
        Spock spock1 = new Spock();
        Spock spock2 = new Spock();
        assertEquals(0, extended.compare(spock1, spock2));
        Lizard lizard = new Lizard();
        assertTrue(Math.abs(extended.compare(spock1, lizard)) == Math.abs(extended.compare(spock2, lizard)));
    }

    @Test
    public void testCompareSpockAndSpock() throws Exception {
        Spock spock1 = new Spock();
        Spock spock2 = new Spock();
        assertEquals(0, extended.compare(spock1, spock1));
        assertEquals(0, extended.compare(spock1, spock2));
        assertEquals(0, extended.compare(spock2, spock1));

        // Ensure that the relation is transitive
        Spock spock3 = new Spock();
        assertEquals(0, extended.compare(spock2, spock3));
        assertEquals(0, extended.compare(spock1, spock3));
    }

    @Test
    public void testCompareSpockAndNull() throws Exception {
        Spock spock = new Spock();
        try {
            extended.compare(null, spock);
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Weapons should not be null", exception.getMessage());
        }
        try {
            extended.compare(spock, null);
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals("Weapons should not be null", exception.getMessage());
        }
    }

    @Test
    public void testGetAvailableWeapons() throws Exception {
        List<Weapon> weapons = new ArrayList<>();
        weapons.add(new Rock());
        weapons.add(new Paper());
        weapons.add(new Scissors());
        weapons.add(new Lizard());
        weapons.add(new Spock());

        assertEquals(weapons, extended.getAvailableWeapons());
    }
}