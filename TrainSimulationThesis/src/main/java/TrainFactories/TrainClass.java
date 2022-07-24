package TrainFactories;

import java.util.ArrayList;

public class TrainClass
{
    private ArrayList<Train> vonat=new ArrayList<Train>();
    public void attach(Train attachable)
    {
        vonat.add(attachable);
    }

    public int getGauge()
    {
        return vonat.get(0).gaugeSize();
    }
    public void draw()
    {
        for (int i = 0; i < vonat.size(); i++)
        {
            System.out.println("Vonatkocsik: "+ vonat.get(i).toString());
        }
    }
}
