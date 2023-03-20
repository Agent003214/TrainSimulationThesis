package Tiles.Scenery;

import Tiles.Tile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BuildingWhiteMiddleTile extends Tile
{
    public BuildingWhiteMiddleTile()
    {
        filePaths=new String[]{"Tiles/buildingWhiteMiddleTile.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "White building middle tile image not found";
    }
}
