import java.sql.*;
import java.util.Arrays;


public class DBClass {
  private static Connection conn;
  private static Statement stmt;



    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager
                    .getConnection("jdbc:sqlite:homework.db");
            stmt = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }

        DBUtility db = new DBUtility();
        db.createPrinterTable(conn , stmt);
        db.AddPrinters(stmt);

        for(String modelPC : db.selectExpensivePC(stmt)){
            System.out.println(modelPC);
        }

        for(Integer modelPC : db.selectQuickLaptop(stmt)){
            System.out.println(modelPC);
        }

        for(String modelPC : db.selectMaker(stmt)){
            System.out.println(modelPC);
        }

        System.out.println(db.makerWithMaxProceeds(stmt));

    }
}
