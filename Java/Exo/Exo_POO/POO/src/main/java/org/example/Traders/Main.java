package org.example.Traders;

import java.util.*;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 400),
                new Transaction(brian, 2012, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 410),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

        System.out.println(" Question 1  : ");

        List<Transaction> exo1 = transactions.stream()
                .filter(p -> p.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .toList();

        exo1.stream().forEach(System.out::println);

        System.out.println(" Question 2 : ");

        List<String> exo2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .toList();
        exo2.stream().forEach(System.out::println);

        System.out.println(" Question 3 : ");
        String Toto;

        List<String> exo3 = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .toList();
        exo3.stream().forEach(System.out::println);

        System.out.println(" Question 4 : ");

        Optional<Transaction> milan = transactions.stream()
                .filter(p -> p.getTrader().getCity().equals("Milan"))
                .findFirst();
        System.out.println(milan.isPresent());

        System.out.println(" Question 5 : ");

        Optional<Integer> exo5 = transactions.stream()
                .map(transaction -> transaction.getValue())
                .sorted(Comparator.reverseOrder())

                .findFirst();
        exo5.stream().forEach(System.out::println);

        System.out.println(" Question 6 : ");

        List<Trader> exo6 = transactions.stream()
                .filter(p -> p.getTrader().getCity().equals("Cambridge")).map(transaction -> transaction.getTrader())
                .distinct()
                .toList();
        exo6.stream().forEach(System.out::println);

        System.out.println(" Question 7 : ");

        List<Integer> exo7 = transactions.stream()
                .filter(p -> p.getTrader().getCity().equals("Cambridge")).map(transaction -> transaction.getValue())
                .distinct()
                .toList();
        exo7.stream().forEach(System.out::println);

        System.out.println(" Question 8 : ");

        Optional<Transaction> exo8 = transactions.stream()
                .filter(p -> p.getTrader().getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(transaction -> transaction.getValue()))
                .distinct()
                .findFirst();
        exo8.stream().forEach(System.out::println);



    }
}
