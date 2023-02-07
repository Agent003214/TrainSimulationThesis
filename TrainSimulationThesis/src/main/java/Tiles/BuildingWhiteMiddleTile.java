package Tiles;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BuildingWhiteMiddleTile extends Tile
{
    @Override
    public void load()
    {
        try
        {
            File file = new File("./src/main/resources/Tiles/buildingWhiteMiddleTile.png");
            image = ImageIO.read(file);
        }
        catch (IOException e)
        {
            System.out.println("White building middle tile image not found");
            e.printStackTrace();
        }
    }
}
