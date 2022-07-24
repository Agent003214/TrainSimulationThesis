package TrainBuilder;

import Attachables.Attachable;
import TrainEngines.Locomotive;

public class PassengerTrainBuilder implements Builder
{
    private Locomotive locomotive;
    private Attachable attachable;

    @Override
    public void setLoco(Locomotive engine)
    {
        this.locomotive = locomotive;
    }

    @Override
    public void setCar(Attachable car)
    {
        this.attachable = attachable;
    }

    public PassengerTrain getResult()
    {
        return new PassengerTrain(locomotive,attachable,attachable);
    }
}
