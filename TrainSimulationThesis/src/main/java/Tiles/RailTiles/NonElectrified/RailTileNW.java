package Tiles.RailTiles.NonElectrified;

import Tiles.RailTiles.RailTile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * North-west corner rail tile
 */
public class RailTileNW extends RailTile
{
    public RailTileNW()
    {
        filePaths=new String[]{"Tiles/RailTile/railTileNW.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "North-west rail tile image not found";
    }
}
