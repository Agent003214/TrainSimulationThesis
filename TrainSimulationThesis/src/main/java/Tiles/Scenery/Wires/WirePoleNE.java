package Tiles.Scenery.Wires;

import Tiles.Tile;

public class WirePoleNE extends Tile
{
    public WirePoleNE()
    {
        filePaths=new String[]{"Tiles/Wires/wirePoleNE.png"};
    }
    @Override
    protected String errorMessage()
    {
        return "Wire pole north east tile image not found";
    }
}
