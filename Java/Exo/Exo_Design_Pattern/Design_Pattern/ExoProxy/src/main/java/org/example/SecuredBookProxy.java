package org.example;

public class SecuredBookProxy implements Book{


    private RealBook RealBook =  new RealBook("Toto","Ce livre raconte des blagues de toto");;


    public SecuredBookProxy(RealBook realBook) {

        this.RealBook = realBook;
    }

    @Override
    public void readBook(boolean isUserPremium){
        if(isUserPremium){
            RealBook.readBook(isUserPremium);
        }else {
            throw new RuntimeException("Not Allowed");
        }




    };



}
