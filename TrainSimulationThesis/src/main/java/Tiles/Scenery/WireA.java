package Tiles.Scenery;

import Tiles.Tile;

public class WireA extends Tile
{
    public WireA()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/wireA.png"};
    }
    @Override
    protected String errorMessage()
    {
        return "Wire A tile image not found";
    }
}
