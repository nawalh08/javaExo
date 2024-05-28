let val=Number(prompt("Veuillez indiquer le nombre choisi"));
let message ="";
let tmp=Number(0);

for(let i =1;i<val/2+1;i++){
    message=`${val} = `;
    tmp=0;
    for(let j = i; j<val/2+1;j++){
        tmp+=j
        if(j!=i){
            message+=" +";
        }
        message+=(` ${j}`)
        
        if(tmp==val){
            console.log(message)
            }
    }     
    
}
