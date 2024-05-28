const BASE_URL = "https://pokeapi.co/api/v2/";
let temps ="";
let allPokemonContainer = document.getElementById('poke-container');
let image="";
let pokeContainer="";
let pokeName;
let pokeNumber
let pokeTypes
let pokeTaille
let pokePoids
let pokeAbilities
let ulT 
let ulC
if(temps==""){
    document.getElementById("suivant").disabled = true;
    document.getElementById("precedant").disabled = true;
}
function mapPokemon(data) {
    return {
      height: data.height,
      weight: data.weight,
      name: data.name,
      types: data.types,
      moves : data.abilities
    };
  }
  
  // La plupart des mécanisme de récupération de données se trouveront dans des fonction asynchrone de sorte à pouvoir attendre les différents traitements dont le temps n'est pas dépendant de notre programme
  async function getPokemonByName(name) {
    const response = await fetch(BASE_URL + "pokemon/" + name); // On récupère des données sur un serveur distant via une API
    const data = await response.json(); // ON transforme les données reçues en un élément exploitable par notre code
    return data; // On retourne l'élément reçu après tous les traitements
  }
  async function getPokemonById(id) {
    const response = await fetch(BASE_URL + "pokemon/" + id); // On récupère des données sur un serveur distant via une API
    const data = await response.json(); // ON transforme les données reçues en un élément exploitable par notre code
    return data; // On retourne l'élément reçu après tous les traitements
  }

document.addEventListener("DOMContentLoaded", async () => {
    allPokemonContainer = document.getElementById('poke-container');
    pokeContainer = document.createElement("div") //div will be used to hold the data/details for indiviual pokemon.{}
    pokeContainer.classList.add('ui', 'card');
    image = document.getElementById('displayIMG');
    pokeName = document.getElementById('nom')
    pokeNumber = document.getElementById('id') 
    pokeTypes = document.getElementById('type')
    pokeTaille = document.getElementById('taille')
    pokePoids = document.getElementById('poids')
    pokeAbilities = document.getElementById('capacities')
    ulC = document.getElementById('capacities')
    ulT = document.getElementById('type')
const ditto = await getPokemonByName("ditto"); // Pour attendre, il faut utiliser le mot-clé 'await'
const growlithe = await getPokemonByName("growlithe");
const dittoId = await getPokemonByName("1"); // Pour attendre, il faut utiliser le mot-clé 'await'
const growlitheId = await getPokemonByName("58");


// Pour transformer les données complexe en des données plus simple, on les fait passer dans notre fonction de mapping via .map()
// const datas = [dataDitto, dataGrowlithe].map((data) => mapPokemon(data));
const datas = [ditto].map(mapPokemon);
console.log(datas);

}
)
async function getTimes(){
    temps = document.getElementById('Search').value;
    temps = await getPokemonByName(temps);
    console.log(temps.name);
    console.log(temps.types);
    renderPokemon(temps)
    console.log(temps.types);
    console.log(temps.abilities);
}

function renderPokemon(temps){  
    image.src = `https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${temps.id}.png`
    pokeName.innerText = temps.name
    pokeNumber.innerText = temps.id
    pokeTypes = createTypes(temps.types)//ul list will hold the pokemon types
    pokeTaille.innerText = temps.height + " ft"
    pokePoids.innerText = temps.weight + " kg"
    console.log(pokePoids);

     // helper function to go through the types array and create li tags for each one

    
    pokeAbilities = createAbilities(temps.abilities)
       //appending all details to the pokeContainer div
    allPokemonContainer.appendChild(pokeContainer);       //appending that pokeContainer div to the main div which will                                                             hold all the pokemon cards
    if(temps.id <=1){
        document.getElementById("precedant").disabled = true;
        document.getElementById("suivant").disabled = false;
    }else if(temps.id >=1017){
        document.getElementById("suivant").disabled = true;
        document.getElementById("precedant").disabled = false;
    }else{
        document.getElementById("suivant").disabled = false;
        document.getElementById("precedant").disabled = false;
    }
}

function createTypes(types, ){
    ulT.innerHTML="";
    types.forEach(function(type){
        let typeLi = document.createElement('li');
        typeLi.innerText = type['type']['name'];
        ulT.append(typeLi)
    })
}
function createAbilities(moves){
    ulC.innerHTML="";
    moves.forEach(function(ability){
        let moveLi = document.createElement('li');
        moveLi.innerText = ability['ability']['name'];
        ulC.append(moveLi)
    })
}
async function changePokemonPlus(){
    if(temps.id ==1017){
        pokeID=0
        pokeID++;
        temps.id=0;
    }
    pokeID = temps.id+1
    temps.id++
    
  
    console.log(pokeID);
    const response = await fetch(BASE_URL + "pokemon/" + pokeID); // On récupère des données sur un serveur distant via une API
    const data = await response.json();
    console.log(data);
    renderPokemon(data)
}
async function changePokemonMoins(){
    
    if(temps.id ==1){
        pokeID=1017
        pokeID--;
        temps.id=1018;
    }
    pokeID = temps.id-1
    temps.id--
    
    console.log(pokeID);
    const response = await fetch(BASE_URL + "pokemon/" + pokeID); // On récupère des données sur un serveur distant via une API
    const data = await response.json();
    console.log(data);
    renderPokemon(data)
}
  