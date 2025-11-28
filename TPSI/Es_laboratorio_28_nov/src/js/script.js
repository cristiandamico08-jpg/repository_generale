const form = document.getElementById('quizForm');
const risultatoDiv = document.getElementById('risultato');

const ID_RADIO = ['radioA', 'radioB', 'radioC', 'radioD'];

form.addEventListener('submit', function(e) {
    e.preventDefault();
    trovaSelezioneManuale();
});

function trovaSelezioneManuale() {
    let selezioneTrovata = false;

    for (let i = 0; i < ID_RADIO.length; i++) {
        const radioCorrente = document.getElementById(ID_RADIO[i]);

        if (radioCorrente.checked === true) {

            const valore = radioCorrente.value;
            risultatoDiv.innerHTML = "Risposta selezionata: <strong>" + valore + "</strong>";
            selezioneTrovata = true;

            break;

        }
    }
    
    if (!selezioneTrovata) {
        risultatoDiv.innerHTML = "Risposta selezionata: **DEVI SELEZIONARE UNA RISPOSTA**";
    }
}