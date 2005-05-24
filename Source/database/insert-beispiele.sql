/*
 * Die Primary Keys von echten Entities (sprich: Nicht-Relationen)
 * haben den Typ SERIAL, der automatisch eine fortlaufende, unikate Nummer
 * generiert, was praktisch ist. In INSERT-Statements müssen deshalb nur die
 * Werte eingefügt werden. Außer bei Relationen, wie gesagt.
 * ZimmerNr wird auch nicht automatisch mitgezählt, weil sie bei Hotels
 * irgendwie fix vergeben ist, und nicht generiert wird.
 */

/* Einfügen einer Berechtigung. */
INSERT INTO Berechtigung (Bezeichnung) VALUES ('Admin');

/*
 * Einfügen eines neuen Mitarbeiters.
 * 2 als BerechtigungsNr heißt in dem Fall 'Rezeptionist', aber im Programm
 * muss über ein SELECT-Statement herausgefunden werden, welche möglichen
 * BerechtigungsNrn es überhaupt gibt.
 */
INSERT INTO Mitarbeiter (BerechtigungsNr, Nachname, Vorname, Login, Passwort) VALUES (2, 'Petsovits', 'Jakob', 'jpetso', 'crackit');

/* Einfügen eines neuen Kunden. */
INSERT INTO Kunde (Nachname, Vorname, PLZ, Wohnort, Strasse, TelNr) VALUES ('Petsovits', 'Papa', '7312', 'Horitschon', 'Spamgasse 13', '+43(664)7649270');

/*
 * Einfügen einer neuen Notiz. Die KundenNr muss auch hier eigentlich
 * über ein SELECT-Statement herausgefunden werden, während die NotizNr
 * automatisch generiert wird.
 */
INSERT INTO Notiz (KundenNr, Bezeichnung) VALUES (1, 'Vater von Jakob. Bekommt auf alles eine 30% Ermäßigung.');

/* Einfügen des Zimmers 666. ZimmerNr wird nicht automatisch generiert. */
INSERT INTO Zimmer (ZimmerNr, AnzahlBetten, PreisProNacht) VALUES (666, 2, 30.70);

/* Einfügen von neuen Zimmer-Aufgaben. */
INSERT INTO Aufgabe (ZimmerNr, Bezeichnung, ab, Deadline, erledigt) VALUES (666, 'Brand löschen', 'now', '2005-05-27', FALSE);
INSERT INTO Aufgabe (ZimmerNr, Bezeichnung, ab, Deadline, erledigt) VALUES (666, 'Saustall aufräumen', '2005-05-27', '2005-06-30', FALSE);

/* Einfügen diverser Zimmer-Ausstattungsmöglichkeiten. */
INSERT INTO Ausstattung (Bezeichnung) VALUES ('Fernseher');
INSERT INTO Ausstattung (Bezeichnung) VALUES ('Wasserbett');
INSERT INTO Ausstattung (Bezeichnung) VALUES ('WLAN');

/*
 * Im höllischen Zimmer gibt es Fernseher und WLAN.
 * Dass man auch hier die Primary Keys über irgendwelche SELECT-Statements
 * ausfindig machen sollte, muss wohl eh nicht mehr erwähnt werden?
 */
INSERT INTO verfuegt_ueber (ZimmerNr, AusstattungsNr) VALUES (666, 1);
INSERT INTO verfuegt_ueber (ZimmerNr, AusstattungsNr) VALUES (666, 3);

/*
 * Reservieren einer Buchung für Kunde 1, reserviert von Mitarbeiter 1.
 * Die per SELECT-Statement gefunden werden.
 */
INSERT INTO Aufenthalt (KundenNr, MitarbeiterNr, von, bis, Status) VALUES (1, 1, '2005-07-01', '2005-07-08', 'reserviert');

/*
 * Zimmer für den Aufenthalt belegen. Können auch mehrere Zimmer sein.
 * Achtung: Das ist das einzige, was gemacht werden muss (beim Anlegen eines
 *          Aufenthalts) und von Postgres nicht überprüft wird!
 *          Also extra aufpassen, dass es für jeden Aufenthalt mindestens ein
 *          belegtes Zimmer gibt.
 */
INSERT INTO belegt (AufenthaltsNr, ZimmerNr, von, bis) VALUES (1, 666, '2005-07-01', '2005-07-08');
