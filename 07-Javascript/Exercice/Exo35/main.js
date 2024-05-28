import Personnage from "./classes/Personnage.js";
import Guerrier from "./classes/guerrier.js";
import Mage from "./classes/mage.js";

let Vergil = new Personnage("Vergil","25","10");
let Dante = new Personnage("Dante","25","10");
Vergil.resumer();

console.log("Vergil attaque son frère Dante et lui retire " + Vergil.force+"Ce qui laisse à Dante : ");
Vergil.attaquer(Dante);
console.log(Dante.vie + " PV");
let Guts = new Guerrier("Guts","10","25","3")

let Griffith = new Personnage("Griffith","33","10")

Guts.attaquer(Griffith)
console.log("Guts attaque Griffith ce qui lui laisse " + Griffith.vie + " PV");
let Riveira = new Mage("Riveria","15","18","13")

console.log("Riveira soigne Griffith ce qui lui remet à ");
Riveira.soin(Griffith)
console.log(Griffith.vie+ " PV");

console.log("Riveira attaque Vergil ce qui lui laisse uniquement " + (Number(Vergil.vie)-Number(Riveira.force+Riveira.mana)) + " PV");
Riveira.attaquer(Vergil)