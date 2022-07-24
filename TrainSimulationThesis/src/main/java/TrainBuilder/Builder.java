package TrainBuilder;

import Attachables.Attachable;
import TrainEngines.Locomotive;

public interface Builder
{
    void setLoco(Locomotive engine);
    void setCar(Attachable car);
}
