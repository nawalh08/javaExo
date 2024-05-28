const express = require("express");
const router = express.Router();
const data = require ('./date/livre.json');

console.log(data);
router.get('/', (req, res) => {
    res.send(data);
  });
  
router.get('/livres/:id',(req, res) => {
    const id = req.params.id -1;
    res.send(data[id]);
  });

router.get('/ajout',(req, res) => {
    res.send("Livre ajoutés")
    
})

router.get('/livres/:author',(req, res) => {
    const auteur = req.params.author -1;
    res.send(data[id]);
  });





  module.exports = router;