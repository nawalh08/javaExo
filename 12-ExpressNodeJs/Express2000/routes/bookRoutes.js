const express = require("express");
const router = express.Router();
const path = require("path");
const fs = require("fs");

// Chemin vers le fichier JSON des livres
const dataBooks = path.join(__dirname, "../data/livres.json");

// Utilisez fs.readFile pour lire le contenu du fichier JSON
const fileContent = fs.readFile(dataBooks, "utf8", (err, data) => {
  if (err) {
    console.error("Erreur lors de la lecture du fichier JSON :", err);
    return;
  }

  // Convertissez le contenu du fichier JSON en objet JavaScript
  return JSON.parse(data);
});

// Route 1 - Liste des livres
router.get("/livres", (req, res) => {
  
  res.json(fileContent);

  // fs.readFile(dataBooks, "utf8", (err, data) => {
  //   if (err) {
  //     console.error("Erreur lors de la lecture du fichier JSON :", err);
  //     res.status(500).send("Erreur interne au serveur");
  //     return;
  //   }

  //   // Convertissez le contenu du fichier JSON en objet JavaScript
  //   const listeLivres = JSON.parse(data);

  //   // Utilisez res.json() pour envoyer la réponse au format JSON
  //   res.json(listeLivres);
  // });
});

// Route 2 - Détails d'un livre par ID
router.get('/livres/:id', (req, res) => {
 const livreId = req.params.id;
 const detailsLivre = JSON.parse(fs)
 
 res.json()
});

// Route 3 - Ajout d'un nouveau livre (simulation)
router.post('/ajout-livre', (req, res) => {
 // ...
});

// Route 4 - Recherche de livres par auteur
router.get('/recherche-livre/auteur/:auteur', (req, res) => {
  // ...
})

module.exports = router;
