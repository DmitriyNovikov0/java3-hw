package classWork;

public class User {

    class LocalClass{

    }

    private static long userCounter;
    private long id;

    public User() {
        synchronized (User.class) {
            userCounter++;
            id = userCounter;
        }
    }

    public final long getId(){
        return id;
    }
}
