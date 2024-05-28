const User = require("../models/users");
const bcrypt = require('bcrypt')
const jwt = require('jsonwebtoken')

const usersController = {
  addUser: async (req, res) => {
    try {
      const { username, password } = req.body
      const saltRounds = 10
      const hashedPassword = await bcrypt.hash(password, saltRounds);
      const user = new User({ username, password: hashedPassword });

      await user.save();
      res.status(201).json(user);




    } catch (error) {
      res.status(400).json({ error: error.message });
    }
  },
  login: async (req, res) => {
    try {
      const { username, password } = req.body;
      const user = await User.findOne({ username });

      if (!user) {
        return res.status(401).json({ message: 'Nom d\'utilisateur ou mot de passe incorrect' });
      }

      const passwordMatch = await bcrypt.compare(password, user.password);

      if (!passwordMatch) {
        return res.status(401).json({ message: 'Nom d\'utilisateur ou mot de passe incorrect' });
      }

      const token = jwt.sign({ userId: user._id }, 'secret_key', { expiresIn: '1h' });
      res.json({ token });
    } catch (error) {
      res.status(500).json({ message: error.message });
    }
  },
  protectedRoute: async (req, res) => {
    res.json({ message: 'Route protégée avec succès' });
  }

}

module.exports = usersController;

