package Routes;
import Tiles.Tile;

public class Routes
{
    /**
     * Array size of 2;
     * X coordinate, Y coordinate
     */
    private final int[] start;
    /**
     * Array size of 2;
     * X coordinate, Y coordinate
     */
    private final int[] stop;
    private final String routeName;
    private final Tile[][] line;
    private final boolean isElectrified;

    public Routes(int[] start, int[] stop, String routeName, Tile[][] line, boolean isElectrified)
    {
        this.start = start;
        this.stop = stop;
        this.routeName = routeName;
        this.line=line;
        this.isElectrified=isElectrified;
    }

    public int[] getStart()
    {
        return start;
    }

    public int[] getStop()
    {
        return stop;
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
