import java.util.Scanner;

public class Simulator {

    public static int P; //total number of processors
    public static int C; //total number of clock cycles
    public static String pathFile;
    private final Scanner scanner = new Scanner(System.in);

    public void userInput()
    {
        System.out.println("Enter total number of processors: ");
        P = scanner.nextInt();
        System.out.println("Enter total number of clock cycles: ");
        C = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Enter the path of the file to be processed: ");
        pathFile = scanner.nextLine();
    }

    //C:\\Users\\elida\\Desktop\\Elida\\Atypon Training\\Projects\\Processor Execution Simulation\\Text Files\\First.txt
}