package bowling;

import bowling.DataSources.InputStreamGameLogSource;
import bowling.Entities.GameLog;
import bowling.ScoresCalculation.ClassicGameRules;
import bowling.ScoresCalculation.GameAnalyzer;

import java.io.IOException;

public class Main {

    public static void main(String[] args){
        try {
            GameLog log = new InputStreamGameLogSource(System.in).getGameLog();
            GameAnalyzer analyzer = new GameAnalyzer(new ClassicGameRules());

            String winner = analyzer.getWinnerName(log);
            System.out.print(winner + " win with " +
                    analyzer.calculateScores(log).get(winner) +
                    "scores");

        } catch (IOException e) {
            System.err.print("Error during input data processing.\r\n");
            System.exit(-1);

        } catch (Throwable throwable) {
            System.err.print("Unknown Error.\r\n");
            System.exit(-1);
        }

    }

}
