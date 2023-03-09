package Tiles.Scenery.RoadTiles;

import Tiles.Tile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class RoadTileEW extends Tile
{
    public RoadTileEW()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/RoadTile/roadTileEW.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "East-west road tile image not found";
    }
}
