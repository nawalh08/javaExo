//Création d'un objet pour communiquer avec Redis
const redis = require("redis");
const host = "127.0.0.1";
const port = "6379";
const client = redis.createClient(port, host);
client.on("connect", () => {}).connect();

//Création d'un objet pour intéragir avec la console
const readline = require("readline");
const { stdin: input, stdout: output } = require("process");

const rl = readline.createInterface({ input, output });

//Initialize index
initialize();

//Démarre
menu();

//Fonctions

//Question en async
function questionAsync(question) {
  return new Promise((resolve, reject) => {
    rl.question(question, (response) => {
      resolve(response);
    });
  });
}

// Menu
async function menu() {
  console.log("==== Gestion de tâches ====");
  let choix = "";
  do {
    console.log(
      "1 -- Ajouter une produit \n2 -- (En Cours)\n3 -- Afficher les produits\n"
    );
    choix = await questionAsync("Votre choix : ");
    switch (choix) {
      case "1":
        await addProduct();
        break;
      case "2":
        await displayTasks();
        break;
      case "3":
        await displayTasks();
        break;
      case "4":
        await deleteProduct();
        break;
    }
  } while (choix != "0");
}

//Fonction initialisation
async function initialize() {
  const indexExists = await client.get("taskIndex");
  if (indexExists == null) {
    console.log("Pas d'index enregistré");
    await setTaskIndex(0);
  }
}

//Récupérer index
async function getTaskIndex() {
  const count = await client.get("taskIndex");
  return parseInt(count);
}

//Set Index
async function setTaskIndex(index) {
  await client.set("taskIndex", index);
}

//Ajouter une tâche
async function addProduct() {
    const nom = await questionAsync("Merci de saisir le nom du produit : ");
    const quantity = await questionAsync("Merci de saisir la quantité dans le stock : ");
    const price = await questionAsync("Merci de saisir le prix de l'objet : ");
    const obj = { name: nom, quantite: quantity,prix:price };
    const oldIndex = await getTaskIndex();
    await client.hSet(`object${oldIndex + 1}`, obj);
  
  await setTaskIndex(oldIndex + 1);
  console.log("Produit ajoutée " + obj.name+ " " + obj.quantite + " " +obj.prix);
}

//Affichage des tasks
async function displayTasks() {
    const lastIndex = await getTaskIndex();
    for (let i = 1; i <= lastIndex; i++) {
       task = await client.hGetAll(`object${i}`);
       if (task.name != undefined && task.quantite!= 0 && task.prix!= undefined) console.log("Nom Du Produit : "  + task.name + " Quantité du produit :  " + task.quantite + " Prix unitaire du produit " + task.prix);
    }
    
  }


//Suppression d'une task
async function deleteProduct() {
  const taskIndex = await questionAsync("Merci de saisir la clé de la task : ");
  const res = await client.hDel(taskIndex);
  if (res == 1) {
    console.log("Suppression Ok");
  }
}
