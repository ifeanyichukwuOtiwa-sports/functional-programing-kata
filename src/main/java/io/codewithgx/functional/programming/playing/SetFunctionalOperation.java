package io.codewithgx.functional.programming.playing;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 18/09/2022
 */

public class SetFunctionalOperation {
    public static void main(String[] args) {
        Set<Integer> setOfIntegers = Set.of(3, 56, 7, 82, 39);

        setOfIntegers.forEach(System.out::println);

        System.out.println("------------------------------------");
        setOfIntegers.stream()
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);

        System.out.println("------------------------------------");

        setOfIntegers.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("------------------------------------");

        setOfIntegers.stream()
                .map(Double::valueOf)
                .collect(Collectors.toSet()).forEach(System.out ::println );
        System.out.println("------------------------------------");

        final SortedSet<Integer> sortedSet = setOfIntegers.stream()
                .collect(Collectors.toCollection(TreeSet::new));

        sortedSet.forEach(System.out::println);

        System.out.println("------------------------------------");

        final Integer sum = sortedSet.stream().mapToInt(e -> e).sum();

        System.out.println(sum);
    }
}
