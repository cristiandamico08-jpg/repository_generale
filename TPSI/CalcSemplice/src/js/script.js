function sommaNumeri(){
    const val1 = document.getElementById('numero1').value;
    const val2 = document.getElementById('numero2').value;

    const num1 = parseFloat(val1);
    const num2 = parseFloat(val2);

    const somma = num1 + num2;

    document.getElementById('risultato').value = somma;
}

function sottrazioneNumeri(){
    const val1 = document.getElementById('numero1').value;
    const val2 = document.getElementById('numero2').value;

    const num1 = parseFloat(val1);
    const num2 = parseFloat(val2);

    const sottrazione = num1 - num2;

    document.getElementById('risultato').value = sottrazione;
}

function moltiplicazioneNumeri(){
    const val1 = document.getElementById('numero1').value;
    const val2 = document.getElementById('numero2').value;

    const num1 = parseFloat(val1);
    const num2 = parseFloat(val2);

    const molt = num1 * num2;

    document.getElementById('risultato').value = molt;
}

function divisioneNumeri(){
    const val1 = document.getElementById('numero1').value;
    const val2 = document.getElementById('numero2').value;

    const num1 = parseFloat(val1);
    const num2 = parseFloat(val2);

    const div = num1 / num2;

    document.getElementById('risultato').value = div;
}