package Tiles.Scenery;

import Tiles.Tile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BuildingRoofTile extends Tile
{
    public BuildingRoofTile()
    {
        filePaths=new String[]{"Tiles/buildingRoofTile.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "Building roof tile image not found";
    }
}
