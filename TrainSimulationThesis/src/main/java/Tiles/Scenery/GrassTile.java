package Tiles.Scenery;

import Tiles.Tile;

public class GrassTile extends Tile
{
    public GrassTile()
    {
        filePaths = new String[]
                {
                        "Tiles/grassTile.png",
                        "Tiles/grassTile2.png",
                        "Tiles/grassTile3.png"
                };

    }

    @Override
    protected String errorMessage()
    {
        return "Grass tile image not found";
    }
}
