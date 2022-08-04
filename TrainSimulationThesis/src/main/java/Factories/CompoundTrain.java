package Factories;

import Attachables.Attachable;
import Attachables.PassengerCar.Car;
import Exceptions.NoEngineException;
import Exceptions.PassengerNegativeException;
import Exceptions.PassengerOverloadException;
import TrainEngines.Locomotive;

import java.util.ArrayList;
import java.util.Arrays;

public class CompoundTrain extends BaseTrain
{
    protected ArrayList<Train> trains =new ArrayList<>();
    private int passengerCount;
    private final int maxlength=750;

    public void add(Train component)
    {
        try
        {
            checkEngine(component);
            trains.add(component);
        }
        catch (NoEngineException e)
        {
            System.out.println("The train requires at least one locomotive");
        }
    }
    public void add(Train ... component)
    {
        try
        {
            checkEngine(component);
            trains.addAll(Arrays.asList(component));
        }
        catch (NoEngineException e)
        {
            System.out.println("The train requires at least one locomotive");
        }
    }

    /**
     * Check, if there is a locomotive in the train. If not, throws an exception.
     * @param component
     *
     */
    private void checkEngine(Train ... component) throws NoEngineException
    {
        int counter=0;
        for (int i = 0; i < component.length; i++)
        {
            if (component[i] instanceof Locomotive)
            {
                counter++;
            }
        }
        if (counter==0)
        {
            throw new NoEngineException();
        }
    }

    public int getNumbersOfCars()
    {
        int szamlalo=0;
        for (int i = 0; i < trains.size(); i++)
        {
            if (trains.get(i) instanceof Attachable)
            {
                szamlalo++;
            }
        }
        return szamlalo;
    }

    public int getPassengerCapacityCount()
    {
        int szamlalo=0;
        for (int i = 0; i < trains.size(); i++)
        {
            if (trains.get(i) instanceof Car)
            {
                szamlalo=szamlalo+((Car) trains.get(i)).getCapacity();
            }
        }
        return szamlalo;
    }

    public int getPassengerCount()
    {
        return passengerCount;
    }

    public void altLoad(int i,int num)
    {
        if (trains.get(i) instanceof Attachable)
        {
            ((Attachable) trains.get(i)).load(num);
        }
    }
    public int getLoad(int i)
    {
        if (trains.get(i) instanceof Attachable)
        {
            return ((Attachable) trains.get(i)).getLoad();
        }
        return 0;
    }

    public void loadPassengers(int passCount)
    {
        if (passengerCount+passCount<getPassengerCapacityCount())
        {
            passengerCount+=passCount;
        }
        else
        {
            throw new PassengerOverloadException();
        }
    }

    /**
     * Unload the passenger from the train.
     * @param passCount The number of passengers to be unloaded.
     * @throws PassengerNegativeException If the passenger count would be a negative number.
     */
    public void unloadPassengers(int passCount) throws PassengerNegativeException
    {
        if (passengerCount-passCount>0)
        {
            passengerCount=passengerCount-passCount;
        }
        else
        {
            throw new PassengerNegativeException();
        }
    }

    @Override
    public int getLength()
    {
        return super.getLength();
    }

    @Override
    public String toString()
    {
        return "CompoundTrain{" +
                "Train=" + trains +
                '}';
    }
}
