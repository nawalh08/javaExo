package org.example.entity;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String contenu;
    private Date date ;
    private String note;

@oneToMany(mappedBy = "commentaire")
    private List<Produit> produits = new ArrayList<>();


}
