import Personnage from "./Personnage.js";

export default class Guerrier extends Personnage {

    force;
    armure;

    constructor(nom, force, vie, armure) {
        super(nom, vie)
        this.force = Number(force)
        this.armure = Number(armure);
        this.vie = Number(vie) + Number(armure);
    }

    resumer() {
        console.log(this.nom + " " + this.vie + " " + this.force + " " + this.armure);
    }

    attaquer(cible) {
        if (cible.vie > 0) {
            cible.vie = cible.vie - (this.force + this.armure)
            if (cible.vie < 0) {
                console.log(`${cible.nom} n'as plus de vie ce qui la met hors course `);
            }
        }else{
            console.log("Vous ne pouvez pas attaquer une cible qui a moins de 1 PV");
        }

    }
}