package Tiles;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BuildingRedMiddleTile extends Tile
{
    @Override
    public void load()
    {
        try
        {
            File file = new File("./src/main/resources/Tiles/buildingRedMiddleTile.png");
            image = ImageIO.read(file);
        }
        catch (IOException e)
        {
            System.out.println("Red building middle tile image not found");
            e.printStackTrace();
        }
    }
}