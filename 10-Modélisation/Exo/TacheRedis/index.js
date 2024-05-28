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
      "1 -- Ajouter une tâche \n2 -- Afficher les tâches\n3 -- Supprimer une tâche\n"
    );
    choix = await questionAsync("Votre choix : ");
    switch (choix) {
      case "1":
        await addTask();
        break;
      case "2":
        await displayTasks();
        break;
      case "3":
        await deleteTask();
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
async function addTask() {
  const task = await questionAsync("Merci de saisir la tâche : ");
  const oldIndex = await getTaskIndex();
  const result = await client.set(`task${oldIndex + 1}`, task);
  await setTaskIndex(oldIndex + 1);
  console.log("Task ajoutée " + result);
}

//Affichage des tasks
async function displayTasks() {
  const lastIndex = await getTaskIndex();
  for (let i = 1; i <= lastIndex; i++) {
    const task = await client.get(`task${i}`);
    if (task != null) console.log(task);
  }
}

//Suppression d'une task
async function deleteTask() {
  const taskIndex = await questionAsync("Merci de saisir la clé de la task : ");
  const res = await client.del(taskIndex);
  if (res == 1) {
    console.log("Suppression Ok");
  }
}
