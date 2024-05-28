let ind =Number(0);
let epa = Number(0.0001)
while(epa<400){
    epa = epa * 2;
    ind++;
}
console.log(ind);

let ind2 =Number(0);
let epa2 = Number(400)

while(epa2>0.0001){
    epa2/=2
    ind2++
}
console.log(ind2);