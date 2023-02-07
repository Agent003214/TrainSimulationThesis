package Tiles;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * North-south straight rail tile
 */
public class RailTileNS extends RailTile
{
    @Override
    public void load()
    {
        try
        {
            File file = new File("./src/main/resources/Tiles/railTileNS.png");
            image = ImageIO.read(file);
        }
        catch (IOException e)
        {
            System.out.println("Nort-south rail tile image not found");
            e.printStackTrace();
        }
    }
}
