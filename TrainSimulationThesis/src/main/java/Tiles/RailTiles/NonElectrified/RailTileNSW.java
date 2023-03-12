package Tiles.RailTiles.NonElectrified;

import Tiles.RailTiles.RailTile;

public class RailTileNSW extends RailTile
{
    public RailTileNSW()
    {
        filePaths=new String[]{"./TrainSimulationThesis/src/main/resources/Tiles/RailTile/railTileNSW.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "North south west switch rail tile image not found";
    }
}
