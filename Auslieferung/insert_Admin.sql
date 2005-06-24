/*
 * Die Primary Keys von echten Entities (sprich: Nicht-Relationen)
 * haben den Typ SERIAL, der automatisch eine fortlaufende, unikate Nummer
 * generiert, was praktisch ist. In INSERT-Statements m�ssen deshalb nur die
 * Werte eingef�gt werden. Au�er bei Relationen, wie gesagt.
 * ZimmerNr wird auch nicht automatisch mitgez�hlt, weil sie bei Hotels
 * irgendwie fix vergeben ist, und nicht generiert wird.
 */

/* Einf�gen einer Berechtigung. */

INSERT INTO Berechtigung (Berechtigungsnr, Bezeichnung) VALUES (1,'Admin');
INSERT INTO Berechtigung (Berechtigungsnr, Bezeichnung) VALUES (2,'Rezeption');
INSERT INTO Berechtigung (Berechtigungsnr, Bezeichnung) VALUES (3,'Reinigung');

/*
 * Einf�gen eines neuen Mitarbeiters.
 * 2 als BerechtigungsNr hei�t in dem Fall 'Rezeptionist', aber im Programm
 * muss �ber ein SELECT-Statement herausgefunden werden, welche m�glichen
 * BerechtigungsNrn es �berhaupt gibt.
 */
INSERT INTO Mitarbeiter (Mitarbeiternr, Berechtigungsnr, Nachname, Vorname, Login, Passwort) VALUES (1, 1, 'Admin', 'Admin', 'Admin','passwd');
