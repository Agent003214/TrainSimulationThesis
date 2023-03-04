package Tiles.Scenery.Wires;

import Tiles.Tile;

public class WirePoleNEW extends Tile
{
    public WirePoleNEW()
    {
        filePaths=new String[]{"./src/main/resources/Tiles/Wires/wirePoleNEW.png"};
    }

    @Override
    protected String errorMessage()
    {
        return "Wire pole east west image not found";
    }
}
