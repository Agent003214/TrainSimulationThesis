package Drawables;

import GUI.MapPanel;
import Tiles.*;
import Routes.Routes;
import Tiles.RailTiles.Electrified.*;
import Tiles.RailTiles.NonElectrified.*;
import Tiles.RailTiles.RailPlatformTileEW;
import Tiles.RailTiles.RailTile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TrainDrawable
{
    private int xCoord;
    private int yCoord;
    private int xSpeed;
    private int ySpeed;
    private MapPanel mp;
    private BufferedImage imageRight, imageUp, imageDown;
    private Routes route;

    public TrainDrawable(MapPanel mp, Routes route, BufferedImage imageRight, BufferedImage imageUp, BufferedImage imageDown, int xSpeed, int ySpeed)
    {
        this.mp = mp;
        this.route = route;
        this.imageRight = imageRight;
        this.imageUp = imageUp;
        this.imageDown = imageDown;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;

        this.xCoord = route.getStart()[0] * mp.getScaledTileSize();
        this.yCoord = route.getStart()[1] * mp.getScaledTileSize();
    }

    public boolean isOccupied(int[] coord)
    {
        if (xCoord / mp.getScaledTileSize() == coord[0] && yCoord / mp.getScaledTileSize() == coord[1])
        {
            return true;
        }
        return false;
    }

    /**
     * @throws RuntimeException When the train reaches its end station and needs to be removed
     */
    public void update() throws RuntimeException
    {
        if (xSpeed == 1)
        {
            //System.out.println(route.getLine()[xCoord/ mp.getScaledTileSize()+1][yCoord / mp.getScaledTileSize()].getClass());
            //System.out.println(xCoord/ mp.getScaledTileSize()+1+" "+yCoord / mp.getScaledTileSize());
            if (route.getTile(xCoord / mp.getScaledTileSize() + 1, yCoord / mp.getScaledTileSize()).getClass() == RailTileEW.class)
            {
                xCoord += 1;
            }
            else if (route.getTile(xCoord / mp.getScaledTileSize() + 1, yCoord / mp.getScaledTileSize()).getClass() == RailTileNW.class)
            {
                xCoord += 1;
                if (xCoord % mp.getScaledTileSize() == 0)
                {
                    xSpeed = 0;
                    ySpeed = -1;
                    yCoord -= 1;
                }
            }
            else if (route.getTile(xCoord / mp.getScaledTileSize() + 1, yCoord / mp.getScaledTileSize()).getClass() == RailTileSW.class)
            {
                xCoord += 1;
                if (xCoord % mp.getScaledTileSize() == 0)
                {
                    xSpeed = 0;
                    ySpeed = 1;
                }
            }
            else if (route.getTile(xCoord / mp.getScaledTileSize() + 1, yCoord / mp.getScaledTileSize()).getClass() == RailPlatformTileEW.class)
            {
                xCoord += 1;
            }
        }
        else if (xSpeed == -1)
        {
            if (route.getTile(xCoord / mp.getScaledTileSize(), yCoord / mp.getScaledTileSize()).getClass() == RailTileEW.class)
            {
                xCoord -= 1;
            }
            else if (route.getTile(xCoord / mp.getScaledTileSize(), yCoord / mp.getScaledTileSize()).getClass() == RailTileNE.class)
            {
                xCoord -= 1;
                if (xCoord % mp.getScaledTileSize() == 0)
                {
                    xSpeed = 0;
                    ySpeed = -1;
                    yCoord -= 1;
                }
            }
            else if (route.getTile(xCoord / mp.getScaledTileSize(), yCoord / mp.getScaledTileSize()).getClass() == RailTileSE.class)
            {
                xCoord -= 1;
                if (xCoord % mp.getScaledTileSize() == 0)
                {
                    xSpeed = 0;
                    ySpeed = 1;
                }
            }
            else if (route.getTile(xCoord / mp.getScaledTileSize(), yCoord / mp.getScaledTileSize()).getClass() == RailPlatformTileEW.class)
            {
                xCoord -= 1;
            }
        }
        else if (ySpeed == 1)
        {
            if (route.getTile(xCoord / mp.getScaledTileSize(), yCoord / mp.getScaledTileSize() + 1).getClass() == RailTileNS.class)
            {
                yCoord += 1;
            }
            else if (route.getTile(xCoord / mp.getScaledTileSize(), yCoord / mp.getScaledTileSize() + 1).getClass() == RailTileNW.class)
            {
                yCoord += 1;
                if (yCoord % mp.getScaledTileSize() == 0)
                {
                    ySpeed = 0;
                    xSpeed = -1;
                    xCoord -= 1;
                }
            }
            else if (route.getTile(xCoord / mp.getScaledTileSize(), yCoord / mp.getScaledTileSize() + 1).getClass() == RailTileNE.class)
            {
                yCoord += 1;
                if (yCoord % mp.getScaledTileSize() == 0)
                {
                    ySpeed = 0;
                    xSpeed = 1;
                }
            }
        }
        else if (ySpeed == -1)
        {
            if (route.getTile(xCoord / mp.getScaledTileSize(), yCoord / mp.getScaledTileSize()).getClass() == RailTileNS.class)
            {
                yCoord -= 1;
            }
            else if (route.getTile(xCoord / mp.getScaledTileSize(), yCoord / mp.getScaledTileSize()).getClass() == RailTileSW.class)
            {
                yCoord -= 1;
                if (yCoord % mp.getScaledTileSize() == 0)
                {
                    ySpeed = 0;
                    xSpeed = -1;
                    xCoord -= 1;
                }
            }
            else if (route.getTile(xCoord / mp.getScaledTileSize(), yCoord / mp.getScaledTileSize()).getClass() == RailTileSE.class)
            {
                yCoord -= 1;
                if (yCoord % mp.getScaledTileSize() == 0)
                {
                    ySpeed = 0;
                    xSpeed = 1;
                }
            }
        }
        if (xCoord / mp.getScaledTileSize() == route.getStop()[0] && yCoord / mp.getScaledTileSize() == route.getStop()[1])
        {
            throw new RuntimeException();
        }
    }

    private void updateElectric()
    {
        if (xSpeed == 1)
        {
            if (route.getLine()[xCoord / mp.getScaledTileSize() + 1][yCoord / mp.getScaledTileSize()].getClass() == ElectrifiedRailTileEW.class)
            {
                xCoord += 1;
            }
            else if (route.getLine()[xCoord / mp.getScaledTileSize() + 1][yCoord / mp.getScaledTileSize()].getClass() == ElectrifiedRailTileNW.class)
            {
                xCoord += 1;
                if (xCoord % mp.getScaledTileSize() == 0)
                {
                    xSpeed = 0;
                    ySpeed = -1;
                    yCoord -= 1;
                }
            }
            else if (route.getLine()[xCoord / mp.getScaledTileSize() + 1][yCoord / mp.getScaledTileSize()].getClass() == ElectrifiedRailTileSW.class)
            {
                xCoord += 1;
                if (xCoord % mp.getScaledTileSize() == 0)
                {
                    xSpeed = 0;
                    ySpeed = 1;
                }
            }
        }
        else if (xSpeed == -1)
        {
            if (route.getLine()[xCoord / mp.getScaledTileSize()][yCoord / mp.getScaledTileSize()].getClass() == ElectrifiedRailTileEW.class)
            {
                xCoord -= 1;
            }
            else if (route.getLine()[xCoord / mp.getScaledTileSize()][yCoord / mp.getScaledTileSize()].getClass() == ElectrifiedRailTileNE.class)
            {
                xCoord -= 1;
                if (xCoord % mp.getScaledTileSize() == 0)
                {
                    xSpeed = 0;
                    ySpeed = -1;
                    yCoord -= 1;
                }
            }
            else if (route.getLine()[xCoord / mp.getScaledTileSize()][yCoord / mp.getScaledTileSize()].getClass() == ElectrifiedRailTileSE.class)
            {
                xCoord -= 1;
                if (xCoord % mp.getScaledTileSize() == 0)
                {
                    xSpeed = 0;
                    ySpeed = 1;
                }
            }
        }
        else if (ySpeed == 1)
        {
            if (route.getLine()[xCoord / mp.getScaledTileSize()][yCoord / mp.getScaledTileSize() + 1].getClass() == ElectrifiedRailTileNS.class)
            {
                yCoord += 1;
            }
            else if (route.getLine()[xCoord / mp.getScaledTileSize()][yCoord / mp.getScaledTileSize() + 1].getClass() == ElectrifiedRailTileNW.class)
            {
                yCoord += 1;
                if (yCoord % mp.getScaledTileSize() == 0)
                {
                    ySpeed = 0;
                    xSpeed = -1;
                    xCoord -= 1;
                }
            }
            else if (route.getLine()[xCoord / mp.getScaledTileSize()][yCoord / mp.getScaledTileSize() + 1].getClass() == ElectrifiedRailTileNE.class)
            {
                yCoord += 1;
                if (yCoord % mp.getScaledTileSize() == 0)
                {
                    ySpeed = 0;
                    xSpeed = 1;
                }
            }
        }
        else if (ySpeed == -1)
        {
            if (route.getLine()[xCoord / mp.getScaledTileSize()][yCoord / mp.getScaledTileSize()].getClass() == ElectrifiedRailTileNS.class)
            {
                yCoord -= 1;
            }
            else if (route.getLine()[xCoord / mp.getScaledTileSize()][yCoord / mp.getScaledTileSize()].getClass() == ElectrifiedRailTileSW.class)
            {
                yCoord -= 1;
                if (yCoord % mp.getScaledTileSize() == 0)
                {
                    ySpeed = 0;
                    xSpeed = -1;
                    xCoord -= 1;
                }
            }
            else if (route.getLine()[xCoord / mp.getScaledTileSize()][yCoord / mp.getScaledTileSize()].getClass() == ElectrifiedRailTileSE.class)
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

    private void updateDiesel()
    {
        if (xSpeed == 1)
        {
            if (route.getLine()[xCoord / mp.getScaledTileSize() + 1][yCoord / mp.getScaledTileSize()].getClass() == RailTileEW.class)
            {
                xCoord += 1;
            }
            else if (route.getLine()[xCoord / mp.getScaledTileSize() + 1][yCoord / mp.getScaledTileSize()].getClass() == ElectrifiedRailTileNW.class)
            {
                xCoord += 1;
                if (xCoord % mp.getScaledTileSize() == 0)
                {
                    xSpeed = 0;
                    ySpeed = -1;
                    yCoord -= 1;
                }
            }
            else if (route.getLine()[xCoord / mp.getScaledTileSize() + 1][yCoord / mp.getScaledTileSize()].getClass() == ElectrifiedRailTileSW.class)
            {
                xCoord += 1;
                if (xCoord % mp.getScaledTileSize() == 0)
                {
                    xSpeed = 0;
                    ySpeed = 1;
                }
            }
        }
        else if (xSpeed == -1)
        {
            if (route.getLine()[xCoord / mp.getScaledTileSize()][yCoord / mp.getScaledTileSize()].getClass() == ElectrifiedRailTileEW.class)
            {
                xCoord -= 1;
            }
            else if (route.getLine()[xCoord / mp.getScaledTileSize()][yCoord / mp.getScaledTileSize()].getClass() == ElectrifiedRailTileNE.class)
            {
                xCoord -= 1;
                if (xCoord % mp.getScaledTileSize() == 0)
                {
                    xSpeed = 0;
                    ySpeed = -1;
                    yCoord -= 1;
                }
            }
            else if (route.getLine()[xCoord / mp.getScaledTileSize()][yCoord / mp.getScaledTileSize()].getClass() == ElectrifiedRailTileSE.class)
            {
                xCoord -= 1;
                if (xCoord % mp.getScaledTileSize() == 0)
                {
                    xSpeed = 0;
                    ySpeed = 1;
                }
            }
        }
        else if (ySpeed == 1)
        {
            if (route.getLine()[xCoord / mp.getScaledTileSize()][yCoord / mp.getScaledTileSize() + 1].getClass() == ElectrifiedRailTileNS.class)
            {
                yCoord += 1;
            }
            else if (route.getLine()[xCoord / mp.getScaledTileSize()][yCoord / mp.getScaledTileSize() + 1].getClass() == ElectrifiedRailTileNW.class)
            {
                yCoord += 1;
                if (yCoord % mp.getScaledTileSize() == 0)
                {
                    ySpeed = 0;
                    xSpeed = -1;
                    xCoord -= 1;
                }
            }
            else if (route.getLine()[xCoord / mp.getScaledTileSize()][yCoord / mp.getScaledTileSize() + 1].getClass() == ElectrifiedRailTileNE.class)
            {
                yCoord += 1;
                if (yCoord % mp.getScaledTileSize() == 0)
                {
                    ySpeed = 0;
                    xSpeed = 1;
                }
            }
        }
        else if (ySpeed == -1)
        {
            if (route.getLine()[xCoord / mp.getScaledTileSize()][yCoord / mp.getScaledTileSize()].getClass() == ElectrifiedRailTileNS.class)
            {
                yCoord -= 1;
            }
            else if (route.getLine()[xCoord / mp.getScaledTileSize()][yCoord / mp.getScaledTileSize()].getClass() == ElectrifiedRailTileSW.class)
            {
                yCoord -= 1;
                if (yCoord % mp.getScaledTileSize() == 0)
                {
                    ySpeed = 0;
                    xSpeed = -1;
                    xCoord -= 1;
                }
            }
            else if (route.getLine()[xCoord / mp.getScaledTileSize()][yCoord / mp.getScaledTileSize()].getClass() == ElectrifiedRailTileSE.class)
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

    /*public void update()
    {
        xCoord=xCoord+xSpeed;
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
    }*/

    public void draw(Graphics2D g2D)
    {
        /*g2D.setColor(Color.YELLOW);
        g2D.fillRect(xCoord, yCoord, mp.getScaledTileSize(), mp.getScaledTileSize());*/
        //g2D.drawImage(image,xCoord,yCoord-10,mp.getScaledTileSize(), mp.getScaledTileSize(),null);
        if (xSpeed == 1)
        {
            g2D.drawImage(imageRight, xCoord, yCoord - 10, mp.getScaledTileSize(), mp.getScaledTileSize(), null);
        }
        if (xSpeed == -1)
        {
            g2D.drawImage(imageRight, xCoord + mp.getScaledTileSize(), yCoord - 10, -mp.getScaledTileSize(), mp.getScaledTileSize(), null);
        }
        if (ySpeed == 1)
        {
            g2D.drawImage(imageDown, xCoord, yCoord - 10, mp.getScaledTileSize(), mp.getScaledTileSize(), null);
        }
        if (ySpeed == -1)
        {
            g2D.drawImage(imageUp, xCoord, yCoord - 10, mp.getScaledTileSize(), mp.getScaledTileSize(), null);
        }
    }
}
