package Tiles.Scenery.Wires;

import Tiles.Tile;

public class WireNS extends Tile
{
    public WireNS()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/Wires/wireNS.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "Wire north south image not found";
    }
}
