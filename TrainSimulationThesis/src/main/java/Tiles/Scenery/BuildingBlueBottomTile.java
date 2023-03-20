package Tiles.Scenery;

import Tiles.Tile;

public class BuildingBlueBottomTile extends Tile
{
    public BuildingBlueBottomTile()
    {
        filePaths=new String[]{"Tiles/buildingBlueBottomTile.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "Blue building bottom tile image not found";
    }
}
