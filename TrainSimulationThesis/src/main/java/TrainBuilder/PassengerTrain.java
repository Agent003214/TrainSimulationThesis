package TrainBuilder;

import Attachables.Attachable;
import TrainEngines.Electric.V63;
import TrainEngines.Locomotive;

import java.util.ArrayList;
import java.util.Arrays;

public class PassengerTrain
{
    private Locomotive engine;
    ArrayList<Attachable> attachables=new ArrayList<>();
    public PassengerTrain(Locomotive engine, Attachable ... attachables)
    {
        this.engine=engine;
        this.attachables.addAll(Arrays.asList(attachables));

    }

    public Locomotive getEngine()
    {
        return engine;
    }

    public ArrayList<Attachable> getAttachables()
    {
        return attachables;
    }
}
