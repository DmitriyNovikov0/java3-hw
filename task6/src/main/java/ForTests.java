import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ForTests {

    //протестируйте функцию
    public static List<Integer> sort(List<Integer> data) {
        data.sort(Comparator.comparingInt(arg -> arg));
        return data;
    }
    //O(sqrt(N))
    public static boolean isPrime(long value) {
        for (long i = 2; i * i <= value ; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int binarySearch(int [] data, int key, int l, int r){
        int mid = (l + r) / 2;
        if(data[mid] == key) return mid;
        if (l + 1 == r) return -1;
        // чего то не хватает, протестируйте и найдите баг в функции
        if(data[mid] > key) return binarySearch(data, key, l, mid);
        return binarySearch(data, key, mid, r);
    }

    //придумайте 2 функции и протестируйте их
}
