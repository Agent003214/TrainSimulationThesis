package Tiles.Scenery.RoadTiles;

import Tiles.Tile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class RoadTileNS extends Tile
{
    public RoadTileNS()
    {
        filePaths=new String[]{"Tiles/RoadTile/roadTileNS.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "North south road tile image not found";
    }
}
