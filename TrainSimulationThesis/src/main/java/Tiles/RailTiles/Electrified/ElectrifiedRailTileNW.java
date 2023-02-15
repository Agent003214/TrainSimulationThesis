package Tiles.RailTiles.Electrified;

import Tiles.RailTiles.RailTile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * North-west corner rail tile
 */
public class ElectrifiedRailTileNW extends RailTile
{
    public ElectrifiedRailTileNW()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/railTileNW.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "North-west rail tile image not found";
    }
}
