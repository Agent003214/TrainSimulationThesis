package Attachables.Cargo;

public class Coal extends Cargo
{
    //https://www.engineeringtoolbox.com/classification-coal-d_164.html
    @Override
    public String getName()
    {
        return "Coal";
    }

    @Override
    public int getDensity()
    {
        return 860;
    }
}
