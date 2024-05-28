const insererValDef = (tabDef) => {
  let tailleTabDef = prompt("Combien de notes")
  for (let i = 0; i < tailleTabDef; i++) {
    let tmp = Number(prompt("Veuillez entrer une note comprise entre 0 et 20"));
    while (tmp < 0 || tmp > 20 || tmp === NaN) {
      alert("Veuillez entrer une valeur correcte")
      tmp = Number(prompt("Veuillez entrer une note comprise entre 0 et 20"));
    }
    tabDef[i] = tmp
  }
  return (tabDef);
}
const insererValPerm = (tabPerm) => {
  let cpt = 0;
  let tmp = 1;
  while (tmp >= 0) {
    tmp = Number(prompt("Veuillez entrer une note comprise entre 0 et 20"));
    while (tmp > 20) {
      alert("Veuillez entrer une valeur correcte")
      tmp = Number(prompt("Veuillez entrer une note comprise entre 0 et 20"));

    }
    if (tmp >= 0) {
      tabPerm[cpt] = tmp
      cpt++
    }
  }
  return (tabPerm)
}
const affichage = (tab) => {
  let min = Number(20), max = Number(0), tmp, somme = Number(0);
  for (let i = 0; i < tab.length; i++) {
    tmp = Number(tab[i]);
    if (tmp > max) {
      max = tmp
    }
    if (tmp < min && tmp != -1) {
      min = tmp;
    }
    somme += tmp;
  }
  somme = somme / tab.length;

  alert(`La note maximale est de ${max} / 20 \nLa note minimale est de ${min} / 20 \nLa moyenne est de ${somme} / 20`)
}

const menu = () => {
  let choix = Number(prompt("Veillez entrer votre choix \n 1 : Saisie fixe \n 2 : Saisie jusqu'a note négative"));
  switch (choix) {
    case (1):
      insererValDef(tabDef1);
      alert("Fin de Saisie !")
      affichage(tabDef1)
      break;
    case (2):
      insererValPerm(tabPerm1);
      alert("Fin de Saisie !");

      affichage(tabPerm1);
      break;
    default:
      alert("Erreur de saisie ! Réssayez")
      return
  }
}
let tabDef1 = [];
let tabPerm1 = [];
while (true) {
  menu();

}
