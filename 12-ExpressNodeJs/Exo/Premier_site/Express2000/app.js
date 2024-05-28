const express = require('express');
const app = express();
const path = require('path')
const PORT = process.env.PORT || 3000;
const bookRouter = require ('./routes/bookRoutes.js')
app.use('/book',bookRouter)
app.use(express.static('public'))
app.set('view engine', 'pug') // Configuration du moteur de modèle
app.set('views', path.join(__dirname, 'views'));

app.get('/bienvenue',(req , res ) => {
    res.render('index', {title: 'HomePage', message: 'Bienvenue sur mon site'})
})
// })
// app.get('/infos',(req , res ) => {
//     res.json({ name: 'Fares', lastname:"Dries", age:22 })
// })
// app.get('/acces-interdit',(req , res ) => {
//     res.status(404).send('Circulez il n'+ 'y a rien a voir');
// })


// app.get('/redirection-accueil',(req , res ) => {
//     res.redirect('/bienvenue');;
// })
app.get('*',(req , res ) => {
    res.send('Circulez il n'+ 'y a rien a voir');
})

 app.listen(PORT,() =>{
     console.log(`Serveur en écoute sur le port ${PORT}`);
 })


module.exports = app;
