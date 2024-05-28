export default class Personnage{
    nom;
    vie;
    force;

    constructor(nom,vie,force) {
        this.nom = nom;
        this.vie = vie;
        this.force = force
}

resumer(){
    console.log(this.nom + this.vie + this.force);
    
}

attaquer(cible){
    
    if (cible.vie > 0) {
        cible.vie = cible.vie - this.force;
        if (cible.vie < 0) {
            console.log(`${cible.nom} n'as plus de vie ce qui la met hors course `);
        }
    }else{
        console.log("Vous ne pouvez pas attaquer une cible qui a moins de 1 PV");
    }
}
    
}




  