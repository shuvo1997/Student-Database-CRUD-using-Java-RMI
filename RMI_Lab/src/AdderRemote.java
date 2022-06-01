import java.rmi.*;
import java.rmi.server.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdderRemote extends UnicastRemoteObject implements Adder{
	static Connection c = null;
	static Statement stmt = null;
	AdderRemote() throws RemoteException {
		super();
	}
	public static void databaseInit() throws Exception{
		try {
			Class.forName("org.postgresql.Driver");
//			c = DriverManager.
//					getConnection("jdbc:postgresql://localhost:5432/test",
//							"postgres", "135243");
			c = DriverManager.
					getConnection("jdbc:postgresql://fanny.db.elephantsql.com:5432/pslcrwig",
							"pslcrwig", "RM6f-EGQhEaxPkGy0Iaa3MNdoE1bYU-s");
			c.setAutoCommit(false);
			stmt = c.createStatement();

		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public Student insert(int id, String name, String department, String gender, int age, int ad_year) throws Exception {
		databaseInit();
		String q = String.format("INSERT INTO student"
				+ " VALUES (%d, '%s', '%s', '%s',%d ,%d);",id,name,department,gender,age,ad_year);
		System.out.println(stmt.executeUpdate(q));
//		rs.close();
		stmt.close();
		c.commit();
		c.close();
		System.out.println("Insert Sucessfully");
		return new Student(id, name, department, gender, age, ad_year);
	}

	@Override
	public Student update(int id, String name, String department, String gender,int age, int ad_year) throws Exception {
		databaseInit();
//		ResultSet rs = stmt.executeQuery(
//				"select * from student where id = "+id+";");
		ArrayList<String> list = new ArrayList<>();
		String sql = "update student set ";
		if(name.length() != 0){
			list.add(String.format("name = '%s' ",name));
		}
		if(department.length() != 0){
			list.add(String.format("department = '%s' ",department));

		}
		if(gender.length() != 0){
			list.add(String.format("gender = '%s' ", gender));

		}
		if(age != 0){
			list.add(String.format("age = %d ", age));

		}
		if(ad_year != 0){
			list.add(String.format("ad_year = %d ",ad_year));

		}
		String[] temp = list.toArray(new String[list.size()]);
		String joins = String.join(",",temp);

		// if every field is empty then do nothing
		if(joins.length() == 0){
			stmt.close();
			c.close();
			return new Student(id, name, department, gender, age, ad_year);
		}
		sql += joins;
		sql += String.format("where id = %d;",id);
		System.out.println(sql);
//		String sql = String.format("update student set name = '%s', department = '%s', gender = '%s', age = %d, ad_year = %d where id = %d;"
//				,name,department,gender,age, ad_year,id);
		stmt.executeUpdate(sql);
		c.commit();
		stmt.close();
		c.close();
		return new Student(id, name, department, gender, age, ad_year);
	}
	@Override
	public int delete(int id) throws Exception {
		databaseInit();
		String sql = "delete from student where id = "+id+";";
		stmt.executeUpdate(sql);
		c.commit();
		c.close();
		return id;
	}
	@Override
	public List<Student> search() throws Exception {
		databaseInit();
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
		rs.close();
		stmt.close();
		c.close();
		return li;
	}
}