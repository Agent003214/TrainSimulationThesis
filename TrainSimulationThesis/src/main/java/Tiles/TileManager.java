package Tiles;

import GUI.MapPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TileManager
{
    MapPanel mapPanel;
    //Tile[] tiles;
    //private int[][] mapTiles;
    private Tile[][] map = new Tile[][]
            {
                    {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                    {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                    {new GrassTile(),new RailTileSE(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileSW(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                    {new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                    {new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                    {new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new BuildingRoofTile(),new BuildingRoofTile()},
                    {new GrassTile(),new RailTileNE(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileNW(),new GrassTile(),new BuildingRoofTile(),new BuildingBlueMiddleBottomTile(),new BuildingWhiteMiddleTile()},
                    {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new BuildingRedBottomTile(),new BuildingBlueBottomTile(),new BuildingWhiteBottomTile()},
                    {new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new GrassTile(),new RailPlatformTileEW(),new RailPlatformTileNS(),new RoadTileEW(),new RoadTileEW(),new RoadTileEW()},
                    {new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()}
            };

    public TileManager(MapPanel map)
    {
        mapPanel = map;
        initTileImages();
    }

    /**
     * Create all tiles
     */
    private void initTileImages()
    {
        for (Tile[] tiles : map)
        {
            for (Tile tile : tiles)
            {
                tile.load();
            }
        }
    }

    /*private void loadMap()
    {
        ArrayList<String> fileString = new ArrayList<>();
        File file = new File("./src/main/java/GUI/map.txt");
        try
        {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
            {
                fileString.add(sc.nextLine());
            }
            int col = 0;
            for (int i = 0; i < fileString.size(); i++)
            {
                String[] splitFile = fileString.get(i).split(" ");
                while (col < mapPanel.getMapTileColumn())
                {
                    mapTiles[i][col] = Integer.parseInt(splitFile[col]);
                    col++;
                }
                col = 0;
            }
        } catch (FileNotFoundException e)
        {

        }
        for (int i = 0; i < fileString.size(); i++)
        {
            System.out.println(fileString.get(i));
        }
    }*/

    public Tile getMapTiles(int col, int row)
    {
        return map[row][col];
    }

    public void draw(Graphics2D g2D)
    {
        //g2D.drawImage(tiles[1].image,0,0,mapPanel.getScaledTileSize(),mapPanel.getScaledTileSize(),null);
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while (col < mapPanel.getMapTileColumn() && row < mapPanel.getMapTileRow())
        {
            Tile tile = map[row][col];
            g2D.drawImage(tile.image, x, y, mapPanel.getScaledTileSize(), mapPanel.getScaledTileSize(), null);
            col++;
            x += mapPanel.getScaledTileSize();
            if (col == mapPanel.getMapTileColumn())
            {
                col = 0;
                x = 0;
                row++;
                y += mapPanel.getScaledTileSize();
            }

        }
    }
}
