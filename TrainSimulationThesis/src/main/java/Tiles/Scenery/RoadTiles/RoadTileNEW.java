package Tiles.Scenery.RoadTiles;

import Tiles.Tile;

public class RoadTileNEW extends Tile
{
    public RoadTileNEW()
    {
        filePaths=new String[]{"Tiles/RoadTile/roadTileNEW.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "North east west road tile image not found";
    }
}
