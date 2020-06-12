import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.System.*;

/**
 * @Author 吴典秋
 * @Date 2020/5/31 18:56
 * @Description:
 * @Version 1.0
 */

public class Demo1 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("waibizi hello","aixuexi welcome","haha");

        words.stream().filter(item->item.length()>5).forEach(System.out::println);
        words.stream().map(item->item.toUpperCase()).forEach(System.out::println);
        words.stream().map(item->item.split(" ")).flatMap(Arrays::stream).forEach(System.out::println);

    }
}
