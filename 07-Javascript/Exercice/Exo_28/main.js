
let person = { firstName: "John", lastName: "Doe", birthdate: "20/04/2001" };
const mesPersonnes = [];
let id = 2;
function getInputValue() {

    var inputValNom = document.getElementById("nom").value;
    var inputValPrenom = document.getElementById("prenom").value;
    var inputNaissance = document.getElementById("Birthdate").value;
    let newPerson = person = { firstName: inputValNom, lastName: inputValPrenom, birthdate: inputNaissance }
    console.log(newPerson);
    // el = document.createElement('li');

    // document.getElementById('MyUl').appendChild(el);

    mesPersonnes.push(newPerson);
    console.log(mesPersonnes);
    var table = document.getElementById("myTable");
    var row = table.insertRow(-1);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    cell1.innerHTML = id;
    cell2.innerHTML = newPerson.firstName;
    cell3.innerHTML = newPerson.lastName;
    cell4.innerHTML = newPerson.birthdate;
    id++;

}
