package Tiles.RailTiles.NonElectrified;

import Tiles.RailTiles.RailTile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * North-East corner rail tile
 */
public class RailTileNE extends RailTile
{
    public RailTileNE()
    {
        filePaths=new String[]{"./TrainSimulationThesis/src/main/resources/Tiles/RailTile/railTileNE.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "North-east rail tile image not found";
    }
}
