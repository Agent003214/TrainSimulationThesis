package TrainFactories;

import Trains.PassengerTrain;
public class PassengerTrainFactory extends TrainFactory
{
    @Override
    public Train getTrain()
    {
        return new PassengerTrain();
    }
}
