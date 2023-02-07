package Tiles;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class WaterTile extends Tile
{
    String[] filePaths = new String[]
            {
                    "./src/main/resources/Tiles/waterTile.png",
                    "./src/main/resources/Tiles/waterTile2.png"
            };
    @Override
    public void load()
    {
        try
        {
            Random rnd = new Random();
            File file = new File(filePaths[rnd.nextInt(filePaths.length)]);
            image = ImageIO.read(file);

        }
        catch (IOException e)
        {
            System.out.println("Water tile image not found");
            e.printStackTrace();
        }
    }
}
