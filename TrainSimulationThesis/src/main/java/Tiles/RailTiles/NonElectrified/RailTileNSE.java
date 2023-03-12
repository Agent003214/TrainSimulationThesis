package Tiles.RailTiles.NonElectrified;

import Tiles.RailTiles.RailTile;

public class RailTileNSE extends RailTile
{
    public RailTileNSE()
    {
        filePaths=new String[]{"./TrainSimulationThesis/src/main/resources/Tiles/RailTile/railTileNSE.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "North south east switch rail tile image not found";
    }
}
