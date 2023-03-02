package Attachables.Cargo;

public class Passenger extends Cargo
{
    @Override
    public String getName()
    {
        return "Passenger";
    }

    @Override
    public int getDensity()
    {
        return 0;
    }
}
