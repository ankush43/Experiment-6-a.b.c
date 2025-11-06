package dao;
import java.sql.*;
import model.Student;
import java.util.*;

public class StudentDAO {
    private String url = "jdbc:mysql://localhost:3306/school";
    private String username = "root";
    private String password = "password";

    public void addStudent(Student s) {
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = con.prepareStatement("INSERT INTO students VALUES (?, ?, ?)")) {
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getCourse());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement st = con.createStatement()) {

            ResultSet rs = st.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                list.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
