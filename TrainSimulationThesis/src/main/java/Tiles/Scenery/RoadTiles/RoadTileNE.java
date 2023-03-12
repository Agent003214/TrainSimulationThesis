package Tiles.Scenery.RoadTiles;

import Tiles.Tile;

public class RoadTileNE extends Tile
{
    public RoadTileNE()
    {
        filePaths=new String[]{"./TrainSimulationThesis/src/main/resources/Tiles/RoadTile/roadTileNE.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "North east road tile image not found";
    }
}
