const { DataTypes } = require("sequelize");

module.exports = (sequelize) => {
  const student = sequelize.define("Student", {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    firstname: {
      type: DataTypes.STRING,
      allowNull: false,      
    },
    lastname: {
      type: DataTypes.STRING,
      allowNull: false,      
    },
  });

  return student;
};
