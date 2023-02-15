package Tiles.Scenery;

import Tiles.Tile;

public class GrassTile extends Tile
{
    public GrassTile()
    {
        filePaths = new String[]
                {
                        "./src/main/resources/Tiles/grassTile.png",
                        "./src/main/resources/Tiles/grassTile2.png",
                        "./src/main/resources/Tiles/grassTile3.png"
                };

    }

    @Override
    protected String errorMessage()
    {
        return "Grass tile image not found";
    }
}
