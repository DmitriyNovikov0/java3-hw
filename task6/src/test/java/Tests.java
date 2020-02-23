
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.logging.*;
import java.util.logging.Formatter;

public class Tests {
    //TODO
    public ForTests inst;
    final static Logger log = Logger.getLogger("tests");

    @Before
    public void begin() {
        inst = new ForTests();
        try {
            FileHandler fh = new FileHandler("C:\\Users\\Mikhail\\IdeaProjects\\Java31\\task6\\src\\log.txt", true);
            log.setUseParentHandlers(false);
            fh.setFormatter(new Formatter() {
                @Override
                public String format(LogRecord record) {
                    Date date = new Date();
                    return date + " [" + record.getLevel() + "] " + record.getSourceClassName() + "."
                            + record.getSourceMethodName() + ": " + record.getMessage() + "\n";
                }
            });
            log.addHandler(fh);

        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("Begin invoked");
    }

    @Test
    public void testBS() {
        log.info("BinarySearch test invoked");
        int[] ar = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = -10; i < 10; i++) {
            int index = ForTests.binarySearch(ar, i, 0, ar.length);
            if (i <= 0 || i > 8) {
                Assert.assertEquals(-1, index);
            } else {
                Assert.assertEquals(i - 1, index);
            }
        }
    }

    @Test(timeout = 2000)
    public void testSort() {
        Random rnd = new Random();
        long start = System.currentTimeMillis();
        LinkedList<Integer> data = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            data.add(rnd.nextInt());
        }
        log.info("Sorted test start");
        List<Integer> ans = ForTests.sort(new ArrayList<>(data));
        log.info("Sorted test finished by " + (System.currentTimeMillis() - start) + " ms");
        for (int i = 0; i < ans.size()-1; i++) {
            if (ans.get(i) > ans.get(i+1)) {
                Assert.fail();
            }
        }
        log.info("Sorted test passed!");
    }

    @Test
    public void boolTest() {
        Assert.assertTrue(ForTests.isPrime(7));
        Assert.assertTrue(ForTests.isPrime(13));
        Assert.assertTrue(ForTests.isPrime(17));
        Assert.assertFalse(ForTests.isPrime(12));
        Assert.assertFalse(ForTests.isPrime(16));
    }

}
