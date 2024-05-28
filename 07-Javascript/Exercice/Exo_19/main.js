const compterLettreA =(mot)=>{
    let num = Number(0);
    for(let cpt =0;cpt<mot.length;cpt++){
        if(mot.charAt(cpt).toLowerCase()=='a'){
            num++;
        }
        
    }
    return num;
}

let mot = prompt("Veuillez entrer votre mot");
console.log(compterLettreA(mot));