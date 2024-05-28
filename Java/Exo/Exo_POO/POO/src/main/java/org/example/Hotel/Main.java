package org.example.Hotel;

import org.example.Hotel.Models.Client;

public class Main {

    public static void main(String[] args) {

        Client client1= new Client("Dries","Fares","0650979624");
        System.out.println(client1.toString());
        Client client2= new Client("Dries","Fares","0650979624");
        System.out.println(client2.toString());

    }
}
