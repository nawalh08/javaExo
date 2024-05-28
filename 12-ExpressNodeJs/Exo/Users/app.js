const express = require('express');
const mongoose = require('mongoose');
const app = express();
const port = 3000;
const userRoutes = require("./routes/userRoutes");

// Connexion à MongoDB
mongoose.connect('mongodb://localhost:27017/users', {
  useNewUrlParser: true,
  useUnifiedTopology: true,
}); // Les options sont utilisées pour éviter les avertissements liés à la dépréciation des fonctionnalités.

const db = mongoose.connection;

db.on('error', console.error.bind(console, 'Erreur de connexion à MongoDB :'));
db.once('open', () => {
  console.log('Connecté à MongoDB');
}); // Ces lignes gèrent les événements liés à la connexion MongoDB. En cas d'erreur, un message est affiché dans la console. Si la connexion est établie avec succès, le message "Connecté à MongoDB" est affiché une fois.

// Vos routes et middleware Express ici...
app.use(express.json()).use("/api/user", userRoutes);

app.get("*", (req, res) => {
  res.send("Cette route n'existe pas");
});
app.listen(port, () => {
  console.log(`Server is listening at <http://localhost>:${port}`);
})