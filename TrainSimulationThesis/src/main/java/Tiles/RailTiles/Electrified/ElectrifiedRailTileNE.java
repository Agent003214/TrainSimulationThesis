package Tiles.RailTiles.Electrified;

import Tiles.RailTiles.RailTile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * North-East corner rail tile
 */
public class ElectrifiedRailTileNE extends RailTile
{
    public ElectrifiedRailTileNE()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/railTileNE.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "North-east rail tile image not found";
    }
}
