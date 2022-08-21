package TrainEngines.Diesel;

import Factories.BaseTrain;
import TrainEngines.Locomotive;

public abstract class DieselLocomotive extends BaseTrain implements Locomotive
{
    /**
     * Lokomotív teljesítménye lóerőben.
     * @return
     */
    public abstract int getPower();
}
