const { Student } = require("../config/db");


exports.getAllStudent = async (req, res) => {
    try {
      const etudiant = await Student.findAll();
      res.json(etudiant);
    } catch (etudiant) {
      res
        .status(500)
        .json({ message: "Erreur lors de la récupération des étudiants" });
    }
  };

exports.createStudent = async (req, res) => {
  try {
    const { firstname, lastname} = req.body; 
    await Student.create({firstname, lastname});
    res.status(201).json(Student);
  } catch (error) {
    res.status(500).json({ message: "Erreur lors de l'ajout de l'étudiant" });
  }
};
exports.getStudentByID = async (req, res) => {
    try {
      const student = await Student.findOne({where : { id: req.params.id }});
      if (!student) {
        return res.status(404).json({ message: "Etudiant non trouvé." });
      }
      res.json(student);
    } catch (error) {
      res.status(500).json({ error: error.message });
    }
  };

exports.UpdateStudent = async(req,res)=>{
    try {
        await Student.update({lastname, firstname}=req.body, {where: {id: req.params.id}})
        const student = await Student.findOne({where : { id: req.params.id }});
        if (!student) {
          return res.status(404).json({ message: "Etudiant non trouvé." });
        }
        res.json(student);
      } catch (error) {
        res.status(500).json({ error: error.message });
      }
}
exports.DeleteStudent = async(req,res)=>{
    try {
        const student = await Student.findOne({where : { id: req.params.id }});
        await Student.destroy({where: {id: req.params.id}})
        if (!student) {
          return res.status(404).json({ message: "Etudiant non trouvé." });
        }
        res.json(student);
      } catch (error) {
        res.status(500).json({ error: error.message });
      }
}