import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetTask {
    public static void hashSet(){

        Set<Integer> set1 = new HashSet<>(); // creation of set1

        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);
        set1.add(6);
        set1.add(7);
        set1.add(8);
        set1.add(14);

        System.out.println(set1);

        set1.remove(1);

        for (int num : set1){
            if (num % 7 == 0) {
                System.out.println(num + " is divisible by 7.");
            }
        }
    }
}
