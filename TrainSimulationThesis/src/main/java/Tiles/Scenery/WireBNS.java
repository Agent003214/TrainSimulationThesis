package Tiles.Scenery;

import Tiles.Tile;

public class WireBNS extends Tile
{
    public WireBNS()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/wireBNS.png"};
    }
    @Override
    protected String errorMessage()
    {
        return "Wire B North-south tile image not found";
    }
}
