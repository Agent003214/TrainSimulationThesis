package Factories;

import AlternateComponents.NewCars.Cars;
import Exceptions.PassengerOverloadException;

import java.util.ArrayList;
import java.util.Arrays;

public class CompoundTrain extends BaseTrain
{
    protected ArrayList<Train> trains =new ArrayList<>();
    private int passengerCount=0;
    public void add(Train component)
    {
        trains.add(component);
    }
    public void add(Train ... component)
    {
        trains.addAll(Arrays.asList(component));
    }

    public int getNumbersOfCars()
    {
        int szamlalo=0;
        for (int i = 0; i < trains.size(); i++)
        {
            if (trains.get(i) instanceof Cars)
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
            if (trains.get(i) instanceof Cars)
            {
                szamlalo=szamlalo+((Cars) trains.get(i)).getCapacity();
            }
        }
        return szamlalo;
    }

    public int getPassengerCount()
    {
        return passengerCount;
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

    @Override
    public String toString()
    {
        return "CompoundTrain{" +
                "valamik=" + trains +
                '}';
    }
}
