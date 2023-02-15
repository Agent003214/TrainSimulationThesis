package Tiles.Scenery;

import Tiles.Tile;

public class WireB extends Tile
{
    public WireB()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/wireB.png"};
    }
    @Override
    protected String errorMessage()
    {
        return "Wire B tile image not found";
    }
}
