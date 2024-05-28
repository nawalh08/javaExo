let pop,taux,objectif,temps;
temps=Number(0);
pop=Number(prompt("Veuillez indiquez la population total actuelle"));
taux=Number(prompt("Veuillez indiquez le taux d'accroissement en pourcentage"));
objectif=Number(prompt("Veuillez indiquez la population que vous visée"));

while(pop < objectif){
    pop=(pop*(1+(taux/100)));
    console.log(pop);
    temps++
}

console.log(temps);
console.log(`Le nombre d'habitants qui seront dans la ville est de ${pop} et il faudra ${temps} d'années`);