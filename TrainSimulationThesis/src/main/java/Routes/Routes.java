package Routes;

public class Routes
{
    /**
     * Array size of 2;
     * X coordinate, Y coordinate
     */
    private int[] start;
    /**
     * Array size of 2;
     * X coordinate, Y coordinate
     */
    private int[] stop;
    private String routeName;

    public Routes(int[] start, int[] stop, String routeName)
    {
        this.start = start;
        this.stop = stop;
        this.routeName = routeName;
    }
}
