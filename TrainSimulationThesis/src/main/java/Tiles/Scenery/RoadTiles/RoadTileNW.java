package Tiles.Scenery.RoadTiles;

import Tiles.Tile;

public class RoadTileNW extends Tile
{
    public RoadTileNW()
    {
        filePaths=new String[]{"Tiles/RoadTile/roadTileNW.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "North west road tile image not found";
    }
}
