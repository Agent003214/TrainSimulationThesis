package Tiles.RailTiles.NonElectrified;

import Tiles.RailTiles.RailTile;

public class RailTileAllWay extends RailTile
{
    public RailTileAllWay()
    {
        filePaths=new String[]{"./TrainSimulationThesis/src/main/resources/Tiles/RailTile/railTile4Way.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "All way switch rail tile image not found";
    }
}
