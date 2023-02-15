package Tiles.Scenery;

import Tiles.Tile;

public class WireANS extends Tile
{
    public WireANS()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/wireANS.png"};
    }
    @Override
    protected String errorMessage()
    {
        return "Wire A North-south tile image not found";
    }
}
