package TrainEngines.Diesel;

import TrainEngines.Locomotive;

public abstract class DieselLocomotive implements Locomotive
{
    /**
     * Lokomotív teljesítménye lóerőben.
     * @return
     */
    @Override
    public abstract int getPower();
}
