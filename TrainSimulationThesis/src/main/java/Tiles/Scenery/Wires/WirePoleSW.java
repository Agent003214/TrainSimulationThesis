package Tiles.Scenery.Wires;

import Tiles.Tile;

public class WirePoleSW extends Tile
{
    public WirePoleSW()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/Wires/wirePoleSW.png"};
    }
    @Override
    protected String errorMessage()
    {
        return "Wire pole south west tile image not found";
    }
}
