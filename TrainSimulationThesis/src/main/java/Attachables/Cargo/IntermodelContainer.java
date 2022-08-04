package Attachables.Cargo;


public class IntermodelContainer extends Cargo
{
    /**
     * Returns the capacity in kilograms
     * @return
     */
    @Override
    public int getCapacity()
    {
        return 20000;
    }

    @Override
    public void load(int num)
    {

    }

    @Override
    public int getLoad()
    {
        return 0;
    }
}
