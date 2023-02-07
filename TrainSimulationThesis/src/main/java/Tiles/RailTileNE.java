package Tiles;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * North-East corner rail tile
 */
public class RailTileNE extends RailTile
{
    @Override
    public void load()
    {
        try
        {
            File file = new File("./src/main/resources/Tiles/railTileNE.png");
            image = ImageIO.read(file);
        }
        catch (IOException e)
        {
            System.out.println("North-east rail tile image not found");
            e.printStackTrace();
        }
    }
}
