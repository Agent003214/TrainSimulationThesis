package Tiles.Scenery.Wires;

import Tiles.Tile;

public class WireEW extends Tile
{
    public WireEW()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/Wires/wireEW.png"};
    }
    @Override
    protected String errorMessage()
    {
        return "Wire east west tile image not found";
    }
}
