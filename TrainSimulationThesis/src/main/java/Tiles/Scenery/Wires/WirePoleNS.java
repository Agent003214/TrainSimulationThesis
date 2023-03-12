package Tiles.Scenery.Wires;

import Tiles.Tile;

public class WirePoleNS extends Tile
{
    public WirePoleNS()
    {
        filePaths=new String[]{"./TrainSimulationThesis/src/main/resources/Tiles/Wires/wirePoleNS.png"};
    }
    @Override
    protected String errorMessage()
    {
        return "Wire pole north south tile image not found";
    }
}
