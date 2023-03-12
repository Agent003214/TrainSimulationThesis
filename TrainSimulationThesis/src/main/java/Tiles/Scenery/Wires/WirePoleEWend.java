package Tiles.Scenery.Wires;

import Tiles.Tile;

public class WirePoleEWend extends Tile
{
    public WirePoleEWend()
    {
        filePaths=new String[]{"./TrainSimulationThesis/src/main/resources/Tiles/Wires/wirePoleEWend.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "Wire pole east west end tile image not found";
    }
}
