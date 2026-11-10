USE gantt_wbs_db;

ALTER TABLE progetti
ADD COLUMN descrizione_progetto TEXT;

ALTER TABLE wbs_fasi
ADD COLUMN nome_cliente VARCHAR(100);

ALTER TABLE wbs_fasi
DROP COLUMN nome_cliente;


CREATE INDEX idx_cliente
ON progetti(cliente);

CREATE INDEX idx_responsabile
ON wbs_fasi(responsabile);

CREATE INDEX idx_data_lavoro
ON registro_ore(data_lavoro);


INSERT INTO progetti
(id_progetto, nome_progetto, cliente, descrizione_progetto)
VALUES
(1, 'Sviluppo E-commerce', 'Beta Srl', 'Realizzazione piattaforma e-commerce'),
(2, 'Sistema Gestionale', 'Acme Corp', 'Sviluppo di un gestionale aziendale'),
(3, 'Applicazione Mobile', 'Tech Solutions', 'Creazione applicazione mobile');

INSERT INTO wbs_fasi
(id_fase, id_progetto, nome_fase, ore_preventivate,
 data_inizio_prevista, data_fine_prevista, responsabile)
VALUES
(1, 1, 'Analisi requisiti', 40.00, '2026-01-10', '2026-01-20', 'Mario Rossi'),
(2, 1, 'Sviluppo frontend', 80.00, '2026-01-21', '2026-02-15', 'Luca Bianchi'),
(3, 2, 'Progettazione database', 50.00, '2026-02-01', '2026-02-15', 'Anna Verdi'),
(4, 2, 'Sviluppo backend', 100.00, '2026-02-16', '2026-03-20', 'Marco Neri'),
(5, 3, 'Design interfaccia', 60.00, '2026-03-01', '2026-03-15', 'Sara Gallo');

INSERT INTO registro_ore
(id_registro, id_fase, nome_dipendente, data_lavoro,
 ore_lavorate, nota_attivita)
VALUES
(1, 1, 'Mario Rossi', '2026-01-10', 8.00, 'Analisi iniziale'),
(2, 1, 'Mario Rossi', '2026-01-11', 6.00, 'Raccolta requisiti'),
(3, 3, 'Anna Verdi', '2026-02-02', 7.00, 'Analisi database'),
(4, 2, 'Luca Bianchi', '2026-01-22', 8.00, 'Sviluppo pagina principale'),
(5, 5, 'Sara Gallo', '2026-03-02', 5.00, 'Studio grafica'),
(6, 3, 'Anna Verdi', '2026-02-03', 6.00, 'Progettazione tabelle'),
(7, 4, 'Marco Neri', '2026-02-17', 8.00, 'Sviluppo API'),
(8, 4, 'Marco Neri', '2026-02-18', 7.00, 'Test backend'),
(9, 2, 'Luca Bianchi', '2026-01-25', 6.00, 'Sviluppo menu'),
(10, 5, 'Sara Gallo', '2026-03-03', 4.00, 'Revisione interfaccia');


UPDATE registro_ore
SET nota_attivita = 'Revisione architettura e test di sicurezza'
WHERE id_registro = 3;


UPDATE progetti
SET nome_progetto = 'Gestionale Aziendale Avanzato',
    cliente = 'Acme Corp',
    descrizione_progetto = 'Sviluppo di un sistema gestionale avanzato per Acme Corp'
WHERE id_progetto = 2;


UPDATE wbs_fasi
SET ore_preventivate = ore_preventivate * 1.10
WHERE id_progetto IN (
    SELECT id_progetto
    FROM progetti
    WHERE cliente = 'Acme Corp'
);


DELETE FROM registro_ore
WHERE id_registro = 5;


DELETE FROM progetti
WHERE id_progetto = 1;


CREATE TABLE log_attivita (
    id_log INT AUTO_INCREMENT PRIMARY KEY,
    azione VARCHAR(50),
    data_evento DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO log_attivita (azione)
VALUES
('Creazione progetto'),
('Aggiornamento fase');

SELECT * FROM log_attivita;

TRUNCATE TABLE log_attivita;

DROP TABLE log_attivita;