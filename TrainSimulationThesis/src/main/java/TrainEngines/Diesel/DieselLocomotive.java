package TrainEngines.Diesel;

import TrainEngines.Locomotive;

public abstract class DieselLocomotive extends Locomotive
{
    /**
     * Lokomotív teljesítménye lóerőben.
     * @return
     */
    @Override
    public abstract int getPower();
}
