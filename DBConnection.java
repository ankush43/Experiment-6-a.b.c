import java.sql.*;

public class DBConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("✅ Connected to Database Successfully!");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

            System.out.println("Employee Data:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("name") + " - " + rs.getDouble("salary"));
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
