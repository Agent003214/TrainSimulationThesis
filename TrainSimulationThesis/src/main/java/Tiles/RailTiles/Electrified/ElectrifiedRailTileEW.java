package Tiles.RailTiles.Electrified;

import Tiles.RailTiles.RailTile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * East-West straight rail tile
 */
public class ElectrifiedRailTileEW extends RailTile
{
    public ElectrifiedRailTileEW()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/railTileEW.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "East-west rail tile image not found";
    }
}
