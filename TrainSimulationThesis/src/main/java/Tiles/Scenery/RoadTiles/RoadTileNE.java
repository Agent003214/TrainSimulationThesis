package Tiles.Scenery.RoadTiles;

import Tiles.Tile;

public class RoadTileNE extends Tile
{
    public RoadTileNE()
    {
        filePaths=new String[]{"Tiles/RoadTile/roadTileNE.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "North east road tile image not found";
    }
}
