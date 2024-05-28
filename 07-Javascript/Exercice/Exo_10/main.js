let x = 5; let res ='';
for (let i = 0; i < x; i++) {
   for (let j=x-1; j>i; j--) {
      res+=(" "); 
   }
   for (let k=0; k<=(i*2); k++) {
      res+=("*"); 
   }
   res+=("\n");
}

console.log(res);