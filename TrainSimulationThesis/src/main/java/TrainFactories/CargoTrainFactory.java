package TrainFactories;

import Trains.CargoTrain;
public class CargoTrainFactory extends TrainFactory
{
    @Override
    public Train getTrain()
    {
        return new CargoTrain();
    }
}
