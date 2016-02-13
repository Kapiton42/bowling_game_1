package bowling.DataSources;

import bowling.Entities.GameLog;
import bowling.Entities.Roll;
import bowling.Entities.RollsList;

import java.io.*;


public class InputStreamGameLogSource implements IGameLogSource {

    private InputStream Stream;

    public InputStreamGameLogSource(InputStream stream) {
        Stream = stream;
    }

    public GameLog getGameLog() throws IOException {
        GameLog log = new GameLog();
        BufferedReader reader = new BufferedReader(new InputStreamReader(Stream));
        String line;
        while (((line = reader.readLine())!=null)){
            log.assignRolls(parsePlayerName(line),parseRollsList(line));
        }
        reader.close();
        return log;
    }

    private String parsePlayerName(String inputString){
        return inputString.split(":")[0];
    }

    private RollsList parseRollsList(String inputString){
        String[] rollsArray = inputString.split(":")[1].split(" ");
        RollsList rolls = new RollsList();
        for (String next:rollsArray) {
            rolls.addRoll(Roll.createRoll(Integer.parseInt(next)));
        }
        return rolls;
    }



}
