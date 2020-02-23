public class DebugClass {
    public static void main(String[] args) {
        Object mutex = new Object();
        for (int i = 0; i < 30; i++) {
            new Thread(new TaskRunner(mutex, String.valueOf(i+1), i)).start();
        }
    }
}
