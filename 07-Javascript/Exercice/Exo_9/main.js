let userValue = Number(prompt("Veuillez entrez la valeur de N"))
let longueur= Number(0);

for(let i=1;i<=userValue;i++){
    console.log("Table des " + i + " : \n");
    for(let j=1;j<11;j++){
        console.log(`${i} * ${j} = ${i*j}`);
    }
    console.log("\n");
}

let result = '';
for(let toto= 1;toto<52;toto++){
    result +=('-');
}
for (let i = 0; i <= userValue; i++) {

    
    for (let j = 0; j < 11; j++) {
        if(j==0 && i==0){
            result+='\n'
            for(let toto= 1;toto<11;toto++){
                const tmp=`${toto}`;
            const tmp2 = tmp.padStart(4,' ');
                result +=('|'+tmp2);
                if(toto==10){
                    result+='|'
                    longueur=result.length-52
                }
            }
            
            }
       
        
        else if(i>0 && j>0){
            const tmp=`${i*j}`;
            const tmp2 = tmp.padStart(4,' ');
        result += '|'+tmp2 ;
        if(j==10){
            result+='|'
        }
        }
        
    }
    result += '\n'
    for(let toto= 1;toto<longueur+1;toto++){
        result +=('-');
    }
    result += '\n'
}
console.log(result);