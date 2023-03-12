package Tiles.Scenery.RoadTiles;

import Tiles.Tile;

public class RoadTileSE extends Tile
{
    public RoadTileSE()
    {
        filePaths=new String[]{"./TrainSimulationThesis/src/main/resources/Tiles/RoadTile/roadTileSE.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "South east road tile image not found";
    }
}
