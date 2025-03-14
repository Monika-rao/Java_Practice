package org.example.Java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Assignment2 {

    List<Integer> list = Arrays.asList(1,3,456,78,86);

    //Write a Java 8 program that converts a List of strings into a Map
    // where the key is the string’s length and the value is the list of strings of that length.
    public void covertListOfStringsToMap(){
        List<String> list = Arrays.asList("asdf","sadf","ddefg");

        Map<Integer,List<String>> map = list.stream().collect(Collectors.groupingBy(String::length));

        for(Map.Entry<Integer,List<String>> entry :map.entrySet()){
            Integer length = entry.getKey();
            List<String> value = entry.getValue();

            System.out.println("Length : "+length +"-> "+value);
        }
    }

    //Write a Java 8 program that calculates the sum of all the numbers in a list using the reduce() method.
    public void sumByreduce(){
        System.out.println(list.stream().reduce(0, Integer::sum));
    }

    //Given a list of Person objects with attributes name and age,
    // write a Java 8 program that groups the persons by age and prints the result.

    public void groupEmpByAge(List<Employee> employeeList){
        System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getAge)));
    }

    //Write a Java 8 program that sorts a list of Employee objects by their salary using method references.
    public void sortBySalary(List<Employee> employeeList){
        System.out.println(employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).collect(Collectors.toList()));
    }

    public void getEmployeeAge(List<Employee> employeeList){
        System.out.println(employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getAge,
                        Collectors.mapping(Employee::getName, Collectors.toList()))));

        System.out.println(employeeList.stream().map(Employee::getSalary).sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    }

    public void flattenList(){
        List<List<Integer>> list = Arrays.asList(Arrays.asList(34,6,76,765));
        System.out.println(list.stream().flatMap(List::stream).collect(Collectors.toList()));
    }

    public void partitionInto2Categories(){
        List<Integer> list = Arrays.asList(1,3,4,5,6,8,9);

        System.out.println(list.stream().collect(Collectors.partitioningBy(n -> n % 3 == 0)));
    }

    public void comibiningTheList(){
        List<Integer> list1 = Arrays.asList(1,3,4,5,6,8,9);
        Stream<Integer> stream1 = list1.stream();
        List<Integer> list2 = Arrays.asList(1,3,4,5,6,8,9);
        Stream<Integer> stream2 = list2.stream();
        List<Integer> list3 = Arrays.asList(1,3,4,5,6,8,9);

        System.out.println(Stream.concat(stream1, stream2).distinct().sorted());

    }

    //Given a list of Strings, write a Java 8 program that finds the first non-empty string using Optional. If no such string is found, return a default value.

    public void nonEmptyString(){
        List<String> list = Arrays.asList("sd","Sdf","sdfdfv","");
        String defaultVal = "default";

        list.stream().filter(i->i!=null && !i.trim().isEmpty()).findFirst().orElse(defaultVal);
    }

    public void mergeTwoLinkedList(){
        List<Integer> list1 = List.of(1,244,56);
        List<Integer> list2 = List.of(3,6,5);

        Stream.concat(list1.stream(),list2.stream()).sorted().collect(Collectors.toCollection(LinkedList::new));

    }

    //Write a Java 8 program that computes the sum of squares of all integers
    // in a large list using parallel streams. Compare the performance (execution time) with sequential streams.
    public void computeSumWithParallelStream() {
        List<Integer> list = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 10_000_000; i++) {
            list.add(random.nextInt(100));
        }

        //sequential sum
        long startTime = System.currentTimeMillis();
        int sequentialSum = list.stream().mapToInt(c->c*c).sum();
        long sequentialTime = System.currentTimeMillis() - startTime;

        //parallel sum
        startTime = System.currentTimeMillis();
        int parallelSum = list.parallelStream().mapToInt(c->c*c).sum();
        long parallelTime = System.currentTimeMillis() - startTime;

        System.out.println(sequentialSum+" ,"+sequentialTime);
        System.out.println(parallelSum+" ,"+parallelTime);

    }

    //Write a Java 8 program to sort an array and then convert the sorted array into Stream?
    public void convertSortedArrayIntoStream(){
        int[] arr = {1,5,7,8,4};

        IntStream.of(arr).sorted().boxed().forEach(System.out::print);
    }

    //How to count each element/word from the String ArrayList in Java8?
    public void countWordFromString(){
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");

//        Map<String,Long> result =names.stream().collect(Collectors.groupingBy(,String::length));  on hold

//        System.out.println(result); on hold
    }
    //List<String> names = Arrays.asList("AA", "BB", "AA", "CC");

    
    //.Group by a List and display the total count of it in ascending order
    public void countInAscending(){
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(System.out::println);

    }
        
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(24,"Monty",21343));
        employeeList.add(new Employee(25,"Moni",2135456));
        employeeList.add(new Employee(26,"Monika",13454356));


        Assignment2 assignment2 = new Assignment2();

//        assignment2.sumByreduce();
//        assignment2.groupEmpByAge(employeeList);
//        assignment2.sortBySalary(employeeList);

//        assignment2.groupEmpByAge(employeeList);

        assignment2.countInAscending();


//        assignment2.covertListOfStringsToMap();
//        assignment2.flattenList();
//        assignment2.partitionInto2Categories();
//        assignment2.comibiningTheList();
//        assignment2.computeSumWithParallelStream();
//        assignment2.convertSortedArrayIntoStream();

//        assignment2.countWordFromString();



    }
}
