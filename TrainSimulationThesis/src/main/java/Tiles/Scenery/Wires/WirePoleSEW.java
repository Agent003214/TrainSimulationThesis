package Tiles.Scenery.Wires;

import Tiles.Tile;

public class WirePoleSEW extends Tile
{
    public WirePoleSEW()
    {
        filePaths=new String[]{"Tiles/Wires/wirePoleSEW.png"};
    }
    @Override
    protected String errorMessage()
    {
        return "Wire pole south east west tile image not found";
    }
}
