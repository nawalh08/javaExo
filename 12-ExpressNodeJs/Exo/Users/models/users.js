const mongoose = require("mongoose");

const userSchema = new mongoose.Schema({
  username: { type: String, require: true },
  password: { type: String, require: true },

});

const users = mongoose.model("User", userSchema);

module.exports = users;