import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Database_test {
    public static void main(String[] args) {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.
                    getConnection("jdbc:postgresql://localhost:5432/test",
                    "postgres", "135243");
            System.out.println(c);
            System.out.println("Opened database success");
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();


            ResultSet rs = stmt.executeQuery(
                    "select * from student;");
            ArrayList<Student> li = new ArrayList<>();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dept = rs.getString("department");
                String gen = rs.getString("gender");
                int age = rs.getInt("age");
                int ady = rs.getInt("ad_year");
                Student k = new Student(id,name,dept,gen,age,ady);
                li.add(k);
            }
            for(Student t : li) {
                System.out.println(t);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
