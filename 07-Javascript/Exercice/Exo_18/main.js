
const palindrom =(mot)=>{
    console.log(mot);
    console.log(mot.length);
    let j =mot.length-1;
    let toto=true;
    for(let i=0;i<mot.length;i++){
        
        
        if(mot.charAt(i)!=mot.charAt(j)){
            
            toto=false;
        }
        j--;
    }
    if(toto==false){
        console.log(`Le mot ${mot} n'est pas un palindrome`);
    }else{
        console.log(`Le mot ${mot} est un palindorome`);
    }
}
let mot=prompt("Veuillez entrer votre mot")
console.log(mot.length);
palindrom(mot);