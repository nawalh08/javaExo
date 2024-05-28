function soustraire(a,b){
    let res = Number(a)-Number(b);
    return(`Je soustrais ${a} de ${b} ce qui donne ${res}`);
}
let prem=Number(prompt("Veuillez indiquer le premier chiffre"));
let seco=Number(prompt("Veuillez indiquer le second chiffre"));
console.log(soustraire(prem,seco));