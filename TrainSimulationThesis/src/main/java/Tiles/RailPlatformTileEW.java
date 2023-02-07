package Tiles;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class RailPlatformTileEW extends RailTile
{
    @Override
    public void load()
    {
        try
        {
            File file = new File("./src/main/resources/Tiles/railPlatformTileEW.png");
            image = ImageIO.read(file);
        }
        catch (IOException e)
        {
            System.out.println("East-west platform rail tile image not found");
            e.printStackTrace();
        }
    }
}
