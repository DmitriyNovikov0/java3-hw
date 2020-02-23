import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    /*
    * Каждый из тасков решается одним SQL запросом
     */

    /*
    Создать таблицу принтеры, Printer(id INTEGER AI PK U, model INTEGER, color TEXT, type TEXT, price INTEGER)
    добавить в нее 3 записи:
    1 1012 col laser 20000 (производитель HP)
    2 1010 bw jet 5000 (производитель Canon)
    3 1010 bw jet 5000 (производитель Canon)
    Каждая вставка в таблицу принтер должна отражаться добавлением записи в таблицу продукт
     */


    void AddPrinters(Statement stmt) throws SQLException {
        // TODO: 16.12.2019
        stmt.executeUpdate("INSERT INTO Printer(model, color, type, price) VALUES (1012, 'col', 'laser', 20000);");
        stmt.executeUpdate("INSERT INTO Printer(model, color, type, price) VALUES (1010, 'bw', 'jet', 5000);");
        stmt.executeUpdate("INSERT INTO Printer(model, color, type, price) VALUES (1010, 'bw', 'jet', 5000);");

    }


    public void createPrinterTable(Connection con, Statement  stmt) throws SQLException {
        // TODO: 16.12.2019
        stmt.execute("CREATE TABLE IF NOT EXISTS Printer(id INTEGER AI PRIMARY KEY UNIQUE, model INTEGER, color TEXT, type TEXT, price INTEGER);");
    }

    /*
    * Метод должен вернуть список уникальных моделей PC дороже 15 тысяч
     */

    public ArrayList<String> selectExpensivePC(Statement stmt) throws SQLException {
        //todo
        ResultSet res = stmt.executeQuery("SELECT DISTINCT model FROM PC WHERE price > 15000 ;");
        ArrayList<String> outArrayList = new ArrayList<>();
        while(res.next()){
            outArrayList.add(Integer.toString(res.getInt(1)));
        }
        return outArrayList;
    }

    /*
     * Метод должен вернуть список id ноутов, скорость процессора
     * которых выше чем 2500
     */

    public ArrayList<Integer> selectQuickLaptop(Statement stmt) throws SQLException {
        // TODO: 16.12.2019  
        ResultSet res = stmt.executeQuery("SELECT id FROM Laptop WHERE speed > 2500 ;");
        ArrayList<Integer> outArrayList = new ArrayList<>();
        while(res.next()){
            outArrayList.add(res.getInt(1));
        }
        return outArrayList;
    }

    /*
     * Метод должен вернуть список производителей которые
     *  делают и пк и ноутбуки
     */
    public ArrayList<String> selectMaker(Statement stmt) throws SQLException {
        ResultSet res = stmt.executeQuery("SELECT maker, COUNT(maker) as counter FROM (SELECT DISTINCT * FROM product) GROUP BY maker having counter > 1 ;");
        ArrayList<String> outArrayList = new ArrayList<>();
        while(res.next()){
            outArrayList.add(res.getString("maker"));
        }
        return outArrayList;
    }

    /*
     * Метод должен вернуть максимальную среди всех произодителей
     * суммарную стоимость всех изделий типов ноутбук или компьютер,
     * произведенных одним производителем
     * Необходимо объединить таблицы продуктов ноутбуков и компьютеров
     * и отгрупировать по сумме прайсов после чего выбрать максимум
     * или сделать любым другим способом
     */

    public int makerWithMaxProceeds(Statement stmt) throws SQLException {
        int result = 0;
        ResultSet res = stmt.executeQuery("SELECT SUM(price) as sum FROM " +
                "(SELECT DISTINCT Laptop.id, maker, price FROM Product JOIN Laptop ON Product.model = Laptop.model" +
                " UNION " +
                "SELECT DISTINCT PC.id, maker, price FROM Product JOIN PC ON Product.model = PC.model) GROUP BY maker ORDER BY sum DESC LIMIT 1;");

        while(res.next()){
           result = res.getInt(1);
        }

        //todo
        return result;

    }
}
