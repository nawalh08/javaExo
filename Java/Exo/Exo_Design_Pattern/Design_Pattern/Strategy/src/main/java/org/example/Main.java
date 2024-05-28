package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        NavigationSystem n = NavigationSystem.builder().destination("Roubaix").build();
        n.travel(new OffRoeadStrategy());
        n.travel(new RoadStrategy());
        n.travel(new EconomicStrategy());
    }
}