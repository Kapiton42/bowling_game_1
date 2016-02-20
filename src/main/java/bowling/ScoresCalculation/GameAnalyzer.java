package bowling.ScoresCalculation;

import bowling.Entities.GameLog;

import java.util.ArrayList;
import java.util.HashMap;


public class GameAnalyzer {

    IGameRules rules;

    public GameAnalyzer(IGameRules rules) {
        this.rules = rules;
    }

    public HashMap<String,Integer> calculateScores(GameLog Log) throws Throwable {
        ArrayList<String> players = Log.getPlayers();

        HashMap<String,Integer> result = new HashMap<String, Integer>();

        for (String player:players) {
            result.put(
                    player,
                    rules.CalculateScoresForFramesList(
                            rules.getFramesListFromRollsList(Log.getPlayerRolls(player))
                    )
            );
        }
        return result;
    }

    public String getWinnerName(GameLog Log) throws Throwable {
        HashMap<String,Integer> results = calculateScores(Log);
        ArrayList<String> players = Log.getPlayers();
        String winner = players.get(1);
        int MaxScores = results.get(winner);
        for (String player:players) {
            if(results.get(player)>MaxScores) {
                winner = player; //PROBLEM: now draws are allowed. First player with max scores is winner.
            }
        }
        return winner;
    }

}
