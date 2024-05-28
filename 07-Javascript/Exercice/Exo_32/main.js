import { MOVIES } from "./movies.js";
// Récuperer le  modal
var modal = document.getElementById("myModal");
let i = 5;
let movies = [...MOVIES]
var btn = document.getElementById("myBtn");

var span = document.getElementsByClassName("close")[0];


btn.onclick = function () {
    modal.style.display = "block";
}


span.onclick = function () {
    modal.style.display = "none";
}


window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

document.getElementById("form-save").addEventListener("click", function () {
    // Récupération des champs
    const title = document.getElementById("title").value;
    const year = document.getElementById("year").value;
    let index = i;

    if (title && year) {
        // Nouvelle ligne
        const movie = { title: title, year: year, index: index };

        // Ajout de la nouvelle ligne
        movies.push(movie);
        fetchOneMovie(movie)
        
        // Affichage du nouveau tableau
        console.log(movies);
        i++;
        
        
    }
});

function fetchAllMovies(movies) {
    
    movies.forEach((m) => {
        const newLIElement = document.createElement("li");
        newLIElement.textContent = m;
        // newLIElement.className = "vos classes"
        // newLIElement.classList.add("nouvelle-classe")
        newLIElement.setAttribute("data-demo-person-name", m);
        newLIElement.addEventListener("click", () => {
          newLIElement.remove();
        });
    
        
    
        const newTRElement = document.createElement("tr");
        const idTDElement = document.createElement("td");
        idTDElement.textContent = m.index;
        const nomTDElement = document.createElement("td");
        nomTDElement.textContent = m.title;
        const nameTDElement = document.createElement("td");
        nameTDElement.textContent = m.year;
        const actionsTDElement = document.createElement("td");
        const deleteBTNElement = document.createElement("button");
        deleteBTNElement.textContent = "Delete";
        deleteBTNElement.addEventListener("click", () => {
          
          newTRElement.remove()
          movies = movies.filter(m => m.index !== +idTDElement.textContent)
         console.log(idTDElement);
          console.log(movies.find(m => m.index === +idTDElement.textContent));
          console.log(movies);
        
        });
        actionsTDElement.appendChild(deleteBTNElement);
        newTRElement.appendChild(idTDElement);
        newTRElement.appendChild(nomTDElement);
        newTRElement.appendChild(nameTDElement);
        newTRElement.appendChild(actionsTDElement);
        document.getElementById("mon-tbody")?.appendChild(newTRElement);
      });
    ;

    // Affichage des éléments dans le HTML
    
}

function fetchOneMovie(m){
    const newTRElement = document.createElement("tr");
    const idTDElement = document.createElement("td");
    idTDElement.textContent = m.index;
    const nomTDElement = document.createElement("td");
    nomTDElement.textContent = m.title;
    const nameTDElement = document.createElement("td");
    nameTDElement.textContent = m.year;
    const actionsTDElement = document.createElement("td");
    const deleteBTNElement = document.createElement("button");
    deleteBTNElement.textContent = "Delete";
        deleteBTNElement.addEventListener("click", () => {
            newTRElement.remove()
            movies = movies.filter(m => m.index !== +idTDElement.textContent)
           console.log(idTDElement);
            console.log(movies.find(m => m.index === +idTDElement.textContent));
            console.log(movies);;
         
          
        
        });
    
    actionsTDElement.appendChild(deleteBTNElement);
    newTRElement.appendChild(idTDElement);
    newTRElement.appendChild(nomTDElement);
    newTRElement.appendChild(nameTDElement);
    newTRElement.appendChild(actionsTDElement);
    document.getElementById("mon-tbody")?.appendChild(newTRElement);
  };

fetchAllMovies(movies)
document.getElementById("btnsubmitCat").addEventListener("click",getNewCat)
function getNewCat(){
    console.table(movies);
}

