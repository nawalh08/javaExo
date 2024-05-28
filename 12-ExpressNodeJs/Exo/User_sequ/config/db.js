const Sequelize = require("sequelize");

const sequelize = new Sequelize("tpsequ", "root", "Fares_Dries_59", {
  host: "localhost",
  dialect: "mysql",
});

// Synchronisation des modèles
const Student = require("../models/etudiant")(sequelize);
const User = require("../models/users")(sequelize);

sequelize
  .sync({ force: false })
  .then(() => console.log("La base de données à bien été synchronisée"))
  .catch((error) =>
    console.error("Problème lors de la synchronisation :", error.message)
  );

module.exports = {
  sequelize,
  User,
  Student
};