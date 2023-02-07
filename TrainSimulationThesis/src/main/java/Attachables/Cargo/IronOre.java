package Attachables.Cargo;

public class IronOre extends Cargo
{
    //https://amesweb.info/Materials/Density-of-Metals.aspx
    @Override
    public String getName()
    {
        return "Iron ore";
    }

    @Override
    public int getDensity()
    {
        return 5206;
    }
}
