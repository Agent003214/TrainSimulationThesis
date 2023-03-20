package Tiles.Scenery.RoadTiles;

import Tiles.Tile;

public class RoadTileNSE extends Tile
{
    public RoadTileNSE()
    {
        filePaths=new String[]{"Tiles/RoadTile/roadTileNSE.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "North south east road tile image not found";
    }
}
