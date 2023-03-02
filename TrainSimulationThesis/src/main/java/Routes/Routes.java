package Routes;
import GUI.Station;
import Tiles.Tile;

public class Routes
{
    /**
     * Array size of 2;
     * X coordinate, Y coordinate
     */
    //private final int[] start;
    /**
     * Array size of 2;
     * X coordinate, Y coordinate
     */
    //private final int[] stop;

    private Station startStation;
    private Station endStation;
    private int xSpeed;
    private int ySpeed;
    private final String routeName;
    private final Tile[][] line;
    private final boolean isElectrified;

   /* public Routes(int[] start, int[] stop, String routeName, Tile[][] line, boolean isElectrified)
    {
        this.start = start;
        this.stop = stop;
        this.routeName = routeName;
        this.line=line;
        this.isElectrified=isElectrified;
    }*/

    public Routes(Station startStation, Station endStation, String routeName, Tile[][] line,int xSpeed,int ySpeed, boolean isElectrified)
    {
        this.startStation = startStation;
        this.endStation= endStation;
        this.routeName = routeName;
        this.line=line;
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
        this.isElectrified=isElectrified;
    }

    public int[] getStart()
    {
        //return start;
        return startStation.getLocation();
    }

    public int[] getStop()
    {
        return endStation.getLocation();
        //return stop;
    }

    public int getxSpeed()
    {
        return xSpeed;
    }

    public int getySpeed()
    {
        return ySpeed;
    }

    public String getRouteName()
    {
        return routeName;
    }

    public Tile[][] getLine()
    {
        return line;
    }

    public Tile getTile(int col, int row)
    {
        return line[row][col];
    }

    public boolean isElectrified()
    {
        return isElectrified;
    }
}
