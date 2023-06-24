package br.com.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Regular {

    @Test
    public void regular() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Rodrigo");
        names.add("João");
        names.add("Paulo");
        names.add("Julia");
        names.add("José");
        names.add("Ingrid");

        int count = 0;

        for (int i = 0; i < names.size(); i++){
            String actual = names.get(i);
            if (actual.startsWith("J")) {
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void streamFilter() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Rodrigo");
        names.add("João");
        names.add("Paulo");
        names.add("Julia");
        names.add("José");
        names.add("Roberta");

        /*1 - cria a stream
        * 2 - seleciona o método da stream
        * 3 - seleciona a operação terminal*/
        System.out.println(names.stream().filter(i -> i.startsWith("J")).count()); //Scaneia PARALELAMENTE

        names.stream()
                .filter(i -> i.length() > 6)
                .forEach(System.out::println); //i -> System.out.println(i) pode ser posto com Method Reference

        names.stream()
                .filter(i -> i.length() > 6)
                .limit(1) //limitará a pesquisa a 1 resultado
                .forEach(System.out::println);
    }

    @Test
    void streamCollection() {
        System.out.println(Stream.of("Rodrigo","João", "Paulo", "Julia", "José", "Roberta")
                .filter(i -> i.startsWith("R"))
                .count());
    }

    @Test
    void streamMap() {
        Stream.of("Rodrigo","João", "Paulo", "Julia", "José", "Roberta","Ingrid","Rapunzel","Renata")
                .filter(i->i.endsWith("o"))
                .map(String::toUpperCase) // i->i.toUpperCase() = String::toUpperCase
                .forEach(System.out::println);
        System.out.println();
    }

    @Test
    void streamList() {

        List<String> names = Arrays.asList("Rodrigo","João", "Paulo", "Julia", "José", "Roberta","Ingrid","Rapunzel","Renata");
        names.stream()
                .filter(i->i.startsWith("R"))
                .sorted()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @Test
    void concatList() {

        ArrayList<String> names = new ArrayList<>();
        names.add("Rodrigo");
        names.add("João");
        names.add("Paulo");
        names.add("Julia");
        names.add("José");
        names.add("Roberta");

        List<String> names1 = Arrays.asList("Rodrigo","João", "Paulo", "Julia", "José", "Roberta","Ingrid","Rapunzel","Renata");
        //Merging two different lists
        Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
//        newStream.sorted().forEach(System.out::println);
        boolean flag = newStream.anyMatch(i->i.equalsIgnoreCase("José"));
        System.out.println(flag);
        Assertions.assertTrue(flag);
    }

    @Test
    void streamCollect() {

        List<String> list = Stream.of("Rodrigo","João", "Paulo", "Julia", "José", "Roberta","Ingrid","Rapunzel","Renata")
                .filter(i->i.endsWith("o"))
                .map(String::toUpperCase)
                .toList(); // .collect(Collectors.toList());
        System.out.println(list.size());


        List<Integer> number = Arrays.asList(3,2,2,7,5,1,9,7);
//        number.stream().distinct().forEach(System.out::println); //distinct
        List<Integer> list1 = number.stream().sorted().distinct().toList();
        System.out.println(list1.get(2));


    }

}
