package Jeu.Classe;

public abstract class  Batiment {

    private String style;

    private double taille;



    public Batiment(BatimentBuilder builder) {
        this.taille = builder.taille;
        this.style = builder.style;

    }

    public abstract static class BatimentBuilder {

        private String style;
        private double taille;


        public BatimentBuilder setStyle(String style) {
            this.style = style;
            return this;
        }

        public BatimentBuilder setTaille(double taille) {
            this.taille = taille;
            return this;
        }



        public abstract Batiment build();

    }

    @Override
    public String toString() {
        return "Batiment{" +
                "style='" + style + '\'' +
                ", taille=" + taille
                ;
    }
}
