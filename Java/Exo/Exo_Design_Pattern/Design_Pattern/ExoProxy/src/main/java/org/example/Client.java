package org.example;

public class Client {
    public static void main(String[] args) {

        RealBook toto = new RealBook("Toto","Ce livre raconte des blagues de toto");

        SecuredBookProxy securedBookProxy = new SecuredBookProxy(toto );
        System.out.println("Test avec true");
        securedBookProxy.readBook(true);
        System.out.println("Test avec false");
        securedBookProxy.readBook(false);




    }
}
