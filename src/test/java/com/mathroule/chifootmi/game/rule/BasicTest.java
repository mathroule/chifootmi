package com.mathroule.chifootmi.game.rule;

import com.mathroule.chifootmi.weapon.Paper;
import com.mathroule.chifootmi.weapon.Rock;
import com.mathroule.chifootmi.weapon.Scissors;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the basic game rules.
 */
public class BasicTest {

    private final Basic basic = new Basic();

    @Test
    public void testCompareNulls() throws Exception {
        try {
            basic.compare(null, null);
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals(null, exception.getMessage());
        }
    }

    @Test
    public void testCompareRocks() throws Exception {
        Rock rock1 = new Rock();
        Rock rock2 = new Rock();
        assertEquals(0, basic.compare(rock1, rock1));
        assertEquals(0, basic.compare(rock1, rock2));
        assertEquals(0, basic.compare(rock2, rock1));

        // Ensure that the relation is transitive
        Rock rock3 = new Rock();
        assertEquals(0, basic.compare(rock2, rock3));
        assertEquals(0, basic.compare(rock1, rock3));
    }

    @Test
    public void testCompareRockAndPaper() throws Exception {
        assertEquals(-1, basic.compare(new Rock(), new Paper()));

        // Ensure that the relation is transitive
        Rock rock1 = new Rock();
        Rock rock2 = new Rock();
        assertEquals(0, basic.compare(rock1, rock2));
        Paper paper = new Paper();
        assertTrue(Math.abs(basic.compare(rock1, paper)) == Math.abs(basic.compare(rock2, paper)));
    }

    @Test
    public void testCompareRockAndScissors() throws Exception {
        assertEquals(1, basic.compare(new Rock(), new Scissors()));

        // Ensure that the relation is transitive
        Rock rock1 = new Rock();
        Rock rock2 = new Rock();
        assertEquals(0, basic.compare(rock1, rock2));
        Scissors scissors = new Scissors();
        assertTrue(Math.abs(basic.compare(rock1, scissors)) == Math.abs(basic.compare(rock2, scissors)));
    }

    @Test
    public void testCompareRockAndNull() throws Exception {
        Rock rock = new Rock();
        try {
            basic.compare(null, rock);
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals(null, exception.getMessage());
        }
        try {
            basic.compare(rock, null);
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals(null, exception.getMessage());
        }
    }

    @Test
    public void testComparePaperAndRock() throws Exception {
        assertEquals(1, basic.compare(new Paper(), new Rock()));

        // Ensure that the relation is transitive
        Paper paper1 = new Paper();
        Paper paper2 = new Paper();
        assertEquals(0, basic.compare(paper1, paper2));
        Rock rock = new Rock();
        assertTrue(Math.abs(basic.compare(paper1, rock)) == Math.abs(basic.compare(paper2, rock)));
    }

    @Test
    public void testComparePapers() throws Exception {
        Paper paper1 = new Paper();
        Paper paper2 = new Paper();
        assertEquals(0, basic.compare(paper1, paper1));
        assertEquals(0, basic.compare(paper1, paper2));
        assertEquals(0, basic.compare(paper2, paper1));

        // Ensure that the relation is transitive
        Paper paper3 = new Paper();
        assertEquals(0, basic.compare(paper2, paper3));
        assertEquals(0, basic.compare(paper1, paper3));
    }

    @Test
    public void testComparePaperAndScissors() throws Exception {
        assertEquals(-1, basic.compare(new Paper(), new Scissors()));

        // Ensure that the relation is transitive
        Paper paper1 = new Paper();
        Paper paper2 = new Paper();
        assertEquals(0, basic.compare(paper1, paper2));
        Scissors scissors = new Scissors();
        assertTrue(Math.abs(basic.compare(paper1, scissors)) == Math.abs(basic.compare(paper2, scissors)));
    }

    @Test
    public void testComparePaperAndNull() throws Exception {
        Paper paper = new Paper();
        try {
            basic.compare(null, paper);
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals(null, exception.getMessage());
        }
        try {
            basic.compare(paper, null);
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals(null, exception.getMessage());
        }
    }

    @Test
    public void testCompareScissorsAndRock() throws Exception {
        assertEquals(-1, basic.compare(new Scissors(), new Rock()));

        // Ensure that the relation is transitive
        Scissors scissors1 = new Scissors();
        Scissors scissors2 = new Scissors();
        assertEquals(0, basic.compare(scissors1, scissors2));
        Rock rock = new Rock();
        assertTrue(Math.abs(basic.compare(scissors1, rock)) == Math.abs(basic.compare(scissors2, rock)));
    }

    @Test
    public void testCompareScissorsAndPaper() throws Exception {
        assertEquals(1, basic.compare(new Scissors(), new Paper()));

        // Ensure that the relation is transitive
        Scissors scissors1 = new Scissors();
        Scissors scissors2 = new Scissors();
        assertEquals(0, basic.compare(scissors1, scissors2));
        Paper paper = new Paper();
        assertTrue(Math.abs(basic.compare(scissors1, paper)) == Math.abs(basic.compare(scissors2, paper)));
    }

    @Test
    public void testCompareScissors() throws Exception {
        Scissors scissors1 = new Scissors();
        Scissors scissors2 = new Scissors();
        assertEquals(0, basic.compare(scissors1, scissors1));
        assertEquals(0, basic.compare(scissors1, scissors2));
        assertEquals(0, basic.compare(scissors2, scissors1));

        // Ensure that the relation is transitive
        Scissors scissors3 = new Scissors();
        assertEquals(0, basic.compare(scissors2, scissors3));
        assertEquals(0, basic.compare(scissors1, scissors3));
    }

    @Test
    public void testCompareScissorsAndNull() throws Exception {
        Scissors scissors = new Scissors();
        try {
            basic.compare(null, scissors);
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals(null, exception.getMessage());
        }
        try {
            basic.compare(scissors, null);
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException exception) {
            assertEquals(null, exception.getMessage());
        }
    }
}