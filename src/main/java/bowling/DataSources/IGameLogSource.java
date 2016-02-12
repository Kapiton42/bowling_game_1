package bowling.DataSources;

import bowling.Entities.GameLog;

/**
 * Created by boksh on 13.02.2016.
 */
public interface IGameLogSource {

    public GameLog getGameLog() throws Throwable;

}
