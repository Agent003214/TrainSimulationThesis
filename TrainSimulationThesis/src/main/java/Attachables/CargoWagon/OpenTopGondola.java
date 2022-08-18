package Attachables.CargoWagon;

public class OpenTopGondola extends Wagon
{
    //https://www.gbrx.com/wp-content/uploads/2021/06/1800-gondola.pdf
    private int load;

    @Override
    public String getName()
    {
        return "1800 Gondola open top wagon";
    }

    @Override
    public int getCapacity()
    {
        return 106000;
    }

    @Override
    public int maxAllowedSpeed()
    {
        return 0;
    }

    @Override
    public int getGaugeSize()
    {
        return 1425;
    }

    @Override
    public int getLength()
    {
        return 10;
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
