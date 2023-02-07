package Tiles;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * South-west corner rail tile
 */
public class RailTileSW extends RailTile
{
    @Override
    public void load()
    {
        try
        {
            File file = new File("./src/main/resources/Tiles/railTileSW.png");
            image = ImageIO.read(file);
        }
        catch (IOException e)
        {
            System.out.println("South-west rail tile image not found");
            e.printStackTrace();
        }
    }
}
