package bowling.ScoresCalculation;


import bowling.Entities.FramesList;
import bowling.Entities.RollsList;

public interface IGameRules {

    int CalculateScoresForFrame(int FrameNumber, FramesList frames) throws Throwable;

    FramesList getFramesListFromRollsList (RollsList rolls) throws Throwable;

}
