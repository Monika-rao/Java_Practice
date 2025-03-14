package org.example.Java8;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Assignment1 {

    public void firstnonRepeatedCharInString(){
        String input = "Java articles are Awesome".replaceAll("\\s","").toLowerCase();
        Arrays.stream(input.split("")).forEach(System.out::print);

        System.out.println(Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet().stream()
                .filter(i->i.getValue()==1).map(Map.Entry::getKey).findFirst().get());
    }

    public void firstRepeatedCharInAString(){
        String input = "You are going good, just little bit more improvement is required".replaceAll("\\s+","").toLowerCase();

        Set<Character> seen = new HashSet<>();

        System.out.println(IntStream.range(0, input.length())
                .mapToObj(input::charAt)
                .filter(c -> !seen.add(c))
                .findFirst().get());

    }

    public void duplicateValues(){
        List<Integer> list = Arrays.asList(1, 2, 3, 3, 4, 4, 4, 5, 5);
        Set<Integer> set = new HashSet<>();

        System.out.println(list.stream().filter(i -> !set.add(i)).collect(Collectors.toSet()));
    }

    public void pallindrome(){
        String str = "Jahaj".toLowerCase();

        System.out.println(IntStream.range(0, str.length() / 2).allMatch(i -> str.charAt(i) == str.charAt(str.length() - i - 1)));
    }

    public void maxAndmin(){
        int[] nums = {1,33,4,5,5,6,6,2};

        System.out.println(Arrays.stream(nums).max());
        System.out.println(Arrays.stream(nums).min());

        //Arrays.stream(nums).max(Integer::compare);
    }

    public void secondHighestNumber(){
        int[] numbers = {2,45,67,77,34};
        System.out.println(Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).skip(1).findFirst());
    }

    public void secondLowestNumber() {
        int[] numbers = {2, 45, 67, 77, 34};

        System.out.println(Arrays.stream(numbers).boxed().sorted(Comparator.naturalOrder()).mapToInt(Integer::intValue)
                .skip(1).findFirst());
    }

    public void currentDateAndTime(){
        LocalDate current_Date = LocalDate.now();
        LocalTime current_Time = LocalTime.now();
        System.out.println(current_Date + "," +current_Time);
    }

    public void first10EvenNum(){
//        IntStream.rangeClosed(0,10).filter(n->n%2==0).limit(10).forEach(System.out::println);

        IntStream.range(0, 10)
                .map(n -> n * 2)
                .forEach(System.out::println);
    }

    public void first10OddNumber(){
        IntStream.range(0,10).map(n->n*2+1).forEach(System.out::println);
    }

    public void uniqueElements() {
        List<Integer> list = Arrays.asList(1, 4, 4, 6, 6, 7, 8,10,11);
        Set<Integer> set = new HashSet<>();

        list.stream().distinct().filter(n->String.valueOf(n).startsWith("1")).forEach(System.out::println);

        list.stream().filter(n->!set.add(n)).forEach(System.out::println);

    }

    //Given an integer List nums,
    //return true if any value appears at least twice in the array, and return false if every element is distinct.

    public void check2Times(){
        int[] nums = {1,2,3,4,5};
        Set<Integer> seen = new HashSet<>();

        System.out.println(Arrays.stream(nums).anyMatch(n -> !seen.add(n)));

    }

    // Write a program to sum a list - initial value is 100. for ex 100+ (sum_of_elements)
    public void sumList(){
        List<Integer> list = Arrays.asList(1,2,3,4,4,5);

        int intVal = 100;

        System.out.println(list.stream().reduce(intVal, Integer::sum));

        System.out.println(list.stream().count()); //count
    }

    public void secondHighestNumFromList(){
        List<Integer> list = Arrays.asList(1,2,3,4,4,5);

        System.out.println(list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst());
    }


    //Given a list of Strings, write a Java 8 program that finds the first non-empty string
    // using Optional. If no such string is found, return a default value.

    public void firstNoEmptyString(){
        List<String> list = Arrays.asList("sadc","qweasdf", "ads");
        String defaultVal = "Default value";

        list.stream().filter(s->s!=null && !s.trim().isEmpty()).findFirst().orElse(defaultVal);
    }

    public static void main(String[] args) {
        Assignment1 assignment1 = new Assignment1();
//        assignment1.firstnonRepeatedCharInString();
        assignment1.firstRepeatedCharInAString();
//        assignment1.duplicateValues();
//        assignment1.pallindrome();
//        assignment1.secondHighestNumber();
//        assignment1.maxAndmin();

//        assignment1.currentDateAndTime();
//        assignment1.first10EvenNum();
//        assignment1.first10OddNumber();
//        assignment1.uniqueElements();
//        assignment1.check2Times();

//        assignment1.sumList();
//        assignment1.secondHighestNumFromList();
//        assignment1.firstNoEmptyString();
    }


}
