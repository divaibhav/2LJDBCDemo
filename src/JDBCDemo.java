/*
 *  Created by IntelliJ IDEA.
 *  User: Vaibhav
 *  Date: 03-Dec-20
 *  Time: 4:43 PM
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) {
        try {
            //step 1
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //step 2
            //create the connection
            String url = "jdbc:mysql://localhost:3306/demo";
            String user = "root";
            String pass = "";
            Connection con = DriverManager.getConnection(url, user, pass);
            //step 3
            //create statement
            Statement stmt = con.createStatement();
            //step 4
            //sql
            String sql = "INSERT INTO `info` (`id`, `name`) VALUES ('500', 'Akash');";
            int rows = stmt.executeUpdate(sql);

            //step 5
            //analyzing the result
            System.out.println("no of rows affected = " + rows);

        }
        catch (ClassNotFoundException e){
            System.out.println("class not found");
            System.out.println(e.getMessage());
            //System.out.println(e.printStackTrace());
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            //System.out.println(e.printStackTrace());
        }
    }
}
