package classWork;

import java.sql.*;

public class Ex1 {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager
                .getConnection("jdbc:sqlite:classwork.db");
        System.out.println(conn);
        // connection autocommit (default)
        // conn.setAutoCommit(false);
        // conn.commit();
        Statement stmt = conn.createStatement();
        PreparedStatement ps = conn.prepareStatement("");
        // [q1, q2, q3, q4], [q5, q6, q7, q8]
        ps.executeBatch();
        // conn -> DB -> query -> update
        // RS(ans)
        stmt.execute("create table if not exists GB_USERS\n" +
                "(\n" +
                "    id  INTEGER primary key autoincrement ,\n" +
                "    name TEXT\n" +
                ");");
//        for (int i = 0; i < 15; i++) {
//            String userName = "'User" + (i + 1) % 3 + "'";
//            //stmt.executeUpdate("DELETE FROM GB_USERS WHERE id = " + (i + 1) + ";");
//            stmt.executeUpdate("INSERT INTO GB_USERS (name) " +
//                    "VALUES (" + userName +");");
//        }

        //stmt.executeUpdate("INSERT INTO GB_USERS values (13, 'Oleg');");
        //stmt.executeUpdate("INSERT INTO GB_USERS values (14, 'Pert');");
        ResultSet rs = stmt.executeQuery("select * from GB_USERS");
        while (rs.next()) {
            //column indexes starts with 1
            System.out.println("v1: " + rs.getInt(1) + " " +
                    rs.getString(2) + " " + rs.getString(3));
        }
    }
}
