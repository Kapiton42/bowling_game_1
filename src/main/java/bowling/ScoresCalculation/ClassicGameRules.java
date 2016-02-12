package bowling.ScoresCalculation;


import bowling.Entities.Frame;
import bowling.Entities.FramesList;
import bowling.Entities.Roll;
import bowling.Entities.RollsList;

public class ClassicGameRules implements IGameRules {

    final private static int STRIKE_COUNT = 10;
    final private static int STANDARD_LAST_FRAMEID = 10;

    public int CalculateScoresForFrame(int FrameNumber, FramesList frames) {
        Frame frame = frames.getFrame(FrameNumber);
        int Summary = 0;


        return 0;
    }

    public FramesList getFramesListFromRollsList(RollsList rolls) {
        FramesList frames = new FramesList();

        int currentFrameID = 1;
        int currentRollID = 1;
        while (currentRollID < rolls.count()) {
            Frame currentFrame = Frame.createFrame(currentFrameID);

            Roll currentRoll = rolls.getRoll(currentRollID);
            currentRoll.setPosition(1);
            currentFrame.addRoll(currentRoll);

            switch (currentRoll.Knocked){
                case STRIKE_COUNT:

                    break;
                default:
                    currentRollID++;
                    currentRoll.setPosition(2);
                    currentFrame.addRoll(currentRoll);

                    break;
            }
            currentRollID++;
            currentFrameID++;
            frames.addFrame(currentFrame);
        }
        return frames;
    }
}
