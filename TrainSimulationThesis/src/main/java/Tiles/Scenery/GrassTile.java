package Tiles.Scenery;

import Tiles.Tile;

public class GrassTile extends Tile
{
    public GrassTile()
    {
        filePaths = new String[]
                {
                        "./TrainSimulationThesis/src/main/resources/Tiles/grassTile.png",
                        "./TrainSimulationThesis/src/main/resources/Tiles/grassTile2.png",
                        "./TrainSimulationThesis/src/main/resources/Tiles/grassTile3.png"
                };

    }

    @Override
    protected String errorMessage()
    {
        return "Grass tile image not found";
    }
}
