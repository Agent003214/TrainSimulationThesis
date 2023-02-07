package Tiles;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class RoadTileEW extends Tile
{
    @Override
    public void load()
    {
        try
        {
            File file = new File("./src/main/resources/Tiles/roadTileEW.png");
            image = ImageIO.read(file);
        }
        catch (IOException e)
        {
            System.out.println("East-west road tile image not found");
            e.printStackTrace();
        }
    }
}
