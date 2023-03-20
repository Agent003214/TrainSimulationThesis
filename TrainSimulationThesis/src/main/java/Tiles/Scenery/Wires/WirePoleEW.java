package Tiles.Scenery.Wires;

import Tiles.Tile;

public class WirePoleEW extends Tile
{
    public WirePoleEW()
    {
        filePaths=new String[]{"Tiles/Wires/wirePoleEW.png"};
    }
    @Override
    protected String errorMessage()
    {
        return "Wire pole east west tile image not found";
    }
}
