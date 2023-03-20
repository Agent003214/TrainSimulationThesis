package Tiles.Scenery.Wires;

import Tiles.Tile;

public class WirePoleNSW extends Tile
{
    public WirePoleNSW()
    {
        filePaths=new String[]{"Tiles/Wires/wirePoleNSW.png"};
    }
    @Override
    protected String errorMessage()
    {
        return "Wire pole north south west tile image not found";
    }
}
