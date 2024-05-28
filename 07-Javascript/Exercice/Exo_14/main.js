function greet(firstname,lastname){
    let tmp1,tmp2;
    tmp1=firstname.charAt(0).toUpperCase();
    tmp1+=firstname.substr(1).toLowerCase();
    tmp2=lastname.charAt(0).toUpperCase();
    tmp2+=lastname.substr(1).toLowerCase();
    return(`${tmp1} ${tmp2}`)
}

let pren = prompt("Entrer votre prénom");
let nom = prompt("Entrer votre nom");

console.log(greet(nom,pren)); 