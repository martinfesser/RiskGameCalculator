package test;

import org.junit.Assert;
import org.junit.Test;

import risk.DiceCollection;

/**
 * @author fessermn
 *
 */
public class TestDiceCollection {

    @Test
    public void testAdd() {
        DiceCollection dc = new DiceCollection();
        Integer one = 1;
        dc.add(one);
        dc.add(2);
        dc.add(3);

        Assert.assertEquals("(1, 2, 3)", dc.toString());
        Assert.assertEquals(dc.get(0), one);
        Assert.assertEquals(dc.get(1), (Integer) 2);
        Assert.assertEquals(dc.get(2), (Integer) 3);

    }
}
