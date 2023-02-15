package Tiles.Scenery;

import Tiles.Tile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BuildingRedMiddleTile extends Tile
{
    public BuildingRedMiddleTile()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/buildingRedMiddleTile.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "Red building middle tile image not found";
    }
}
