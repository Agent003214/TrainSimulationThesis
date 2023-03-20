package Tiles.RailTiles.NonElectrified;

import Tiles.RailTiles.RailTile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * East-West straight rail tile
 */
public class RailTileEW extends RailTile
{
    public RailTileEW()
    {
        filePaths=new String[]{"Tiles/RailTile/railTileEW.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "East-west rail tile image not found";
    }
}
