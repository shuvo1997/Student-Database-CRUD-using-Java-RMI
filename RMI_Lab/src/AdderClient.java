import java.rmi.*;
import java.util.List;

public class AdderClient {
    public static void main(String[] args) {
        try {
            Adder stub = (Adder) Naming.lookup("rmi://localhost:9000/shovon");
            System.out.println(stub.update(79, "", "", "", 0, 0));
//            System.out.println(stub.insert(91, "Hredoy", "CSE", "Male", 23, 2017));
//            System.out.println(stub.delete(3));
            List<Student> list = stub.search();
            list.forEach(System.out::println);
//            list = stub.search();
//            list.forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
