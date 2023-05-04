import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Clock {

    public void execTimeHigh() throws InterruptedException {

        for(int i=0; i < Processor.listP.size()-1; i++)
        {
            System.out.println(Processor.P);
            TimeUnit.SECONDS.sleep(Schedular.execListHigh.get(i));
            Processor.P.replace("P" + "2", ""); //"P"+i
            System.out.println(Processor.P);

            //some if statement checking the smallest value in the P hashmap. The smallest will be then replaced with the next task
            //because it had shorted execution time, therefore making the P1 or P2 ... Pn available
            if(Objects.equals(Processor.P.get("P" + "2"), "")) {
                Processor.P.replace("P" + "2", Schedular.singleListHigh.get(i));
                System.out.println(Processor.P);
            }
        }
    }
}