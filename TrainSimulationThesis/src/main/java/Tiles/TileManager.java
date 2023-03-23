package Tiles;

import GUI.MapPanel;
import Tiles.RailTiles.NonElectrified.*;
import Tiles.RailTiles.RailPlatformTileEW;
import Tiles.RailTiles.RailPlatformTileNS;
import Tiles.Scenery.*;
import Tiles.Scenery.RoadTiles.*;
import Tiles.Scenery.Wires.*;

import java.awt.*;

public class TileManager
{
    private MapPanel mapPanel;
    private Tile[][] map;

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
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new BuildingRoofTile(),new GrassTile(),new BuildingRoofTile(),new BuildingRoofTile(),new GrassTile(),new BuildingRoofTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new BuildingBlueMiddleTile(),new BuildingRoofTile(),new BuildingRedMiddleTile(),new BuildingWhiteMiddleTile(),new BuildingRoofTile(),new BuildingBlueMiddleTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileSE(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileSW(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new BuildingBlueBottomTile(),new BuildingRedBottomTile(),new BuildingRedBottomTile(),new BuildingWhiteBottomTile(),new BuildingRedBottomTile(),new BuildingBlueBottomTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new BuildingRoofTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RoadTileEW(),new RoadTileEW(),new RoadTileEW(),new RoadTileEW(),new RoadTileEW(),new RoadTileEW(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new BuildingRoofTile(),new BuildingRoofTile(),new BuildingWhiteMiddleTile(),new BuildingRoofTile(),new RoadTileSE(),new RoadTileEW(),new RailPlatformTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new BuildingRedBottomTile(),new BuildingBlueBottomTile(),new BuildingWhiteBottomTile(),new BuildingBlueBottomTile(),new RoadTileNS(),new BuildingRoofTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new RoadTileSE(),new RoadTileEW(),new RoadTileEW(),new RoadTileEW(),new RoadTileNSW(),new BuildingBlueBottomTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNSE(),new RailTileEW(),new RailTileEW(),new RailPlatformTileEW(),new GrassTile(),new GrassTile(),new BuildingRoofTile(),new RoadTileNSE(),new RoadTileEW(),new RailPlatformTileEW(),new RailTileEW(),new RailTileSW(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new BuildingRedBottomTile(),new RoadTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailPlatformTileNS(),new RoadTileEW(),new RoadTileNW(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new RailTileNS(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new RailTileNS(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile(),new WaterTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new BuildingRoofTile(),new BuildingRoofTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileSE(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileNEW(),new RailTileEW(),new RailTileEW(),new RailTileSEW(),new RailTileEW(),new RailTileNEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileSEW(),new RailTileNW(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new BuildingWhiteBottomTile(),new BuildingRedBottomTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RoadTileSE(),new RoadTileEW(),new RailPlatformTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileAllWay(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileSW(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new BuildingRoofTile(),new BuildingRoofTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new BuildingRoofTile(),new RoadTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new BuildingWhiteBottomTile(),new BuildingRedBottomTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new BuildingBlueBottomTile(),new RoadTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new RailTileNSE(),new RailTileEW(),new RailTileEW(),new RailPlatformTileEW(),new RoadTileEW(),new RoadTileEW(),new RoadTileSW(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RoadTileNE(),new RoadTileEW(),new RailPlatformTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileNW(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new BuildingRoofTile(),new BuildingRoofTile(),new RoadTileNS(),new BuildingRoofTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new BuildingRedBottomTile(),new BuildingBlueBottomTile(),new RoadTileNS(),new BuildingWhiteMiddleTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new BuildingRoofTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNE(),new RailTileEW(),new RailTileEW(),new RailTileAllWay(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileNEW(),new RailTileEW(),new RailTileEW(),new RailPlatformTileEW(),new RoadTileEW(),new RoadTileEW(),new RoadTileNW(),new BuildingWhiteBottomTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new BuildingBlueBottomTile(),new BuildingRoofTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new BuildingRoofTile(),new RoadTileNS(),new BuildingRedMiddleTile(),new GrassTile(),new RailTileSE(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileNSW(),new GrassTile(),new GrassTile(),new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new BuildingWhiteBottomTile(),new RoadTileNS(),new BuildingRedBottomTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RoadTileEW(),new RoadTileNEW(),new RoadTileEW(),new RoadTileEW(),new RailPlatformTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()},
                        {new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new RailPlatformTileNS(),new GrassTile(),new GrassTile(),new GrassTile(),new WaterTile(),new WaterTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile(),new GrassTile()}
                };
    }

    private void setOverlay()
    {
        map = new Tile[][]
                {
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WirePoleSE(),new WireEW(),new WirePoleEW(),new WireEW(),new WirePoleEW(),new WireEW(),new WirePoleEW(),new WireEW(),new WirePoleEW(),new WirePoleSW(),null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WireNS(),null,null,null,null,null,null,null,null,new WireNS(),null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WirePoleNS(),null,null,null,null,null,null,null,null,new WirePoleNS(),null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WireNS(),null,null,null,null,null,null,null,null,new WirePoleNS(),null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WirePoleNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WirePoleNSE(),new WireEW(),new WirePoleEW(),new WirePoleEWend(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WireNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WirePoleNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WireNS(),null,null,null,null,new WirePoleNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WirePoleNS(),null,null,null,null,new WireNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WirePoleSE(),new WireEW(),new WirePoleEW(),new WireEW(),new WirePoleNEW(),new WireEW(),new WirePoleEW(),new WirePoleSEW(),new WirePoleEW(),new WirePoleNW(),null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WireNS(),null,null,null,null,null,null,new WireNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,new WirePoleEW(),new WireEW(),new WirePoleEW(),new WireEW(),new WirePoleEW(),new WireEW(),new WirePoleNSW(),null,null,null,null,null,null,new WirePoleNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WireNS(),null,null,null,null,null,null,new WireNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WirePoleNS(),null,null,null,null,null,null,new WirePoleNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,new WirePoleEW(),new WireEW(),new WirePoleEW(),new WireEW(),new WirePoleEW(),new WireEW(),new WirePoleNW(),null,null,null,null,null,null,new WireNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WirePoleNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WirePoleNSE(),new WireEW(),new WirePoleEW(),new WireEW(),new WirePoleEW(),new WireEW(),new WirePoleEW(),new WireEW(),new WirePoleEW(),new WireEW(),new WirePoleEWend(),null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WireNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WirePoleSE(),new WireEW(),new WirePoleEW(),new WireEW(),new WirePoleEW(),new WireEW(),new WirePoleNSW(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WireNS(),null,null,null,null,null,new WireNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WirePoleNS(),null,null,null,null,null,new WirePoleNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WirePoleNS(),null,null,null,null,null,new WireNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WirePoleNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WireNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WirePoleNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WireNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WirePoleNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WireNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new WirePoleNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null}
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

            try
            {
                Tile tile = map[row][col];
                g2D.drawImage(tile.image, x, y, mapPanel.getScaledTileSize(), mapPanel.getScaledTileSize(), null);
            }
            catch (NullPointerException e)
            {

            }
            catch (IndexOutOfBoundsException ex)
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
