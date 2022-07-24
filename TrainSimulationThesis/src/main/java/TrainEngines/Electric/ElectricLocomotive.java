package TrainEngines.Electric;

import TrainEngines.Locomotive;

public abstract class ElectricLocomotive implements Locomotive
{
    /**
     * Lokomotív teljesítménye kW-ban.
     * @return
     */
    @Override
    public abstract int getPower();
}
