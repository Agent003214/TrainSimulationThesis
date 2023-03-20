package Tiles.Scenery.RoadTiles;

import Tiles.Tile;

public class RoadTileSW extends Tile
{
    public RoadTileSW()
    {
        filePaths=new String[]{"Tiles/RoadTile/roadTileSW.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "South west road tile image not found";
    }
}
