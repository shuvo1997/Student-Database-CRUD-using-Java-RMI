import java.util.ArrayList;

public class DatabaseInit {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("dasdsa");
        list.add("asdsa");
        String[] arr = list.toArray(new String[list.size()]);
        System.out.println(arr[0]);
    }
}
