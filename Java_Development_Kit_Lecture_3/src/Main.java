import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(4, 2, 3);
        List<String>    strs = Arrays.asList("111", "xxxx", "aaaa");
        List<? extends Comparable> comps = ints;
        comps = strs;
    }


}

