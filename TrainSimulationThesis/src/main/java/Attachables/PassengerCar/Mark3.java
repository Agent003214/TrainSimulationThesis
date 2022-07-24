package Attachables.PassengerCar;

import Attachables.Attachable;
import Attachables.AttachableClass;

public class Mark3 extends AttachableClass
{

    /**
     * Number of passenger
     * @return
     */
    @Override
    public int getCapacity()
    {
        return 74;
    }

    @Override
    public int maxAllowedSpeed()
    {
        return 200;
    }

    @Override
    public int gaugeSize()
    {
        return 1435;
    }
}
