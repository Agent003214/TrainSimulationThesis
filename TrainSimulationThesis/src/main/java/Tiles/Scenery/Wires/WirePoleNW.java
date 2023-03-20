package Tiles.Scenery.Wires;

import Tiles.Tile;

public class WirePoleNW extends Tile
{
    public WirePoleNW()
    {
        filePaths=new String[]{"Tiles/Wires/wirePoleNW.png"};
    }
    @Override
    protected String errorMessage()
    {
        return "Wire pole north west tile image not found";
    }
}
