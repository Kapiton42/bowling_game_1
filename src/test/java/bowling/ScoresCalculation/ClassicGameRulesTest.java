package bowling.ScoresCalculation;


import bowling.Entities.FramesList;
import bowling.Entities.RollsList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClassicGameRulesTest {

    RollsList rolls1,rolls2,rolls3;
    ClassicGameRules rules;
    
    @Before
    public void setUp() throws Exception {
        int[] DATA1 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int[] DATA2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] DATA3 = {
                8, 2,
                9, 1,
                10,
                8,1,
                10,
                9,1,
                10,
                9,1,
                6,3,
                9,1,
                10
        };

        rolls1 = RollsList.fromIntArray(DATA1);
        rolls2 = RollsList.fromIntArray(DATA2);
        rolls3 = RollsList.fromIntArray(DATA3);
        rules = new ClassicGameRules();
    }

    @Test
    public void testGetFramesListFromRollsList() throws Exception {
        FramesList frames = rules.getFramesListFromRollsList(rolls1);
        Assert.assertEquals(frames.count(),12);

        frames = rules.getFramesListFromRollsList(rolls2);
        Assert.assertEquals(frames.count(),10);

        frames = rules.getFramesListFromRollsList(rolls3);
        Assert.assertEquals(frames.count(),11);
    }

    @Test
    public void testCalculateScoresForFramesList() throws Exception {
        FramesList frames = rules.getFramesListFromRollsList(rolls1);
        Assert.assertEquals(rules.CalculateScoresForFramesList(frames),300);

        frames = rules.getFramesListFromRollsList(rolls2);
        Assert.assertEquals(rules.CalculateScoresForFramesList(frames),0);

        frames = rules.getFramesListFromRollsList(rolls3);
        Assert.assertEquals(rules.CalculateScoresForFramesList(frames),172);
    }
}