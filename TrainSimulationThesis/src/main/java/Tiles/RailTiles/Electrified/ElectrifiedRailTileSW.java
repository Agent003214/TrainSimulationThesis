package Tiles.RailTiles.Electrified;

import Tiles.RailTiles.RailTile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * South-west corner rail tile
 */
public class ElectrifiedRailTileSW extends RailTile
{
    public ElectrifiedRailTileSW()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/railTileSW.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "South-west rail tile image not found";
    }
}
