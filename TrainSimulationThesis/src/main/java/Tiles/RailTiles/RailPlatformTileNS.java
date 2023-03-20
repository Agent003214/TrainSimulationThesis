package Tiles.RailTiles;

import Tiles.RailTiles.RailTile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class RailPlatformTileNS extends RailTile
{
    public RailPlatformTileNS()
    {
        filePaths=new String[]{"Tiles/RailTile/railPlatformTileNS.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "North-south platform rail tile image not found";
    }
}
