package Drawables;

import GUI.MapPanel;
import Tiles.*;

import java.awt.*;

public class TrainDrawable
{
    private int xCoord = 99;
    private int yCoord = 66;
    private int xSpeed = -1;
    private int ySpeed = 0;
    MapPanel mp;
    TileManager tm;


    public TrainDrawable(MapPanel mapPanel)
    {
        this.mp = mapPanel;
        tm = new TileManager(mp);
    }

    public void update()
    {
        if (xSpeed == 1)
        {
            if (tm.getMapTiles(xCoord / mp.getScaledTileSize() + 1, yCoord / mp.getScaledTileSize()).getClass() == RailTileEW.class)
            {
                xCoord += 1;
            } else if (tm.getMapTiles(xCoord / mp.getScaledTileSize() + 1, yCoord / mp.getScaledTileSize()).getClass() == RailTileNW.class)
            {
                xCoord += 1;
                if (xCoord % mp.getScaledTileSize() == 0)
                {
                    xSpeed = 0;
                    ySpeed = -1;
                    yCoord -= 1;
                }

            } else if (tm.getMapTiles(xCoord / mp.getScaledTileSize() + 1, yCoord / mp.getScaledTileSize()).getClass() == RailTileSW.class)
            {
                xCoord += 1;
                if (xCoord % mp.getScaledTileSize() == 0)
                {
                    xSpeed = 0;
                    ySpeed = 1;
                }

            }
        } else if (xSpeed == -1)
        {
            if (tm.getMapTiles(xCoord / mp.getScaledTileSize(), yCoord / mp.getScaledTileSize()).getClass() == RailTileEW.class)
            {
                xCoord -= 1;
            } else if (tm.getMapTiles(xCoord / mp.getScaledTileSize(), yCoord / mp.getScaledTileSize()).getClass() == RailTileNE.class)
            {
                xCoord -= 1;
                if (xCoord % mp.getScaledTileSize() == 0)
                {
                    xSpeed = 0;
                    ySpeed = -1;
                    yCoord-=1;
                }
            } else if (tm.getMapTiles(xCoord / mp.getScaledTileSize(), yCoord / mp.getScaledTileSize()).getClass() == RailTileSE.class)
            {
                xCoord -= 1;
                if (xCoord % mp.getScaledTileSize() == 0)
                {
                    xSpeed = 0;
                    ySpeed = 1;
                }
            }
        } else if (ySpeed == 1)
        {
            if (tm.getMapTiles(xCoord / mp.getScaledTileSize(), yCoord / mp.getScaledTileSize() + 1).getClass() == RailTileNS.class)
            {
                yCoord += 1;
            } else if (tm.getMapTiles(xCoord / mp.getScaledTileSize(), yCoord / mp.getScaledTileSize() + 1).getClass() == RailTileNW.class)
            {
                yCoord += 1;
                if (yCoord % mp.getScaledTileSize() == 0)
                {
                    ySpeed = 0;
                    xSpeed = -1;
                    xCoord-=1;
                }
            } else if (tm.getMapTiles(xCoord / mp.getScaledTileSize(), yCoord / mp.getScaledTileSize() + 1).getClass() == RailTileNE.class)
            {
                yCoord += 1;
                if (yCoord % mp.getScaledTileSize() == 0)
                {
                    ySpeed = 0;
                    xSpeed = 1;
                }
            }
        } else if (ySpeed == -1)
        {
            if (tm.getMapTiles(xCoord / mp.getScaledTileSize(), yCoord / mp.getScaledTileSize()).getClass() == RailTileNS.class)
            {
                yCoord -= 1;
            } else if (tm.getMapTiles(xCoord / mp.getScaledTileSize(), yCoord / mp.getScaledTileSize()).getClass() == RailTileSW.class)
            {
                yCoord -= 1;
                if (yCoord % mp.getScaledTileSize() == 0)
                {
                    ySpeed = 0;
                    xSpeed = -1;
                    xCoord-=1;
                }
            } else if (tm.getMapTiles(xCoord / mp.getScaledTileSize(), yCoord / mp.getScaledTileSize()).getClass() == RailTileSE.class)
            {
                yCoord -= 1;
                if (yCoord % mp.getScaledTileSize() == 0)
                {
                    ySpeed = 0;
                    xSpeed = 1;
                }
            }
        }
    }

    public void draw(Graphics2D g2D)
    {
        g2D.setColor(Color.YELLOW);
        g2D.fillRect(xCoord, yCoord, mp.getScaledTileSize(), mp.getScaledTileSize());
    }
}
