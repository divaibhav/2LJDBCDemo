/*
 *  Created by IntelliJ IDEA.
 *  User: Vaibhav
 *  Date: 04-Dec-20
 *  Time: 4:30 PM
 */

import java.sql.*;

public class PreparedStatementDemo {
    public static void main(String[] args) {
        try {
            System.out.println("no of rows = " + insert(900, "Rahul"));
            ResultSet rs = getData(500);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(id + "\t\t" + name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public static int insert(int id ,  String name) throws SQLException {
        int rows = 0;
        Connection con = SelectQueryDemo.getDbConnection();
        String sql = "INSERT INTO info (id, name) VALUES (?, ?);";
        PreparedStatement pstmt = con.prepareStatement(sql);
        //setting the values of parameter
        pstmt.setInt(1,id);
        pstmt.setString(2, name);
        rows = pstmt.executeUpdate();
        return rows;
    }
    public static ResultSet getData(int id) throws SQLException {
        ResultSet rs = null;
        Connection con = SelectQueryDemo.getDbConnection();
        String sql = "SELECT * FROM info WHERE id < ?;";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();
        return rs;
    }
}