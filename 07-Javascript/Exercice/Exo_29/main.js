let user = { username: "Fdries", password: "mdp" };
const emailValidElement = document.getElementById('email-validation')
const emailValidElement2 = document.getElementById('email-validation2')
let userName = document.getElementById("username");
let submitBtnElement = document.getElementById("btnsubmit")
let userPassword = document.getElementById("password");
document.addEventListener("DOMContentLoaded", () => {
    
    
    
    userName.addEventListener("input", (event) => {
        const inputElement = event.target;
    
        if (!inputElement.value) {
          // Via le JS, on peut modifier le style des éléments
          inputElement.style.backgroundColor = "red";
          emailValidElement.style.display = 'block'
    
          // On peut également modifier les attributs des balises HTML
          submitBtnElement.setAttribute('disabled', '');
        } else {
          inputElement.style.backgroundColor = "white";
          emailValidElement.style.display = 'none'
          submitBtnElement.removeAttribute('disabled');
        }
      });

      userPassword.addEventListener("input", (event) => {
        const inputElement = event.target;
    
        if (!inputElement.value) {
          // Via le JS, on peut modifier le style des éléments
          inputElement.style.backgroundColor = "red";
          emailValidElement2.style.display = 'block'
    
          // On peut également modifier les attributs des balises HTML
          submitBtnElement.setAttribute('disabled', '');
        } else {
          inputElement.style.backgroundColor = "white";
          emailValidElement2.style.display = 'none'
          submitBtnElement.removeAttribute('disabled');
        }
      });
});
function getNewUser() {
    let userName = document.getElementById("username").value;
    let userPassword = document.getElementById("password").value;
    let newPerson = user = { username: userName, password: userPassword };
    
    
    console.log(newPerson);

}

