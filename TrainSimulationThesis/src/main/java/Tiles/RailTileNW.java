package Tiles;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * North-west corner rail tile
 */
public class RailTileNW extends RailTile
{
    @Override
    public void load()
    {
        try
        {
            File file = new File("./src/main/resources/Tiles/railTileNW.png");
            image = ImageIO.read(file);
        }
        catch (IOException e)
        {
            System.out.println("North-west rail tile image not found");
            e.printStackTrace();
        }
    }
}
