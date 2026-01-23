let personaggioSelezionato = null;
let risposteFatte = 0;
let risposte = [];

const personaggi = [
    {
        nome: "Albert Einstein",
        domande: [true, true, true, false, false, true, true, false, true, true]
    },
    {
        nome: "Marie Curie",
        domande: [true, false, true, true, false, true, true, false, false, false]
    },
    {
        nome: "Isaac Newton",
        domande: [false, true, true, false, false, true, true, false, false, false]
    },
    {
        nome: "Ada Lovelace",
        domande: [false, true, false, true, false, false, false, false, false, false]
    },
    {
        nome: "Galileo Galilei",
        domande: [false, true, true, false, false, true, true, true, false, false]
    },
    {
        nome: "Nikola Tesla",
        domande: [false, false, true, false, false, false, true, false, false, true]
    },
    {
        nome: "Charles Darwin",
        domande: [false, false, false, false, true, true, false, false, false, false]
    },
    {
        nome: "Leonardo da Vinci",
        domande: [false, true, false, false, false, false, false, true, false, false]
    },
    {
        nome: "Carl Sagan",
        domande: [false, false, true, false, false, true, false, false, false, false]
    },
    {
        nome: "Stephen Hawking",
        domande: [false, false, true, false, false, true, true, false, true, false]
    },
    {
        nome: "Adriano Ciraudo",
        domande: [false, false, false, false, false, false, false, true, false, false]
    },
    {
        nome: "Alan Turing",
        domande: [false, true, false, false, false, true, false, false, false, false]
    },
    {
        nome: "Enrico Fermi",
        domande: [false, true, true, false, false, true, true, true, false, true]
    },
    {
        nome: "Rita Levi-Montalcini",
        domande: [true, false, false, true, false, true, false, true, false, false]
    },
    {
        nome: "Richard Feynman",
        domande: [true, false, true, false, false, true, true, false, false, false]
    },
    {
        nome: "Gregor Mendel",
        domande: [false, false, false, false, false, false, false, false, false, false]
    },
    {
        nome: "James Clerk Maxwell",
        domande: [false, true, true, false, false, false, true, false, false, true]
    },
    {
        nome: "Niels Bohr",
        domande: [true, false, true, false, false, true, true, false, false, false]
    },
    {
        nome: "Samantha Cristoforetti",
        domande: [false, false, false, true, false, false, false, true, false, false]
    },
    {
        nome: "Michael Faraday",
        domande: [false, false, true, false, false, true, true, false, false, true]
    }
];

const domande = [
    "Il personaggio ha vinto un premio Nobel?",
    "Il personaggio è un matematico?",
    "Il personaggio è un fisico?",
    "Il personaggio è una donna?",
    "Il personaggio ha contribuito alla teoria dell'evoluzione?",
    "Il personaggio ha scritto un libro famoso?",
    "Il personaggio è noto per la sua scoperta di leggi fisiche?",
    "Il personaggio è italiano?",
    "Il personaggio è famoso per i suoi lavori sulla relatività?",
    "Il personaggio ha lavorato con l'energia elettrica?"
];

function iniziaGioco() {
    document.getElementById("btn-start").style.display = "none";
    document.getElementById("contenitore-domande").style.display = "block";
    mostraDomande();
}

function mostraDomande() {
    if (risposteFatte < domande.length) {
        document.getElementById("domanda").textContent = domande[risposteFatte];
    } else {
        fineGioco();
    }
}

function risposta(scelta) {
    const risposta = scelta === 'si';
    risposte.push(risposta); // Salva la risposta dell'utente

    risposteFatte++;
    mostraDomande();
}

function fineGioco() {
    // Confronta le risposte dell'utente con le risposte dei personaggi
    let personaggioIndovinato = null;
    
    for (let i = 0; i < personaggi.length; i++) {
        let risposteCorrette = 0;
        
        // Conta quante risposte corrispondono
        for (let j = 0; j < risposte.length; j++) {
            if (risposte[j] === personaggi[i].domande[j]) {
                risposteCorrette++;
            }
        }

        // Controllo le risposte, se corrispondono tutte, ho trovato il personaggio
        if (risposteCorrette === risposte.length) {
            personaggioIndovinato = personaggi[i].nome;
            break;
        }
    }

    // Mostra il risultato finale
    if (personaggioIndovinato) {
        alert("Il personaggio che hai pensato è: " + personaggioIndovinato);
    } else {
        alert("Non sono riuscito a indovinare! Riprova.");
    }

    reset();
}

function selezionaPersonaggio(personaggio) {
    personaggioSelezionato = personaggio;
    alert("Hai scelto: " + personaggioSelezionato);
    risposte = []; // Pulisce le risposte precedenti
    risposteFatte = 0;
    iniziaGioco();
}

function reset() {
    risposteFatte = 0;
    risposte = [];
    document.getElementById("btn-start").style.display = "block";
    document.getElementById("contenitore-domande").style.display = "none";
    document.getElementById("domanda").textContent = "Clicca per iniziare a rispondere alle domande.";
}
