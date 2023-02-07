package Tiles;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * South-east corner rail tile
 */
public class RailTileSE extends RailTile
{
    @Override
    public void load()
    {
        try
        {
            File file = new File("./src/main/resources/Tiles/railTileSE.png");
            image = ImageIO.read(file);
        }
        catch (IOException e)
        {
            System.out.println("South-east rail tile image not found");
            e.printStackTrace();
        }
    }
}
