package io.codewithgx.functional.programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 18/09/2022
 */

public class DownStreamCollectorsInAction {
    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources/EmployeeData.txt");

        try (final Stream<String> lines = Files.lines(path);) {
            final Spliterator<String> lineSpliterator = lines.flatMap(line -> Arrays.stream(line.split(",")))
                    .spliterator();

            Spliterator<Employee> employeeSpliterator = new EmployeeSpliterator(lineSpliterator);

            final List<Employee> employeeList = StreamSupport.stream(employeeSpliterator, false).toList();

            final Map<String, Long> getByDesignationCount = employeeList.stream()
                    .collect(
                            Collectors.groupingBy(
                                    Employee::getDesignation,
                                    Collectors.counting()
                            )
                    );

            getByDesignationCount.forEach((k, v) -> System.out.printf("%s: %s%n", k, v));


            System.out.println("---------------------Total Fund Distributed Among Designation");
//            final Map<String, DoubleSummaryStatistics> getByDesignationAndSumSalary = employeeList.stream()
            final Map<String, Double> getByDesignationAndSumSalary = employeeList.stream()
                    .collect(
                            Collectors.groupingBy(
                                    Employee::getDesignation,
//                                    Collectors.summarizingDouble(Employee::getSalary)
                                    Collectors.summingDouble(Employee::getSalary)
                            )
                    );

            getByDesignationAndSumSalary.forEach((k, v) -> System.out.printf("%s: %s%n", k, v));

            Map<String, Optional<Employee>> maxByEmployee = employeeList.stream()
                    .collect(Collectors.groupingBy(
                            Employee::getDesignation,
                            Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                    ));

            maxByEmployee.forEach((k, v) -> System.out.printf("%s: %s%n", k, v));


        } catch (final IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
