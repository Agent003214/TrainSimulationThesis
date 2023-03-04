package Tiles.Scenery.Wires;

import Tiles.Tile;

public class WirePoleSE extends Tile
{
    public WirePoleSE()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/Wires/wirePoleSE.png"};
    }
    @Override
    protected String errorMessage()
    {
        return "Wire pole south east tile image not found";
    }
}
