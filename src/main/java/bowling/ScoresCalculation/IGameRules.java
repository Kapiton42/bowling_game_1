package bowling.ScoresCalculation;


import bowling.Entities.Frame;
import bowling.Entities.FramesList;
import bowling.Entities.RollsList;

public interface IGameRules {

    int CalculateScoresForFrame(Frame frame, FramesList frames) throws Throwable;

    FramesList getFramesListFromRollsList (RollsList rolls) throws Throwable;

    int CalculateScoresForFramesList(FramesList frames) throws Throwable;
}
