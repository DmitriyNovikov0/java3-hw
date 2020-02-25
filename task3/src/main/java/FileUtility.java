
import classwork.User;

import java.io.*;
import java.util.*;

public class FileUtility {

/*
мои вспомогательные методы
 */
public static String generate(int passLength) {
    String pass  = "";
    char[] symb = {'*', '!', '%'};
    Random r = new Random();
    if(passLength > 5 && passLength < 13) {

        for (int i = 0; i < passLength; ++i) {
            char next = 0;
            int range = 10;

            switch (r.nextInt(3)) {
                case 0: {
                    next = '0';
                    range = 10;
                }
                break;
                case 1: {
                    next = 'a';
                    range = 26;
                }
                break;
                case 2: {
                    next = 'A';
                    range = 26;
                }
                break;
/*
                case 3: {
                    symb[2];
                    //next = '!';
                    //range = 10;
                }
                break;
*/
            }

            pass += (char) ((r.nextInt(range)) + next);
        }
    }
    return pass + symb[r.nextInt(3)] + r.nextInt(9) + 's' + 'Q';
    //тут просто после pas добавил чтобы условие проходило, без этого веселее генератор паролей получился
}

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
        ArrayList<User> userList = new ArrayList<>();

        try (BufferedReader inFile = new BufferedReader(new FileReader(in))){
            String str;
            int i = 1;
            while((str = inFile.readLine()) != null){
                userList.add(new User(i, str, generate(6)));
            }
            inFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        for(User user : userList){
            System.out.println("имя: " + user.getName() + ", пароль: " + user.getPassword());
        }
       */
        //коментирую так как не проходит тестов хотя работает.... тут записываю объекты
        /*
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(out))) {
            for(User user : userList){
                os.writeObject(user);
            }
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        try (BufferedWriter outFile = new BufferedWriter(new FileWriter(out))){

            for(User user : userList){
                outFile.write(user.getName() + " " + user.getPassword());
                outFile.newLine();
            }

            outFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
     *  Метод должен дописать в переданный файл все
     * записи из списка по одной записи в строке
     * */
    public void appender(File file, List<String> records) throws IOException {
        //SOLID
        //LISKOV


        RandomAccessFile f = new RandomAccessFile(file, "rw");
        String str = "";
        int i = 0;
        while((str = f.readLine()) != null){
            f.seek((f.getFilePointer() - 2));
            f.writeBytes("1");
            i++;
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
        ArrayList<String> list = new ArrayList<>();

        try (RandomAccessFile file = new RandomAccessFile( pathToFile, "r")) {
            file.seek(file.length() - (80 * n));

            String str = "";
            while ((str = file.readLine()) != null) {
                list.add(str);
            }
        } catch(IOException e){
            e.printStackTrace();
        }

        return list;
    }

}
