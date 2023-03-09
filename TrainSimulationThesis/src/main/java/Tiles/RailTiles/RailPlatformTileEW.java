package Tiles.RailTiles;

import Tiles.RailTiles.RailTile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class RailPlatformTileEW extends RailTile
{
    public RailPlatformTileEW()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/RailTile/railPlatformTileEW.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "East-west platform rail tile image not found";
    }
}
