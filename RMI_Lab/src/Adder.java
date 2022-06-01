// Student (Id, name, dept, gender, age, ad_year)
import java.rmi.*;
import java.util.List;

public interface Adder extends Remote{
	public Student insert(int id, String name, String department, String gender, int age, int ad_year) throws Exception;
	public Student update(int id, String name, String department, String gender,int age, int ad_year) throws Exception;
	public int delete(int id) throws Exception;
	public List<Student> search() throws Exception;
}