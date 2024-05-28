function getRandomInt(max) {
    return Math.floor(Math.random() * max);
  }
  
  

  let taille = prompt("Veuillez entrer le nombre de valeur que vous souhaiter avoir")
  let valeur = [];
  for(let i = 0;i<taille;i++){
    valeur[i]=getRandomInt(50);
  }
  for(let j =0;j<valeur.length;j++){
    if(valeur[j]%2==0){
        console.log(`Le nombre ${String(valeur[j]).padStart(3,' ')} est   pair`);
    }else{
        console.log(`Le nombre ${String(valeur[j]).padStart(3,' ')} est impair`);
    }
  }