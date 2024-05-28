
function getInputValue(){
    
    var inputVal = document.getElementById("prenom").value;
    el = document.createElement('li');
    el.innerHTML = inputVal;
    document.getElementById('MyUl').appendChild(el);
}