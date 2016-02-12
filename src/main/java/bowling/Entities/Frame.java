package bowling.Entities;


public class Frame {

    public RollsList Rolls;
    public int FrameID;

    public Frame(int FrameID, RollsList Rolls) {
        this.Rolls = Rolls;
        this.FrameID = FrameID;
    }

    public static Frame createFrame(int FrameID){
        return new Frame(FrameID, new RollsList());
    }

    public Frame addRoll(Roll roll){
        Rolls.addRoll(roll);
        return this;
    }

    public static Frame createFrame(int FrameID, RollsList Rolls) {
        return new Frame(FrameID, Rolls);
    }

    public Roll getRoll(int index) {
        return Rolls.getRoll(index);
    }

    @Override
    public String toString() {
        return "Frame{" +
                "FrameID=" + FrameID +
                ", Rolls=" + Rolls.toString() +
                '}';
    }
}