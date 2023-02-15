package Tiles.RailTiles.NonElectrified;

import Tiles.RailTiles.RailTile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * North-south straight rail tile
 */
public class RailTileNS extends RailTile
{
    public RailTileNS()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/railTileNS.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "North-south rail tile image not found";
    }
}
