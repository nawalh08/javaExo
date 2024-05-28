let age,sal,exp,message,isPossible;

age = Number(prompt("Veuillez entrer votre âge"));


message="";
if(age>30){
    sal = Number(prompt("Veuillez entrer le salaire maximum que vous prétendez"));
    if(sal<40000){
        exp = Number(prompt("Veuillez entrer votre nombre d'années d'experience"));
        if(exp>5){
            isPossible = true;

        }else{
            message+=" Vous n'avez pas assez d'exprience dans le domaine"
        }
    }else{
        message +="Le salaire demandé est trop haut"
    }
}else{
    message += " Le poste est pour les personnes agée de plus de 30 ans"
}

if(isPossible==true){
    message="Votre profil est éligible pour le poste nous vous recontacteront plus tard"
}
console.log(message);