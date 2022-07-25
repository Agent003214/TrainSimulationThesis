package Factories;

import java.util.ArrayList;
import java.util.Arrays;

public class CompoundTrain extends BaseTrain
{
    protected ArrayList<Train> valamik=new ArrayList<>();
    public void add(Train component)
    {
        valamik.add(component);
    }
    public void add(Train ... component)
    {
        valamik.addAll(Arrays.asList(component));
    }

    @Override
    public String toString()
    {
        return "CompoundTrain{" +
                "valamik=" + valamik +
                '}';
    }
}
