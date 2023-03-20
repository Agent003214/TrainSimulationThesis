package Tiles.RailTiles.NonElectrified;

import Tiles.RailTiles.RailTile;

public class RailTileNEW extends RailTile
{
    public RailTileNEW()
    {
        filePaths=new String[]{"Tiles/RailTile/railTileNEW.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "North east west switch rail tile image not found";
    }
}
