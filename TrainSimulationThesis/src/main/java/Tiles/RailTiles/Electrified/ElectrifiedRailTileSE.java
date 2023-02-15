package Tiles.RailTiles.Electrified;

import Tiles.RailTiles.RailTile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * South-east corner rail tile
 */
public class ElectrifiedRailTileSE extends RailTile
{
    public ElectrifiedRailTileSE()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/railTileSE.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "South-east rail tile image not found";
    }
}
