package Tiles.Scenery.Wires;

import Tiles.Tile;

public class WirePoleNSE extends Tile
{
    public WirePoleNSE()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/Wires/wirePoleNSE.png"};
    }
    @Override
    protected String errorMessage()
    {
        return "Wire pole north south east tile image not found";
    }
}