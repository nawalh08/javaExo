package org.example.Papeterie;

public class Lot extends Article{

    public int qte;

    public double remise;



    public Lot(int reference,int qte,double remise) {
        super(reference);
        this.qte = qte;
        this.remise = remise;
    }
}
