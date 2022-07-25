package Factories;

import Attachables.Attachable;
import TrainEngines.Locomotive;

public interface Train
{
    Attachable getCars();
   void draw();
}
