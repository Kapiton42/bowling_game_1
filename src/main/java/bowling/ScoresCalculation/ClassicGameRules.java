package bowling.ScoresCalculation;


import bowling.Entities.Frame;
import bowling.Entities.FramesList;
import bowling.Entities.Roll;
import bowling.Entities.RollsList;

public class ClassicGameRules implements IGameRules {

    final private static int MAX_KNOCKED = 10;
    final private static int STANDARD_LAST_FRAMEID = 10;

    public int CalculateScoresForFrame(Frame frame, FramesList frames) {
        int scores = frame.getKnockedCount();

        if (frame.FrameID > STANDARD_LAST_FRAMEID) {
            return 0;
        }

        if (checkSpare(frame)) {
            scores+=calcBonusForSpare(frame, frames);
        } else if (checkStrike(frame)) {
            scores+=calcBonusForStrike(frame,frames);
        }

        return scores;
    }

    private int calcBonusForSpare(Frame frame, FramesList frames) {
        Frame nextFrame = frames.getFrame(frame.FrameID+1);
        return nextFrame.getRoll(1).Knocked;
    }

    private int calcBonusForStrike(Frame frame, FramesList frames) {
        Frame nextFrame = frames.getFrame(frame.FrameID+1);
        if (!checkStrike(nextFrame)){
            return nextFrame.getKnockedCount();
        }
        return nextFrame.getKnockedCount() + frames.getFrame(nextFrame.FrameID+1).getRoll(1).Knocked;
    }


    public boolean checkStrike(Frame frame) {
        return frame.getRollsCount() == 1 && frame.getKnockedCount() == MAX_KNOCKED;
    }

    public boolean checkSpare(Frame frame) {
        return frame.getRollsCount() == 2 && frame.getKnockedCount() == MAX_KNOCKED;
    }


    public FramesList getFramesListFromRollsList(RollsList rolls) {
        FramesList frames = new FramesList();

        int currentFrameID = 1;
        int currentRollID = 1;
        int positionInFrame = 1;
        Frame currentFrame = Frame.createFrame(currentFrameID);
        while (currentRollID <= rolls.count()) {
            Roll currentRoll = rolls.getRoll(currentRollID);
            currentRollID++;
            currentFrame.addRoll(currentRoll);

            if (currentFrame.getKnockedCount() == MAX_KNOCKED || positionInFrame==2 || currentRollID>rolls.count()) {
                frames.addFrame(currentFrame);
                currentFrameID++;
                currentFrame = Frame.createFrame(currentFrameID);
                positionInFrame=0;
            }
            positionInFrame++;
        }
        return frames;
    }

    public int CalculateScoresForFramesList(FramesList frames) {
        int scores = 0;
        for (Frame frame:frames) {
            scores += CalculateScoresForFrame(frame,frames);
        }
        return scores;
    }
}
