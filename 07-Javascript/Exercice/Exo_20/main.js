const verificationAdn = (chaine) => {
    for (let i = 0; i < chaine.length - 1; i++) {
        if ((chaine.charAt(i).toLowerCase() != 'a') && (chaine.charAt(i).toLowerCase() != 't') && (chaine.charAt(i).toLowerCase() != 'c') && (chaine.charAt(i).toLowerCase() != 'g')) {

            return (false);
        }
    }
    return (true);
}

const saisieAdn = () => {
    chaine = prompt("Veuillez entrer une séquence D'adn");
    let verif = verificationAdn(chaine);

    while (verif == false) {

        console.log("Veuillez entrer une chaine valide");
        chaine = prompt("Veuillez entrer une séquence D'adn valide");
        verif = verificationAdn(chaine);
        console.log(verif);

    }
    return (chaine);
}

const proportion = (chaine, sequ) => {
    let regex = new RegExp(sequ, "g")
    let occurrences = chaine.match(regex)?.length ?? 0
    let pourcentage = occurrences * sequence.length / chaine.length * 100
    return (pourcentage);

}
alert("Veuillez entrer une chaine d'ADN")
let chaineAdn = saisieAdn();
alert("Veuillez entrer une sequence d'ADN")
let sequence = saisieAdn();
chaineAdn = chaineAdn.toLowerCase()
sequence = sequence.toLowerCase()
console.log("Il y a "+proportion(chaineAdn, sequence)+" % de " + sequence + " dans la chaine "+chaineAdn);
