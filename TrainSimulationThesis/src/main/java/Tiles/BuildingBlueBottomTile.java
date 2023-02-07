package Tiles;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BuildingBlueBottomTile extends Tile
{
    @Override
    public void load()
    {
        try
        {
            File file = new File("./src/main/resources/Tiles/buildingBlueBottomTile.png");
            image = ImageIO.read(file);
        }
        catch (IOException e)
        {
            System.out.println("Blue building bottom tile image not found");
            e.printStackTrace();
        }
    }
}
