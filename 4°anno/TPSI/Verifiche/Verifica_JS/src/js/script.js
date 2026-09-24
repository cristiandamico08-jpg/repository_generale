function correggiVerifica(){
    let risposta1 = document.querySelector('input[name="gruppoMatematica1"]:checked').value;
    let risposta2 = document.querySelector('input[name="gruppoMatematica2"]:checked').value;
    
    if(risposta1 === "colora"){
        let risultato = document.getElementById("risultatoMatematica");
        risultato = "1 risposta giusta";
        document.getElementById("risultatoMatematica").innerHTML = risultato;
    }
    
    if(risposta2 === "colora2"){
        document.body.style.backgroundColor = "red";
    }
}

function accedi(){
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    if(username === "studente" && password === "1234"){
        alert("Login Corretto!");
    } else {
        alert("Errore! Riprova.");
    }
}

function calcola(){
    let num1 = document.getElementById("num1").value;
    let num2 = document.getElementById("num2").value;
    let risultato = document.getElementById("risultatoCalcolatrice");
    let operatore = document.getElementById("menuOperazioni").value;

    num1 = parseFloat(num1);
    num2 = parseFloat(num2);

    if(operatore === "somma"){
        risultato.value = num1 + num2;
    }
    if(operatore === "differenza"){
        risultato.value = num1 - num2;
    }
    if(operatore === "moltiplicazione"){
        risultato.value = num1 * num2;
    }
    if(operatore === "divisione"){
        if(num2 === 0){
            alert("Non puoi dividere per 0!");
        } else {
            risultato.value = num1 / num2;
        }
    }
}

function terminaCompito(){
    let check = document.querySelector('input[name = "checkBox"]:checked');
    if(check){
        let risposta = confirm("Sei sicuro?");
        if(risposta){
            alert("Compito Consegnato");
        }
    } else {
        alert("Devi spuntare la casella!");
    }
}