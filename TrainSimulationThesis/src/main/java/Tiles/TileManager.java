package Tiles;

import GUI.MapPanel;
import Tiles.RailTiles.NonElectrified.*;
import Tiles.RailTiles.RailPlatformTileEW;
import Tiles.Scenery.*;
import Tiles.Scenery.Wires.*;

import java.awt.*;

public class TileManager
{
    private MapPanel mapPanel;
    private boolean background;
    private Tile[][] map;

    /*private Tile[][] map = new Tile[][]
            {
                    {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                    {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                    {new GrassTile(),new RailTileSE(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileSW(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                    {new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new WireBNS(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                    {new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new WireANS(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                    {new GrassTile(),new RailTileNS(),new WireA(),new WireB(),new WireNW(),new RailTileNS(),new GrassTile(),new GrassTile(),new BuildingRoofTile(),new BuildingRoofTile()},
                    {new GrassTile(),new RailTileNE(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileNW(),new GrassTile(),new BuildingRoofTile(),new BuildingBlueMiddleTile(),new BuildingWhiteMiddleTile()},
                    {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new BuildingRedBottomTile(),new BuildingBlueBottomTile(),new BuildingWhiteBottomTile()},
                    {new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new GrassTile(),new RailPlatformTileEW(),new RailPlatformTileNS(),new RoadTileEW(),new RoadTileEW(),new RoadTileEW()},
                    {new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()}
            };*/

    public TileManager(MapPanel map,Boolean background)
    {
        mapPanel = map;
        if (background)
        {
            setBackground();
        }
        else
        {
            setOverlay();
        }
        initTileImages();
    }

    private void setBackground()
    {
        map = new Tile[][]
                {
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new RailTileSE(),new RailTileEW(),new RailPlatformTileEW(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new RailPlatformTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailPlatformTileEW(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()}
                };
    }

    private void setOverlay()
    {
        map = new Tile[][]
                {
                        {null,null,new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {null,null,new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {null,null,new GrassTile(),new WirePoleSE(),new WireEW(),new WirePoleEW(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {null,null,new GrassTile(),new WireNS(),null,null,new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {null,new WirePoleEW(),new WireEW(),new WirePoleNW(),new WireEW(),new WirePoleEW(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {null,null,null,null,null,null,null,new GrassTile(),new GrassTile(),new GrassTile()},
                        {null,null,new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {null,null,new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {null,null,new WaterTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {null,null,new WaterTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()}
                };
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
                try
                {
                    tile.load();
                }
                catch (NullPointerException e)
                {

                }
            }
        }
    }

    public Tile getMapTiles(int col, int row)
    {
        return map[row][col];
    }

    public void draw(Graphics2D g2D)
    {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while (col < mapPanel.getMapTileColumn() && row < mapPanel.getMapTileRow())
        {
            Tile tile = map[row][col];
            try
            {
                g2D.drawImage(tile.image, x, y, mapPanel.getScaledTileSize(), mapPanel.getScaledTileSize(), null);
            }
            catch (NullPointerException e)
            {

            }
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
