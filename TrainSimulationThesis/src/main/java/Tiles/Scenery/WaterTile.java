package Tiles.Scenery;

import Tiles.Tile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class WaterTile extends Tile
{
    public WaterTile()
    {
        filePaths = new String[]
                {
                        "./TrainSimulationThesis/src/main/resources/Tiles/waterTile.png",
                        "./TrainSimulationThesis/src/main/resources/Tiles/waterTile2.png"
                };
    }

    @Override
    protected String errorMessage()
    {
        return "Water tile image not found";
    }
}
