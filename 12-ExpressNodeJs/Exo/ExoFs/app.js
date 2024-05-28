import fs from 'fs';

fs.mkdir("./nouveau_repertoire", (err) => {
    if (err) throw err;
    console.log("Répertoire créé avec succès!");
  });

  fs.writeFile("./nouveau_repertoire/nouveau_fichier.txt", "Contenu à écrire", 'utf8', (err, data) => {
    if (err) throw err; console.log("Le fichier a été enregistré");
  });

  fs.readFile("./nouveau_repertoire/nouveau_fichier.txt", 'utf8', (err, data) => {
    if (err) throw err; console.log("Contenu du texte : " + data);
  });

  fs.readdir("./", (err, files) => {
    if (err) throw err;
    console.log("Contenu du répertoire: ", files);
  });

  fs.unlink("./nouveau_repertoire/nouveau_fichier.txt", (err) => {
    if (err) throw err;
    console.log("Fichier supprimé avec succès!");
  });

  fs.rmdir("./nouveau_repertoire", (err) => {
    if (err) throw err;
    console.log("Répertoire supprimé avec succès!");
  });