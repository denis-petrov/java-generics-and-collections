package com.app.part1.chapter1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxingUnboxing {

    public static void main(String[] args) {
        var ints = IntStream.range(0, 10000000)
                .boxed()
                .collect(Collectors.toList());

        var startTime = System.nanoTime();
        sum(ints);
        var endTime = System.nanoTime();
        System.out.println("sum(ints): " + (endTime - startTime));

        startTime = System.nanoTime();
        sumStream(ints);
        endTime = System.nanoTime();
        System.out.println("sumStream(ints): " + (endTime - startTime));

        startTime = System.nanoTime();
        sumUnboxed(ints);
        endTime = System.nanoTime();
        System.out.println("sumUnboxed(ints): " + (endTime - startTime));
    }

    private static int sum(List<Integer> ints) {
        int res = 0;
        for (int curr : ints) {
            res += curr;
        }
        return res;
    }

    private static int sumStream(List<Integer> ints) {
        return ints.stream()
                .mapToInt(e -> e)
                .sum();
    }

    private static Integer sumUnboxed(List<Integer> ints) {
        Integer res = 0;
        for (Integer curr : ints) {
            res += curr;
        }
        return res;
    }
}
