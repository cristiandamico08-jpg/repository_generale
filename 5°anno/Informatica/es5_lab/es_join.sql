 - Esercizio 1: Assegnazione Dipendenti - Dipartimenti (INNER JOIN): SELECT d.nome, d.cognome, dep.nome_dipartimento, dep.sede 
FROM dipendenti d
INNER JOIN dipartimenti dep
ON d.id_dipendente = dep.id_dipartimento
WHERE d.id_dipartimento IS NOT NULL
ORDER BY d.cognome ASC;

 - Esercizio 2: Anagrafica Completa Dipendenti (LEFT JOIN): SELECT d.nome, d.cognome, dep.nome_dipartimento
FROM dipendenti d
LEFT JOIN dipartimenti dep
ON d.id_dipartimento = dep.id_dipartimento;

 - Esercizio 3: Audit Dipartimenti Inattivi (RIGHT JOIN + WHERE IS NULL): SELECT d.nome, d.cognome, dep.nome_dipartimento
FROM dipartimenti dep
RIGHT JOIN dipendenti d
ON d.id_dipartimento = dep.id_dipartimento
WHERE d.id_dipartimento IS NULL;

 - Esercizio 4: Collegamento a 3 Tabelle (INNER JOIN Multipla): SELECT d.nome, d.cognome, dep.nome_dipartimento, p.nome_progetto
FROM dipendenti d
INNER JOIN dipartimenti dep
ON d.id_dipartimento = dep.id_dipartimento
INNER JOIN progetti p
ON d.id_dipartimento = p.id_dipartimento;

 - Esercizio 5: Conteggio dei dipendenti per sede aziendale: SELECT dep.sede, COUNT(dep.sede) AS numero_dipendenti
FROM dipendenti d
INNER JOIN dipartimenti dep
ON d.id_dipartimento = dep.id_dipartimento
INNER JOIN progetti p
ON d.id_dipartimento = p.id_dipartimento
GROUP BY dep.sede
HAVING numero_dipendenti >=2
ORDER BY numero_dipendenti DESC;