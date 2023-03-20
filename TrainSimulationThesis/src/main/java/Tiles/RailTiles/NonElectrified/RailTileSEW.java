package Tiles.RailTiles.NonElectrified;

import Tiles.RailTiles.RailTile;

public class RailTileSEW extends RailTile
{
    public RailTileSEW()
    {
        filePaths=new String[]{"Tiles/RailTile/railTileSEW.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "South east west switch rail tile image not found";
    }
}
