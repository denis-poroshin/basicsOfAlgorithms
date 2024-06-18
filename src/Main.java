import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        StringListIml stringListIml = new StringListIml(10);
        stringListIml.add("1");
        stringListIml.add("2");
        stringListIml.add("3");
        stringListIml.add("4");
        stringListIml.add(1, "10");
        stringListIml.remove("1");
        stringListIml.toArray();







//        System.out.println(stringListIml.remove(0));
//        for (int i = 0; i < stringListIml.size(); i++) {
//            System.out.println(stringListIml.get(i));
//
//        }


//        stringListIml.add(1, "5");
//        for (int i = 0; i < stringListIml.size(); i++) {
//            System.out.println(stringListIml.get(i));
//
//        }
//        String [] arrayOriginal = new String[5];
//        arrayOriginal[0] = "2";
//        System.out.println(arrayOriginal.length);
    }
}