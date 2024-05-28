const express = require("express");
const studentController = require("../controllers/studentController");

const router = express.Router();

router.get("/", studentController.getAllStudent);
router.post("/add-student", studentController.createStudent);
router.get("/:id", studentController.getStudentByID);
router.put("/change/:id", studentController.UpdateStudent);
router.delete("/delete/:id", studentController.DeleteStudent);


module.exports = router;