package Tiles.Scenery.RoadTiles;

import Tiles.Tile;

public class RoadTileNSW extends Tile
{
    public RoadTileNSW()
    {
        filePaths=new String[]{"./TrainSimulationThesis/src/main/resources/Tiles/RoadTile/roadTileNSW.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "North south west road tile image not found";
    }
}
