package Tiles;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class RailPlatformTileNS extends RailTile
{
    @Override
    public void load()
    {
        try
        {
            File file = new File("./src/main/resources/Tiles/railPlatformTileNS.png");
            image = ImageIO.read(file);
        }
        catch (IOException e)
        {
            System.out.println("North-south platform rail tile image not found");
            e.printStackTrace();
        }
    }
}
