package TrainBuilder;

import Attachables.Attachable;
import TrainEngines.Locomotive;

import java.util.ArrayList;
import java.util.Arrays;

public class CargoTrain
{
    private Locomotive engine;
    ArrayList<Attachable> attachables=new ArrayList<>();
    public CargoTrain(Locomotive engine, Attachable ... attachables)
    {
        this.engine=engine;
        this.attachables.addAll(Arrays.asList(attachables));

    }
}
