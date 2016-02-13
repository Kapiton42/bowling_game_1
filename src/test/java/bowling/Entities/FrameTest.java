package bowling.Entities;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by boksh on 13.02.2016.
 */
public class FrameTest {

    Frame frame;

    @Before
    public void setUp() throws Exception {
        frame = Frame.createFrame(1);
        frame.addRoll(Roll.createRoll(4)).addRoll(Roll.createRoll(3));
    }

    @Test
    public void testGetRollsCount() throws Exception {
        Assert.assertEquals(frame.getRollsCount(),2);
    }

    @Test
    public void testGetKnockedCount() throws Exception {
        Assert.assertEquals(frame.getKnockedCount(),7);
    }
}