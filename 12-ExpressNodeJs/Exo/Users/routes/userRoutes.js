const express = require("express");
const userController = require("../controllers/userController");

const router = express.Router();


router.post("/singup", userController.addUser);
router.post("/login", userController.login);
router.get("/profile",userController.protectedRoute);


module.exports = router;
