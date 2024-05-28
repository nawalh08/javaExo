import Chat from "./chat.js";
import Chien from "./chien.js";
let Animaux =[];
let id=2;




function getNewCat() {

    var catName = document.getElementById("CatName").value;
    var catAge = document.getElementById("CatAge").value;
    let Cat = new Chat(catName,catAge)
    console.log(Cat);
    Animaux.push(Cat)
    var table = document.getElementById("myTable");
    var row = table.insertRow(-1);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    
    cell1.innerHTML = id;
    cell2.innerHTML = catName;
    cell3.innerHTML = (catAge+" Ans");
    
    id++;
}


function getNewDog() {

    var dogName = document.getElementById("DogName").value;
    var dogAge = document.getElementById("DogAge").value;
    let dog = new Chien(dogName,dogAge)
    console.log(dog);
    Animaux.push(dog)
    var table = document.getElementById("myTable");
    var row = table.insertRow(-1);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    
    cell1.innerHTML = id;
    cell2.innerHTML = dogName;
    cell3.innerHTML = (dogAge+" Ans");
    
    id++;
}

function AffTab(){
    console.log(Animaux);
}

document.getElementById("btnsubmitCat").addEventListener("click",getNewCat)
document.getElementById("btnsubmitDog").addEventListener("click",getNewDog)
document.getElementById("Aff").addEventListener("click",AffTab)