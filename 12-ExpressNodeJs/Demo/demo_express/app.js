const express = require('express');
const app = express();
const PORT = process.env.PORT || 3000;

app.get('/',(req , res ) => {
    res.send("Bienvenue sur votre application Express !")
})
app.get('/essai',(req , res ) => {
    res.send("Bienvenue sur votre essais !")
})

app.listen(PORT,() =>{
    console.log(`Serveur en écoute sur le port ${PORT}`);
})

