package Tiles.Scenery.Wires;

import Tiles.Tile;

public class WireEW extends Tile
{
    public WireEW()
    {
        filePaths=new String[]{"Tiles/Wires/wireEW.png"};
    }
    @Override
    protected String errorMessage()
    {
        return "Wire east west tile image not found";
    }
}
