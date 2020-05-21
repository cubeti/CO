package co.project.logger;

import java.util.ArrayList;
import java.util.List;

public class Loggs {
    private static int id =0;
    private static ArrayList<AddValue> values;
    private static ArrayList<AddValue> AVG;
    static {
        values = new ArrayList<>();
        AVG = new ArrayList<>();
    }

    public static void addLog(int id,int nrThreads,long score,String info)
    {
        values.add(new AddValue(id, nrThreads, score ,info));
    }
    public static ArrayList<AddValue> getValues()
    {
        return values;
    }

    public static ArrayList<AddValue> getAVG() {
        int run=0;
        int i;
        int n=1;
        long time=0;
        AddValue temp;
        for(i=0;i<values.size();i++)
        {
            temp=values.get(i);run=1;
            if(temp.getID()==id)
            {
                time+=temp.getScore();
                n++;
            }
            else
            {
                if(temp.getID()>id){
                temp=values.get(i-1);

                AVG.add(new AddValue(id,temp.getThreads(),time/(n-1),"Avg of id "+(id)+" runs"));
                n=1;
                time=0;
                ++id;}
            }
        }
        if(run==1) {
            temp = values.get(i - 1);
            AVG.add(new AddValue(id, temp.getThreads(), time / (n-1), "Avg of id " + (id) + " runs"));
            id++;
        }

        return AVG;
    }
}
