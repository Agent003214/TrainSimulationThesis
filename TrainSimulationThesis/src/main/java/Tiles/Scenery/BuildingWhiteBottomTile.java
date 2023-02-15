package Tiles.Scenery;

import Tiles.Tile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BuildingWhiteBottomTile extends Tile
{
    public BuildingWhiteBottomTile()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/buildingWhiteBottomTile.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "White building bottom tile image not found";
    }
}
