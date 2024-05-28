const express = require("express");
const app = express();
const bookRoutes = require("./routes/bookRoutes");
const path = require('path');
const mongoose = require('mongoose');

// Connexion à MySQL
const connection = require("./config/db")

// Connexion Mongoose
mongoose.connect('mongodb://localhost:27017/monapp');

const db = mongoose.connection;

db.on('error', console.error.bind(console, 'Erreur de connexion à MongoDB :'));
db.once('open', () => {
  console.log('Connecté à MongoDB');
})
// Utliser le routeur bookRoutes
app.use("/", bookRoutes);

app.set("view engine", "pug"); // Configuration du moteur de modèle
app.set("views", path.join(__dirname, "views")); // Spécification du répertoire des views

// Texte HTML
app.get("/bienvenue", (req, res) => {
  res.render('index');
});

app.get("/contact", (req, res) => {
  res.render('contact');
});

// Contenu en JSON
app.get("/info", (req, res) => {
  const jsonData = {
    nom: "Benoit Lecoeuvre",
    age: 31,
    ville: "Lille",
  };
  res.json(jsonData);
});

// Code de statut personnalisé
app.get("/acces-interdit", (req, res) => {
  res.status(403).send("Accès interdit - Code 403");
});

// Redirection vers la page d'accueil
app.get("/redirection-accueil", (req, res) => {
  res.redirect("/");
});

// Route par défaut
app.get("*", (req, res) => {
  res.send("Oups, cette page n'existe pas");
});

// Port d'écoute
const port = 3000;
app.listen(port, () => {
  console.log(`Serveur en écoute sur le port ${port}`);
});
