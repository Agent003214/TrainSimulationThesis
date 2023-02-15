package Tiles.Scenery;

import Tiles.Tile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BuildingRedBottomTile extends Tile
{
    public BuildingRedBottomTile()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/buildingRedBottomTile.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "Red building bottom tile image not found";
    }
}
