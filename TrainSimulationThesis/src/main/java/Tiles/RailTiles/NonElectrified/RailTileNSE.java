package Tiles.RailTiles.NonElectrified;

import Tiles.RailTiles.RailTile;

public class RailTileNSE extends RailTile
{
    public RailTileNSE()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/railTileNSE.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "North south east switch rail tile image not found";
    }
}
