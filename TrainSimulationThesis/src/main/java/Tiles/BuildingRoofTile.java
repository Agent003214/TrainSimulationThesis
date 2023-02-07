package Tiles;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BuildingRoofTile extends Tile
{
    @Override
    public void load()
    {
        try
        {
            File file = new File("./src/main/resources/Tiles/buildingRoofTile.png");
            image = ImageIO.read(file);
        }
        catch (IOException e)
        {
            System.out.println("Building roof tile image not found");
            e.printStackTrace();
        }
    }
}
