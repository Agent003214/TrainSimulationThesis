package Drawables;

import Attachables.Attachable;
import Attachables.Cargo.Cargo;
import Factories.Train;
import GUI.MapPanel;
import Routes.Routes;
import Tiles.RailTiles.Electrified.*;
import Tiles.RailTiles.NonElectrified.*;
import Tiles.RailTiles.RailPlatformTileEW;
import Tiles.RailTiles.RailPlatformTileNS;
import TrainEngines.Locomotive;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TrainDrawable
{
    private int xCoord;
    private int yCoord;
    private int xSpeed;
    private int ySpeed;
    private MapPanel mp;
    private BufferedImage imageRight, imageUp, imageDown;
    private Routes route;
    private Train trainPiece;

    /*public TrainDrawable(MapPanel mp, Routes route, BufferedImage imageRight, BufferedImage imageUp, BufferedImage imageDown, int xSpeed, int ySpeed)
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
    }*/

    public TrainDrawable(MapPanel mp, Routes route, Train trainPiece)
    {
        this.mp = mp;
        this.route = route;
        this.trainPiece = trainPiece;
        if (trainPiece instanceof Attachable)
        {
            this.imageRight = ((Attachable) trainPiece).getRightSidePixelArt();
            this.imageUp = ((Attachable) trainPiece).getBackPixelArt();
            this.imageDown = ((Attachable) trainPiece).getFrontPixelArt();
        }
        if (trainPiece instanceof Locomotive)
        {
            this.imageRight=((Locomotive) trainPiece).getRightSidePixelArt();
            this.imageUp =((Locomotive) trainPiece).getBackPixelArt();
            this.imageDown=((Locomotive) trainPiece).getFrontPixelArt();
        }
        this.xSpeed=route.getxSpeed();
        this.ySpeed=route.getySpeed();

        this.xCoord = route.getStart()[0] * mp.getScaledTileSize();
        this.yCoord = route.getStart()[1] * mp.getScaledTileSize();
    }


    public int[] getStartStation()
    {
        return route.getStart();
    }

    public int[] getStopLocation()
    {
        return route.getStop();
    }

    /**
     *Loads the cargo with the type and amount of cargo
     * @param type The type of cargo wished to being loaded
     * @param load The amount of cargo being loaded
     * @return The amount of cargo capacity of station after the attachable being loaded <br>
     *  -1 If the current trainpiece being loaded is a locomotive
     */
    public int load(Cargo type,int load)
    {

        if(trainPiece instanceof Attachable)
        {
            ((Attachable) trainPiece).loadCargoType(type);
            return ((Attachable) trainPiece).loadCargo(load,type);
        }
        return -1;
    }

    /**
     *Unloads the cargo from the train piece
     * @param load The amount of free space the station has
     * @return
     */
    public int unload(int load)
    {
        if (trainPiece instanceof Attachable)
        {
            return ((Attachable)trainPiece).unloadCargo(load);
        }
        return -1;
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
     *
     * @return 0 if nothing needs to be done. <br>
     * -1 When the train piece is on the start station and needs to be loaded. <br>
     * -2 When the train piece reaches its end station and needs to be unloaded and removed.
     */
    public int update()
    {
        if (xSpeed == 1)
        {
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
            if (xCoord / mp.getScaledTileSize() == route.getStart()[0] && yCoord / mp.getScaledTileSize() == route.getStart()[1])
            {
                return -1;
                //throw new StationLoadException();
            }
            if (xCoord / mp.getScaledTileSize() == route.getStop()[0] && yCoord / mp.getScaledTileSize() == route.getStop()[1])
            {
                return -2;
                //throw new RuntimeException();
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
            if (xCoord / mp.getScaledTileSize()+1 == route.getStart()[0] && yCoord / mp.getScaledTileSize() == route.getStart()[1])
            {
                return -1;
                //throw new StationLoadException();
            }
            if (xCoord / mp.getScaledTileSize()+1 == route.getStop()[0] && yCoord / mp.getScaledTileSize() == route.getStop()[1])
            {
                return -2;
                //throw new RuntimeException();
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
            else if (route.getTile(xCoord / mp.getScaledTileSize(), yCoord / mp.getScaledTileSize()+1).getClass() == RailPlatformTileNS.class)
            {
                yCoord+=1;
            }
            if (xCoord / mp.getScaledTileSize() == route.getStart()[0] && yCoord / mp.getScaledTileSize() == route.getStart()[1])
            {
                return -1;
                //throw new StationLoadException();
            }
            if (xCoord / mp.getScaledTileSize() == route.getStop()[0] && yCoord / mp.getScaledTileSize() == route.getStop()[1])
            {
                return -2;
                //throw new RuntimeException();
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
            else if (route.getTile(xCoord / mp.getScaledTileSize(), yCoord / mp.getScaledTileSize()).getClass() == RailPlatformTileNS.class)
            {
                yCoord-=1;
            }
            if (xCoord / mp.getScaledTileSize() == route.getStart()[0] && yCoord / mp.getScaledTileSize()+1 == route.getStart()[1])
            {
                return -1;
                //throw new StationLoadException();
            }
            if (xCoord / mp.getScaledTileSize() == route.getStop()[0] && yCoord / mp.getScaledTileSize()+1 == route.getStop()[1])
            {
                return -2;
                //throw new RuntimeException();
            }
        }
        /*if (xCoord / mp.getScaledTileSize() == route.getStart()[0] && yCoord / mp.getScaledTileSize() == route.getStart()[1])
        {
            return -1;
            //throw new StationLoadException();
        }
        if (xCoord / mp.getScaledTileSize() == route.getStop()[0] && yCoord / mp.getScaledTileSize() == route.getStop()[1])
        {
            return -2;
            //throw new RuntimeException();
        }*/
        return 0;
    }

    public Train getTrainPiece()
    {
        return trainPiece;
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
