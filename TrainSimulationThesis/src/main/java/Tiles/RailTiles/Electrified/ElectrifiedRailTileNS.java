package Tiles.RailTiles.Electrified;

import Tiles.RailTiles.RailTile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * North-south straight rail tile
 */
public class ElectrifiedRailTileNS extends RailTile
{
    public ElectrifiedRailTileNS()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/railTileNS.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "Nort-south rail tile image not found";
    }
}
