package Tiles;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BuildingBlueMiddleBottomTile extends Tile
{
    @Override
    public void load()
    {
        try
        {
            File file = new File("./src/main/resources/Tiles/buildingBlueMiddleTile.png");
            image = ImageIO.read(file);
        }
        catch (IOException e)
        {
            System.out.println("Blue building middle tile image not found");
            e.printStackTrace();
        }
    }
}
