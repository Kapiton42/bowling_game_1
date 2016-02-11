package bowling;


public class Frame {

    public RollsList Rolls;
    public int FrameID;

    public Frame(int FrameID, RollsList Rolls) {
        this.Rolls = Rolls;
        this.FrameID = FrameID;
    }

    public static Frame createFrame(int FrameID, RollsList Rolls) {
        return new Frame(FrameID, Rolls);
    }

    @Override
    public String toString() {
        return "Frame{" +
                "FrameID=" + FrameID +
                ", Rolls=" + Rolls.toString() +
                '}';
    }
}
