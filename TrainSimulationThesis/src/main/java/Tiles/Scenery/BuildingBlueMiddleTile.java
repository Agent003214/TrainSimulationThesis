package Tiles.Scenery;

import Tiles.Tile;

public class BuildingBlueMiddleTile extends Tile
{
    public BuildingBlueMiddleTile()
    {
        filePaths=new String[]{"./TrainSimulationThesis/src/main/resources/Tiles/buildingBlueMiddleTile.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "Blue building bottom tile not found";
    }
}
