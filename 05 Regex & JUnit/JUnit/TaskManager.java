package JUnit;

public class TaskManager {

    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000);
        return "Completed";
    }
}
