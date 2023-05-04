public class Main {

    public static void main(String[] args) throws InterruptedException {

        Simulator simulator = new Simulator();
        Task task = new Task();
        Schedular schedular = new Schedular();
        Processor processor = new Processor();

        simulator.userInput();
        task.readFile();
        schedular.showHighLowPriorityLists();
        processor.execution();
    }
}