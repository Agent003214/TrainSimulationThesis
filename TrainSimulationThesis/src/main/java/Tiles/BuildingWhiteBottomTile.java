package Tiles;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BuildingWhiteBottomTile extends Tile
{
    @Override
    public void load()
    {
        try
        {
            File file = new File("./src/main/resources/Tiles/buildingWhiteBottomTile.png");
            image = ImageIO.read(file);
        }
        catch (IOException e)
        {
            System.out.println("White building bottom tile image not found");
            e.printStackTrace();
        }
    }
}
