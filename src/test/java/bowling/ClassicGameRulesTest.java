package bowling;

import bowling.Entities.FramesList;
import bowling.Entities.RollsList;
import bowling.ScoresCalculation.ClassicGameRules;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by boksh on 12.02.2016.
 */
public class ClassicGameRulesTest {

    public RollsList rolls;
    public ClassicGameRules rules;
    @Before
    public void setUp() throws Exception {
        int[] DATA = {5, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        rolls = RollsList.loadRollsArray(DATA);
        rules = new ClassicGameRules();
    }

    @Test
    public void testCalculateScoresForFrame() throws Exception {

    }

    @Test
    public void testGetFramesListFromRollsList() throws Exception {
        FramesList frames = rules.getFramesListFromRollsList(rolls);
        Assert.assertEquals(frames.count(),10);

    }
}