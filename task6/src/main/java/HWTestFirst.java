import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class HWTestFirst {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 8, 6, 5, 4, 9}, new int[]{9}},
                {new int[]{9, 4, 3, 5, 8, 9}, new int[]{3, 5, 8, 9}},
                {new int[]{1, 1, 5, 4, 10, 15}, new int[]{10, 15}},
                {new int[]{16, 4, 42, 7, 9}, new int[]{42, 7, 9}},
                {new int[]{43, 25, 41, 4, 1}, new int[]{1}}
        });
    }

    private int[] in;
    private int[] out;

    public HWTestFirst(int[] in, int[] out) {
        this.in = in;
        this.out = out;
    }

    private Homework6 arrayTask;

    @BeforeClass
    public static void out(){
        System.out.println("TestTask1_1 Тест на правильность результата метода 1-ой задачи");
    }

    @Before
    public void init() {
        arrayTask = new Homework6();
    }

    @Test
    public void testArrayAfterFour() {
        Assert.assertArrayEquals(out, arrayTask.findeFour(in));
    }
}
