package bowling.Entities;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by boksh on 13.02.2016.
 */
public class RollsListTest {

    @Test
    public void testFromIntArray() throws Exception {
        int[] DATA = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        RollsList rolls = RollsList.fromIntArray(DATA);

        Assert.assertEquals(rolls.count(),12);

    }
}