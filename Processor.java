import java.util.ArrayList;
import java.util.Objects;
import java.util.*;
import java.util.concurrent.*;

public class Processor {

    public static SortedMap<String,String> P = new ConcurrentSkipListMap<>();
    private void makeProcessors() //according to user's input P
    {
        for (int i = 1; i <= Simulator.P; i++)
            P.put("P"+i,"");
    }

    public static ArrayList<Integer> listP = new ArrayList<>();
    private void PtoList() //convert the P hashmap to integer arrayList in order to compare the values with each other for the time delay
    {
       for(String i:P.keySet())
       {
           String j = P.get(i);
           int intJ = Integer.parseInt(j);
           listP.add(intJ);
       }
    }

    private final SortedMap<String,String> C = new ConcurrentSkipListMap<>();
    private void makeCycles() //according to user's input C
    {
        for(int i=1; i <= Simulator.C; i++)
            C.put("C"+i,"");
    }

    private void assignHigh() throws InterruptedException //assign high priority tasks to processors
    {
        for (int i = 0; i < Schedular.highList.size() - 1; i++) {

            //IF DUPLICATE NUMBERS LIKE [561, 531, 511]
            if (Objects.equals(Schedular.firstDigitHigh.get(i), Schedular.firstDigitHigh.get(i + 1)))
            {
                for(int j=1; j <= P.size(); j++)
                {
                    if (Objects.equals(P.get("P" + j), ""))
                    {
                        for(int k=0; k < Schedular.duplicateListHigh.size(); k++) {
                            P.put("P" + j, Schedular.duplicateListHigh.get(0));
                            Schedular.duplicateListHigh.remove(0);
                        }
                    }
                }
            }
            else //SINGLE NUMBERS LIKE [511 671 821]
            {
                for(int j=1; j <= P.size(); j++)
                {
                    if (Objects.equals(P.get("P" + j), ""))
                    {
                        for(int k=0; k < Schedular.singleListHigh.size(); k++) {
                            P.put("P" + j, Schedular.singleListHigh.get(0));
                            Schedular.singleListHigh.remove(0);
                        }
                    }
                }
            }
        }
    }

    public void execution() throws InterruptedException {
        //makeCycles();
        //System.out.println(C);
        makeProcessors();
        System.out.println(P);

        System.out.println("\n");

        assignHigh();
        PtoList();

        System.out.println("Waiting tasks: "+Schedular.duplicateListHigh+Schedular.singleListHigh);

        Clock clock = new Clock();
        clock.execTimeHigh();

        //System.out.println("new single list HIGH"+Schedular.duplicateListLow+Schedular.singleListLow); //for low priority tasks
    }
}