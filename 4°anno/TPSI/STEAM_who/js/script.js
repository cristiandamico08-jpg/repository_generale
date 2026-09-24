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
    if(personaggioSelezionato == "Albert Einstein") {
        alert("Albert Einstein (14 marzo 1879 – 18 aprile 1955): fisico teorico tedesco naturalizzato svizzero e statunitense, padre della teoria della relatività e figura centrale della fisica moderna.");
    } else if (personaggioSelezionato == "Marie Curie") {
        alert("Marie Curie (7 novembre 1867 – 4 luglio 1934): fisica e chimica polacca naturalizzata francese, pioniera nello studio della radioattività, prima donna a vincere un premio Nobel e unica a vincerne due in due diverse discipline scientifiche.");
    } else if (personaggioSelezionato == "Isaac Newton") {
        alert("Isaac Newton (25 dicembre 1642 – 20 marzo 1727): matematico, fisico, astronomo e filosofo inglese, considerato uno dei più grandi scienziati di tutti i tempi, noto per le leggi del moto e la legge di gravitazione universale.");
    } else if (personaggioSelezionato == "Ada Lovelace") {
        alert("Ada Lovelace (10 dicembre 1815 – 27 novembre 1852): matematica e scrittrice inglese, riconosciuta come la prima programmatrice di computer per il suo lavoro sulla macchina analitica di Charles Babbage.");
    } else if (personaggioSelezionato == "Galileo Galilei") {
        alert("Galileo Galilei (15 febbraio 1564 – 8 gennaio 1642): fisico, matematico, astronomo e filosofo italiano, considerato il padre della scienza moderna per i suoi contributi alla fisica e all'astronomia.");
    } else if (personaggioSelezionato == "Nikola Tesla") {
        alert("Nikola Tesla (10 luglio 1856 – 7 gennaio 1943): inventore, ingegnere elettrico e meccanico serbo-americano, noto per i suoi contributi allo sviluppo della corrente alternata e numerose invenzioni nel campo dell'elettricità.");
    } else if (personaggioSelezionato == "Charles Darwin") {
        alert("Charles Darwin (12 febbraio 1809 – 19 aprile 1882): naturalista inglese, noto per la teoria dell'evoluzione attraverso la selezione naturale, esposta nella sua opera 'L'origine delle specie'.");
    } else if (personaggioSelezionato == "Leonardo da Vinci") {
        alert("Leonardo da Vinci (15 aprile 1452 – 2 maggio 1519): pittore, scultore, architetto, ingegnere e scienziato italiano del Rinascimento, noto per opere come 'La Gioconda' e 'L'Ultima Cena', nonché per i suoi studi in vari campi scientifici.");
    } else if (personaggioSelezionato == "Carl Sagan") {
        alert("Carl Sagan (9 novembre 1934 – 20 dicembre 1996): astronomo, astrofisico, cosmologo e divulgatore scientifico statunitense, noto per il suo lavoro sulla vita extraterrestre e la serie televisiva 'Cosmos'.");
    } else if (personaggioSelezionato == "Stephen Hawking") {
        alert("Stephen Hawking (8 gennaio 1942 – 14 marzo 2018): fisico teorico, cosmologo e autore britannannico, noto per i suoi studi sui buchi neri e la relatività, nonché per il suo libro 'Una breve storia del tempo'.");
    } else if (personaggioSelezionato == "Alan Turing") {
        alert("Alan Turing (23 giugno 1912 – 7 giugno 1954): matematico, logico e crittografo britannico, considerato il padre della scienza informatica e dell'intelligenza artificiale, noto per il suo lavoro durante la Seconda Guerra Mondiale nella decifrazione dei codici nazisti.");
    } else if (personaggioSelezionato == "Enrico Fermi") {
        alert("Enrico Fermi (29 settembre 1901 – 28 novembre 1954): fisico italiano naturalizzato statunitense, noto per i suoi contributi alla fisica nucleare e per aver guidato lo sviluppo del primo reattore nucleare.");
    } else if (personaggioSelezionato == "Rita Levi-Montalcini") {
        alert("Rita Levi-Montalcini (22 aprile 1909 – 30 dicembre 2012): neurologa e senatrice a vita italiana, vincitrice del premio Nobel per la medicina nel 1986 per la scoperta del fattore di crescita nervoso.");
    } else if (personaggioSelezionato == "Richard Feynman") {
        alert("Richard Feynman (11 maggio 1918 – 15 febbraio 1988): fisico teorico statunitense, noto per i suoi contributi alla meccanica quantistica e per il suo stile di insegnamento unico e coinvolgente.");
    } else if (personaggioSelezionato == "Gregor Mendel") {
        alert("Gregor Mendel (20 luglio 1822 – 6 gennaio 1884): monaco agostiniano e botanico austriaco, considerato il padre della genetica moderna per i suoi esperimenti sulle piante di pisello che hanno portato alla formulazione delle leggi dell'ereditarietà.");
    } else if (personaggioSelezionato == "James Clerk Maxwell") {
        alert("James Clerk Maxwell (13 giugno 1831 – 5 novembre 1879): fisico e matematico scozzese, noto per la formulazione delle equazioni di Maxwell che descrivono l'elettromagnetismo.");
    } else if (personaggioSelezionato == "Niels Bohr") {
        alert("Niels Bohr (7 ottobre 1885 – 18 novembre 1962): fisico danese, noto per il modello atomico di Bohr e i suoi contributi alla comprensione della struttura atomica e della meccanica quantistica.");
    } else if (personaggioSelezionato == "Samantha Cristoforetti") {
        alert("Samantha Cristoforetti (n. 26 aprile 1977): astronauta e ingegnere aerospaziale italiana, la prima donna italiana nello spazio, nota per le sue missioni a bordo della Stazione Spaziale Internazionale.");
    } else if (personaggioSelezionato == "Michael Faraday") {
        alert("Michael Faraday (22 settembre 1791 – 25 agosto 1867): scienziato inglese, noto per le sue scoperte nell'elettromagnetismo e l'elettrochimica, tra cui l'induzione elettromagnetica.");
    }
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
