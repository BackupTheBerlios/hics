/*
 * Die Primary Keys von echten Entities (sprich: Nicht-Relationen)
 * haben den Typ SERIAL, der automatisch eine fortlaufende, unikate Nummer
 * generiert, was praktisch ist. In INSERT-Statements müssen deshalb nur die
 * Werte eingefügt werden. Außer bei Relationen, wie gesagt.
 * ZimmerNr wird auch nicht automatisch mitgezählt, weil sie bei Hotels
 * irgendwie fix vergeben ist, und nicht generiert wird.
 */

/* Einfügen einer Berechtigung. */

INSERT INTO Berechtigung (Berechtigungsnr, Bezeichnung) VALUES (1,'Admin');
INSERT INTO Berechtigung (Berechtigungsnr, Bezeichnung) VALUES (2,'Rezeption');
INSERT INTO Berechtigung (Berechtigungsnr, Bezeichnung) VALUES (3,'Reinigung');

/*
 * Einfügen eines neuen Mitarbeiters.
 * 2 als BerechtigungsNr heißt in dem Fall 'Rezeptionist', aber im Programm
 * muss über ein SELECT-Statement herausgefunden werden, welche möglichen
 * BerechtigungsNrn es überhaupt gibt.
 */
INSERT INTO Mitarbeiter (Mitarbeiternr, Berechtigungsnr, Nachname, Vorname, Login, Passwort) VALUES (1, 1, 'Admin', 'Admin', 'Admin','passwd');
