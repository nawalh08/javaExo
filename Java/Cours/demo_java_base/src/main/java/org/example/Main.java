package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int toCelcius(int temp){
        return ((temp-32)*5)/9;
    }
    public static int toFareinheit(int temp){
        return ((temp* 9/5) + 32);
    }
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int result = toCelcius(5);
        int result2 = toFareinheit(5);
        System.out.println(result);
        System.out.println(result2);

        }

        //Exercice2


}