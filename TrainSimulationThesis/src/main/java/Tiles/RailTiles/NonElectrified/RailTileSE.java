package Tiles.RailTiles.NonElectrified;

import Tiles.RailTiles.RailTile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * South-east corner rail tile
 */
public class RailTileSE extends RailTile
{
    public RailTileSE()
    {
        filePaths=new String[]{"./TrainSimulationThesis/src/main/resources/Tiles/RailTile/railTileSE.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "South-east rail tile image not found";
    }
}
