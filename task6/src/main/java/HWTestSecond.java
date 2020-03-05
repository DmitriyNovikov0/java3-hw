import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class HWTestSecond {
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList (new Object[][]{
                {new int[]{1, 1, 1, 4, 1, 4}}, //true
                {new int[]{1, 1, 1, 4, 4, 1}}, //true
                {new int[]{4, 1, 4, 1, 4}},    //true
                {new int[]{4, 4, 4, 4, 4}},    //false
                {new int[]{4, 1, 5 ,1, 1}},    //false
                {new int[]{1, 1, 1 ,1, 1}}     //false
        });
    }
    private int[] in;
    private Homework6 arrayTask;

    public HWTestSecond(int[] in){
        this.in = in;
    }

    @BeforeClass
    public static void out(){
        System.out.println("TestTask2_True Тест на правильность результата TRUE метода 2-ой задачи");
    }

    @Before
    public void init(){
        arrayTask = new Homework6();
    }

    @Test
    public void  testUnitAndFourInArrayTrue(){
        Assert.assertTrue("в массиве отсутвуют 1 или/и 4",arrayTask.isPresentOneOrFour(in));
    }
}

