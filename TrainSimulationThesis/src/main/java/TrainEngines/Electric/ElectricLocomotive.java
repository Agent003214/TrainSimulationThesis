package TrainEngines.Electric;

import TrainEngines.Locomotive;

public abstract class ElectricLocomotive extends Locomotive
{
    /**
     * Lokomotív teljesítménye kW-ban.
     * @return
     */
    @Override
    public abstract int getPower();
}
