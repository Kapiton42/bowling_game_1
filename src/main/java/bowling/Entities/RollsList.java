package bowling.Entities;

import java.util.ArrayList;
import java.util.Iterator;

public class RollsList implements Iterable<Roll> {

    private ArrayList<Roll> rolls;

    public RollsList() {
        rolls = new ArrayList<Roll>();
    }

    public RollsList(Roll[] RollsArray) {
        rolls = new ArrayList<Roll>();
        for (Roll roll:RollsArray) {
            this.addRoll(roll);
        }
    }

    public Roll getRoll(int index) {
        return rolls.get(index-1);
    }

    public RollsList addRoll(Roll roll) {
        rolls.add(roll);
        return this;
    }

    public RollsList createRoll(int knocked) {
        Roll roll = new Roll(knocked);
        this.addRoll(roll);
        return this;
    }

    public static RollsList fromIntArray(int[] RollsKnocked) {
        RollsList newRollsList = new RollsList();
        for (int i: RollsKnocked) {
            newRollsList.createRoll(i);
        }
        return newRollsList;
    }

    public int count() {
        return rolls.size();
    }

    public Iterator<Roll> iterator() {
        return rolls.iterator();
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("RollsList[ ");
        for (Roll roll:this) {
            builder.append(roll.toString()).append(" ");
        }
        return builder.append("]").toString();

    }
}
