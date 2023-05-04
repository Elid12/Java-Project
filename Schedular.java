import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Schedular {

    public static ArrayList<String> highList = new ArrayList<>();
    public static ArrayList<String> lowList = new ArrayList<>();
    private void priorities() //e.g. list=[140, 381, 260, 151] --> highList=[381, 151]   lowList=[140, 260]
    {
        for(int i = 1; i < Task.data.size(); i++)
        {
            String digit = Task.data.get(i);
            if(String.valueOf(digit.charAt(2)).equals("1"))
                highList.add(Task.data.get(i));
            else
                lowList.add(Task.data.get(i));
        }
    }

    private void sortedLists() //e.g. highList=[381, 151] --> sort --> [151, 381]
    {
        Collections.sort(highList);
        Collections.sort(lowList);
    }

    public static ArrayList<String> firstDigitHigh = new ArrayList<>(); //creation time
    public static ArrayList<String> firstDigitLow = new ArrayList<>();
    private final ArrayList<String> secondDigitHigh = new ArrayList<>(); //execution time
    private final ArrayList<String> secondDigitLow = new ArrayList<>();
    private void findDigits() //e.g. list = [140, 151, 261] --> firstDigit=[1, 1, 2]
    {
        for (String i : highList) {
            firstDigitHigh.add(String.valueOf(i.charAt(0)));
            secondDigitHigh.add(String.valueOf(i.charAt(1)));
        }

        for (String j : lowList) {
            firstDigitLow.add(String.valueOf(j.charAt(0)));
            secondDigitLow.add(String.valueOf(j.charAt(1)));
        }
    }

    public static ArrayList<Integer> execListHigh = new ArrayList<>(); //storing the execution time for each high priority task
    public static ArrayList<Integer> execListLow = new ArrayList<>();
    private void convertToIntExecTime()
    {
        for (String j : secondDigitHigh) {
            int intJ = Integer.parseInt(j);
            execListHigh.add(intJ);
        }

        for(String k: secondDigitLow)
        {
            int intK = Integer.parseInt(k);
            execListLow.add(intK);
        }
    }

    //FOR HIGH PRIORITY TASKS
    private final ArrayList<String> duplicates = new ArrayList<>();
    private final ArrayList<String> duplicatesOutOfReach = new ArrayList<>();
    public static ArrayList<String> duplicateListHigh = new ArrayList<>();
    private final ArrayList<String> singles = new ArrayList<>();
    private final ArrayList<String> singlesOutOfReach = new ArrayList<>();
    public static ArrayList<String> singleListHigh = new ArrayList<>();

    //FOR LOW PRIORITY TASKS
    private final ArrayList<String> duplicateZ = new ArrayList<>();
    private final ArrayList<String> duplicatesOutOfReachZ = new ArrayList<>();
    public static ArrayList<String> duplicateListLow = new ArrayList<>();
    private final ArrayList<String> singleZ = new ArrayList<>();
    private final ArrayList<String> singlesOutOfReachZ = new ArrayList<>();
    public static ArrayList<String> singleListLow = new ArrayList<>();

    private void subList(ArrayList<String> firstDigit, ArrayList<String> dup, ArrayList<String> dupOut, ArrayList<String> list,
                         ArrayList<String> sing, ArrayList<String> singOut, ArrayList<String> dupFinal,
                         ArrayList<String> singFinal) //list of unique numbers and list of duplicate numbers of high/low priority lists
    {
        for(int i=0; i <firstDigit.size()-1; i++)
        {
            if(Objects.equals(firstDigit.get(i), firstDigit.get(i + 1)))
            {
                dup.add(list.get(i));
                dupOut.add(list.get(i+1));
            }
            else
            {
                sing.add(list.get(i));
                singOut.add(list.get(i+1));
            }
        }
        dupFinal.addAll(dup);
        dupFinal.addAll(dupOut);
        Collections.sort(dupFinal);

        singFinal.addAll(sing);
        singFinal.addAll(singOut);
        Collections.sort(singFinal);

        for(int j=0; j<dupFinal.size()-1; j++)
        {
            if(Objects.equals(dupFinal.get(j) , dupFinal.get(j+1)))
                dupFinal.remove(j);
        }

        for(int i=0; i<singFinal.size()-1; i++)
        {
            if(Objects.equals(singFinal.get(i), singFinal.get(i + 1)))
                singFinal.remove(i);
        }
        singFinal.removeAll(dupFinal);

        Collections.reverse(dupFinal); //e.g. list=[531, 561] --> [561, 531] because we need to sort tasks with the biggest exec time
    }

    public void showHighLowPriorityLists()
    {
        priorities();
        sortedLists();
        System.out.println("High priority tasks: "+highList);
        System.out.println("Low priority tasks: "+lowList);

        findDigits();
        convertToIntExecTime();

        subList(firstDigitHigh,duplicates,duplicatesOutOfReach,highList,singles,singlesOutOfReach,duplicateListHigh,singleListHigh);
        subList(firstDigitLow,duplicateZ,duplicatesOutOfReachZ,lowList,singleZ,singlesOutOfReachZ,duplicateListLow,singleListLow);
    }
}