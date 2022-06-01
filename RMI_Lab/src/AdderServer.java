import java.rmi.*;
import java.rmi.registry.*;

public class AdderServer {
    public static void main(String[] args) {
        try{
            Adder stub = new AdderRemote();
            Naming.rebind("rmi://localhost:9000/shovon",stub);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}