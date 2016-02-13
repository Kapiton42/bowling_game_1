package bowling;

import bowling.DataSources.InputStreamGameLogSource;
import bowling.Entities.GameLog;

import java.io.IOException;

public class Main {

    public static void main(String[] args){
        try {
            GameLog log = new InputStreamGameLogSource(System.in).getGameLog();

        } catch (IOException e) {
            System.err.print("Error during input data processing.");
            System.exit(-1);
        }

    }

}
