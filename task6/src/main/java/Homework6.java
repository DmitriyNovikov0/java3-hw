import java.util.Arrays;

public class Homework6 {
//константы для 2 задания
    private static final int NUM_FOUR = 4;
    private static final int NUM_ONE = 1;

    //1 задание
    public int[] findeFour(int[] arr){
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == NUM_FOUR)
            {
                //выходим из метода и возвращаем новый массив
                return Arrays.copyOfRange(arr, i + 1, arr.length);
            }
        }
        //нет четверки выкидываем исключение
        throw new RuntimeException();
    }

    //2 задание
    public boolean isPresentOneOrFour(int[] arr) {
        boolean one = false, four = false;
        for (int num : arr) {
            if (num == NUM_ONE) {
                one = true;
                //переходим на слоедущую итерацию что бы метод не вернул false
                continue;
            }
            if (num == NUM_FOUR) {
                four = true;
                continue;
            }
            // метод возвращает false если в массиве найдено число отличное от 1 или 4
            return false;
        }
        //возвращаем true если найдена 1 и 4 иначе false
        return one && four ;
    }
}
