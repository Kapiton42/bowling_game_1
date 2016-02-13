package bowling.ScoresCalculation;

import bowling.Entities.GameLog;
import bowling.Entities.RollsList;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.mockito.Mockito.*;

public class GameAnalyzerTest {

    GameAnalyzer analyzer;
    GameLog log;

    @Before
    public void setUp() throws Exception {
        analyzer = new GameAnalyzer(new ClassicGameRules());
        log = mock(GameLog.class);

        int[] Player1Data = { 8, 2, 9, 1, 10, 8, 1, 10, 9, 1, 10, 9,1, 6, 3, 9, 1, 10 };
        int[] Player2Data = { 4, 2, 3, 5, 10, 8, 1, 10, 9, 1, 10, 9,1, 6, 3, 9, 1, 10 };

        ArrayList<String> players = new ArrayList<String>();
        players.add("Player 1");
        players.add("Player 2");

        when(log.getPlayers()).thenReturn(players);
        when(log.getPlayerRolls("Player 1")).thenReturn(RollsList.fromIntArray(Player1Data));
        when(log.getPlayerRolls("Player 2")).thenReturn(RollsList.fromIntArray(Player2Data));
    }

    @Test
    public void testCalculateScores() throws Throwable {
        HashMap<String,Integer> results =  analyzer.calculateScores(log);
        Assert.assertEquals(results.get("Player 1").intValue(), 172);
        Assert.assertEquals(results.get("Player 2").intValue(), 147);
    }

    @Test
    public void testGetWinnerName() throws Throwable {
        Assert.assertEquals(analyzer.getWinnerName(log),"Player 1");
    }
}