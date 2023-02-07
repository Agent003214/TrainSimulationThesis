package Tiles;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class RoadTileNS extends Tile
{
    @Override
    public void load()
    {
        try
        {
            File file = new File("./src/main/resources/Tiles/railTileEW.png");
            image = ImageIO.read(file);
        }
        catch (IOException e)
        {
            System.out.println("East-west rail tile image not found");
            e.printStackTrace();
        }
    }
}
