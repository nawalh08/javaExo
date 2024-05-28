import Personnage from "./Personnage.js";

export default class Mage extends Personnage{
    
    force;
    mana;

    constructor(nom , force, vie,mana) {
        super(nom,vie)
        this.force = Number(force)
        this.mana = Number(mana);
    }

    resumer(){
        console.log(this.nom +" "+ this.vie+" "+this.force+" "+this.mana);
        console.log("Mana"+ this.mana);
        console.log("Force"+ this.force);
    }

    attaquer(cible){
        if (cible.vie > 0) {
            cible.vie = cible.vie-(this.force+this.mana)
            console.log(cible.vie);
            if (cible.vie < 0) {
                console.log(`${cible.nom} n'as plus de vie ce qui la met hors course `);
            }
        }else{
            console.log("Vous ne pouvez pas attaquer une cible qui a moins de 1 PV");
        }
        
        
    }
    soin(cible){
        cible.vie = cible.vie+this.mana;
        
    }
}