import java.io.*;
import java.util.*;

public class FileUtility {

    /*
     * Структура файла ввода: в первой строке одно целое число - N
     * далее следует N целых чисел через пробел
     * Метод должен отсортировать элементы с четным значением,
     * а нечетные оставить на своих местах и вывести результат через пробел в файл вывода
     * Пример:
     * in:
     * 5
     * 5 4 2 1 3    // 2 4
     * out:
     * 5 2 4 1 3
     */

    public void sortEvenElements(File in, File out) {
        //TODO
        try {
            Scanner cin = new Scanner(in);
            int n = cin.nextInt();
            int [] a = new int[n];
            LinkedList<Integer> even = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                a[i] = cin.nextInt();
                if (a[i] % 2 == 0) {
                    even.add(a[i]); //O(1)
                    //O(n)
                }
            }
            Collections.sort(even);
            for (int i = 0; i < n; i++) {
                if (a[i] % 2 == 0) {
                    a[i] = even.pollFirst(); //O(1)
                }
            }
            FileWriter writer = new FileWriter(out);
            for (int i = 0; i < n; i++) {
                writer.write(a[i] + " ");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Генератор паролей, пароль должен отвечать требованиям:
     * длина не менее 6 и не более 12, включает минимум по одному символу
     * из наборов: a-z, A-Z, 0-9, {*,!,%}
     * все пароли должны быть разными
     * На вход метод получает файл с логинами пользователей
     * Метод должен записать в файл вывода записи с логинами и паролями
     * для каждого пользователя
     */

    public void passwordGen(File in, File out) {
        //TODO

    }

    /*
     *  Метод должен дописать в переданный файл все
     * записи из списка по одной записи в строке
     * */
    public void appender(File file, List<String> records) {
        //SOLID
        //LISKOV



        try (FileWriter writer = new FileWriter(file, true)) {
            for(String str : records) {
                writer.write(str + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Метод возвращает список из N последних строк файла
     * строки можно дополнять пробелами до длины 80
     * тогда количество символов в файле будет предсказуемо
     * 10 строк это ровно 800 символов
     * Изучите класс RandomAccessFile для эффективного решения данной
     * задачи
     * Альтернативное решение: использование очереди или стека
     * */
    public List<String> getNString(String pathToFile, int n) {
        //TODO
        // \n \r, \n
        return null;
    }

}
