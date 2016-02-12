package bowling.Entities;

import java.util.ArrayList;
import java.util.HashMap;

public class GameLog {

    private HashMap<String, RollsList> RollsMap;
    private ArrayList<String> PlayersList;

    public GameLog() {
        this.RollsMap = new HashMap<String, RollsList>();
        this.PlayersList = new ArrayList<String>();
    }

    public RollsList getPlayerRolls(String player) {
        return RollsMap.get(player);
    }

    public void assignRolls(String player, RollsList rolls) {
        if (!RollsMap.containsKey(player)) {
            PlayersList.add(player);
        }
        RollsMap.put(player,rolls);

    }

    public ArrayList<String> getPlayers(){
        ArrayList<String> result = new ArrayList<String>();
        for (String player:PlayersList) {
            result.add(player);
        }
        return result;
    }

    public void assignRolls(String player, Roll[] rolls) {
        this.assignRolls(player, new RollsList(rolls));
    }



}
