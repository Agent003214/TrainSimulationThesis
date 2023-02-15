package Tiles.Scenery;

import Tiles.Tile;

public class WireNW extends Tile
{
    public WireNW()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/wireNW.png"};
    }
    @Override
    protected String errorMessage()
    {
        return "Wire North-west cornet tile image not found";
    }
}
