package bowling.DataSources;

import bowling.Entities.GameLog;
import bowling.Entities.Roll;
import bowling.Entities.RollsList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class InputStreamGameLogSourceTest {

    ByteArrayInputStream MockArray;
    InputStreamGameLogSource source;
    RollsList testList;

    @Before
    public void setUp() throws Exception {
        MockArray = new ByteArrayInputStream(
        ("Player 1:10 10 10 10 10 10 10 10 10 10 5 5\r\n" +
         "Player 2:5 5 10 10 10 10 10 10 10 10 10 5 5").getBytes()
        );
        source = new InputStreamGameLogSource(MockArray);
        testList = new RollsList();
        testList.addRoll(new Roll(10));
        testList.addRoll(new Roll(10));
        testList.addRoll(new Roll(10));
        testList.addRoll(new Roll(10));
        testList.addRoll(new Roll(10));
        testList.addRoll(new Roll(10));
        testList.addRoll(new Roll(10));
        testList.addRoll(new Roll(10));
        testList.addRoll(new Roll(10));
        testList.addRoll(new Roll(10));
        testList.addRoll(new Roll(5));
        testList.addRoll(new Roll(5));
    }

    @Test
    public void testGetGameLog() throws Exception {
        GameLog log = source.getGameLog();

        Assert.assertEquals(log.getPlayers().size(),2);
        Assert.assertEquals(log.getPlayers().get(0),"Player 1");
        Assert.assertEquals(log.getPlayers().get(1),"Player 2");
        Assert.assertEquals(log.getPlayerRolls("Player 1").toString(),testList.toString());
    }
}