let valeur = [10];

for(let i = 0 ; i<10;i++){
    valeur[i] = prompt(`Veillez entrer la ${i+1} valeur`)
}

for(let j = 0 ; j<valeur.length;j++){
    let tabul ="   "
    console.log(tabul.repeat(j) + valeur[j]);
}



