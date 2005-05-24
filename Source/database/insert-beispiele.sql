/*
 * Die Primary Keys von echten Entities (sprich: Nicht-Relationen)
 * haben den Typ SERIAL, der automatisch eine fortlaufende, unikate Nummer
 * generiert, was praktisch ist. In INSERT-Statements m�ssen deshalb nur die
 * Werte eingef�gt werden. Au�er bei Relationen, wie gesagt.
 * ZimmerNr wird auch nicht automatisch mitgez�hlt, weil sie bei Hotels
 * irgendwie fix vergeben ist, und nicht generiert wird.
 */

/* Einf�gen einer Berechtigung. */
INSERT INTO Berechtigung (Bezeichnung) VALUES ('Admin');

/*
 * Einf�gen eines neuen Mitarbeiters.
 * 2 als BerechtigungsNr hei�t in dem Fall 'Rezeptionist', aber im Programm
 * muss �ber ein SELECT-Statement herausgefunden werden, welche m�glichen
 * BerechtigungsNrn es �berhaupt gibt.
 */
INSERT INTO Mitarbeiter (BerechtigungsNr, Nachname, Vorname, Login, Passwort) VALUES (2, 'Petsovits', 'Jakob', 'jpetso', 'crackit');

/* Einf�gen eines neuen Kunden. */
INSERT INTO Kunde (Nachname, Vorname, PLZ, Wohnort, Strasse, TelNr) VALUES ('Petsovits', 'Papa', '7312', 'Horitschon', 'Spamgasse 13', '+43(664)7649270');

/*
 * Einf�gen einer neuen Notiz. Die KundenNr muss auch hier eigentlich
 * �ber ein SELECT-Statement herausgefunden werden, w�hrend die NotizNr
 * automatisch generiert wird.
 */
INSERT INTO Notiz (KundenNr, Bezeichnung) VALUES (1, 'Vater von Jakob. Bekommt auf alles eine 30% Erm��igung.');

/* Einf�gen des Zimmers 666. ZimmerNr wird nicht automatisch generiert. */
INSERT INTO Zimmer (ZimmerNr, AnzahlBetten, PreisProNacht) VALUES (666, 2, 30.70);

/* Einf�gen von neuen Zimmer-Aufgaben. */
INSERT INTO Aufgabe (ZimmerNr, Bezeichnung, ab, Deadline, erledigt) VALUES (666, 'Brand l�schen', 'now', '2005-05-27', FALSE);
INSERT INTO Aufgabe (ZimmerNr, Bezeichnung, ab, Deadline, erledigt) VALUES (666, 'Saustall aufr�umen', '2005-05-27', '2005-06-30', FALSE);

/* Einf�gen diverser Zimmer-Ausstattungsm�glichkeiten. */
INSERT INTO Ausstattung (Bezeichnung) VALUES ('Fernseher');
INSERT INTO Ausstattung (Bezeichnung) VALUES ('Wasserbett');
INSERT INTO Ausstattung (Bezeichnung) VALUES ('WLAN');

/*
 * Im h�llischen Zimmer gibt es Fernseher und WLAN.
 * Dass man auch hier die Primary Keys �ber irgendwelche SELECT-Statements
 * ausfindig machen sollte, muss wohl eh nicht mehr erw�hnt werden?
 */
INSERT INTO verfuegt_ueber (ZimmerNr, AusstattungsNr) VALUES (666, 1);
INSERT INTO verfuegt_ueber (ZimmerNr, AusstattungsNr) VALUES (666, 3);

/*
 * Reservieren einer Buchung f�r Kunde 1, reserviert von Mitarbeiter 1.
 * Die per SELECT-Statement gefunden werden.
 */
INSERT INTO Aufenthalt (KundenNr, MitarbeiterNr, von, bis, Status) VALUES (1, 1, '2005-07-01', '2005-07-08', 'reserviert');

/*
 * Zimmer f�r den Aufenthalt belegen. K�nnen auch mehrere Zimmer sein.
 * Achtung: Das ist das einzige, was gemacht werden muss (beim Anlegen eines
 *          Aufenthalts) und von Postgres nicht �berpr�ft wird!
 *          Also extra aufpassen, dass es f�r jeden Aufenthalt mindestens ein
 *          belegtes Zimmer gibt.
 */
INSERT INTO belegt (AufenthaltsNr, ZimmerNr, von, bis) VALUES (1, 666, '2005-07-01', '2005-07-08');
