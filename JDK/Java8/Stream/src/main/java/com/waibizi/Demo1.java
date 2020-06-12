package com.waibizi;

import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

/**
 * @Author 吴典秋
 * @Date 2020/5/28 13:56
 * @Description:
 * @Version 1.0
 */

public class Demo1 {
    public static void main(String[] args) {
        //创建一个六个元素的Stream数组，1为开头，每个数步伐是2
        Stream<Integer> stream = Stream.iterate(1,item->item+2).limit(6);

        stream.filter(item->item>2).mapToInt(item->item*2).skip(2).max().ifPresent(System.out::println);

        IntSummaryStatistics summaryStatistics =
                stream.filter(item->item>2).mapToInt(item->item*2).skip(2).limit(2).summaryStatistics();

        System.out.println(summaryStatistics.getAverage());
    }
}
