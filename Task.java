import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Task {

    public static ArrayList<String> data = new ArrayList<>();

    public void readFile() {

        try {
            File myFile = new File(Simulator.pathFile);
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNextLine())
                data.add(myReader.nextLine());
            System.out.println(data);

            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}