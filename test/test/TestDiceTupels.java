package test;

import org.junit.Assert;
import org.junit.Test;

import risk.DicePair;
import risk.DiceTriple;

public class TestDiceTupels {

    @Test
    public void testDoubleProperty() {
        DicePair oneTwo = new DicePair(1, 2);
        Assert.assertEquals(oneTwo.getDiceOne(), 2);
        Assert.assertEquals(oneTwo.getDiceTwo(), 1);
        oneTwo = new DicePair(2, 1);
        Assert.assertEquals(oneTwo.getDiceOne(), 2);
        Assert.assertEquals(oneTwo.getDiceTwo(), 1);
    }

    @Test
    public void testDoubleFight() {
        DicePair twoFive = new DicePair(2, 5);
        Assert.assertEquals(twoFive.getDiceOne(), 5);
        Assert.assertEquals(twoFive.getDiceTwo(), 2);

        Assert.assertEquals(twoFive.fight(1), 1);
        Assert.assertEquals(twoFive.fight(2), 1);
        Assert.assertEquals(twoFive.fight(3), 1);
        Assert.assertEquals(twoFive.fight(4), 1);
        Assert.assertEquals(twoFive.fight(5), -1);
        Assert.assertEquals(twoFive.fight(6), -1);

        Assert.assertEquals(twoFive.fight(new DicePair(1, 1)), 2);
        Assert.assertEquals(twoFive.fight(new DicePair(2, 1)), 2);
        Assert.assertEquals(twoFive.fight(new DicePair(2, 2)), 0);
        Assert.assertEquals(twoFive.fight(new DicePair(5, 1)), 0);
        Assert.assertEquals(twoFive.fight(new DicePair(3, 3)), 0);
        Assert.assertEquals(twoFive.fight(new DicePair(5, 2)), -2);

    }

    @Test
    public void testTriple() {
        DiceTriple oneTwoThree = new DiceTriple(1, 2, 3);
        DicePair twoThree = new DicePair(2, 3);
        Assert.assertEquals(oneTwoThree.bestTwo(), twoThree);

        DiceTriple oneOneOne = new DiceTriple(1, 1, 1);
        DiceTriple oneOneTwo = new DiceTriple(1, 1, 2);
        Assert.assertNotEquals(oneOneOne.bestTwo(), oneOneTwo.bestTwo());
        // (1, 1, 1), (1, 1, 2), (1, 1, 3), (1, 1, 4), (1, 1, 5), (1, 1, 6)
    }
}
