package Attachables.CargoWagon;

public class BoxWagon extends Wagon
{
    //https://www.greenbrier-europe.com/products/product/eamnos-72-m3-e04e/
    private int load=0;

    @Override
    public String getName()
    {
        return "Eamnos E04E";
    }

    @Override
    public String getType()
    {
        return "Box wagon";
    }

    @Override
    public int getCapacity()
    {
        return 71000;
    }

    @Override
    public int getMaxSpeed()
    {
        return 100;
    }

    @Override
    public int getGaugeSize()
    {
        return 1425;
    }

    @Override
    public int getLength()
    {
        return 13;
    }

    @Override
    public void load(int num)
    {

    }

    @Override
    public void unload(int num)
    {

    }

    @Override
    public int getLoad()
    {
        return load;
    }
}
