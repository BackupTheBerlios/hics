/*

 * Das sind die Tabellen, so wie sie in der Datenbank stehen.

 * Als Nachschlagewerk, sozusagen. Postgres ist ziemlich cool und überprüft

 * für die meisten Werte, ob sie so passen und ob es z.B. einen Fremdschlüssel

 * eh auch in der Ursprungstabelle gibt. (Beispiele zum Einfügen von Werten

 * in die verschiedenen Tabellen finden sich in insert-beispiele.sql.)

 */



CREATE TABLE Berechtigung ( BerechtigungsNr SERIAL PRIMARY KEY, Bezeichnung VARCHAR(15) NOT NULL );

CREATE TABLE Mitarbeiter ( MitarbeiterNr SERIAL UNIQUE NOT NULL, BerechtigungsNr INTEGER NOT NULL, Nachname VARCHAR(50) NOT NULL, Vorname VARCHAR(50) NOT NULL, Login VARCHAR(30) NOT NULL, Passwort VARCHAR(30) NOT NULL, PRIMARY KEY (MitarbeiterNr, BerechtigungsNr), FOREIGN KEY (BerechtigungsNr) REFERENCES Berechtigung(BerechtigungsNr) );



CREATE TABLE Kunde ( KundenNr SERIAL PRIMARY KEY, Nachname VARCHAR(50) NOT NULL, Vorname VARCHAR(50) NOT NULL, Land VARCHAR(5) DEFAULT 'A', PLZ INTEGER, Wohnort VARCHAR(50), Strasse VARCHAR(50), TelNr VARCHAR(25), Notiz VARCHAR(1000) );



CREATE TABLE Zimmer ( ZimmerNr INTEGER PRIMARY KEY, AnzahlBetten INTEGER NOT NULL, PreisProNacht FLOAT NOT NULL );

CREATE TABLE Aufgabe ( AufgabenNr SERIAL PRIMARY KEY, ZimmerNr INTEGER NOT NULL, Bezeichnung VARCHAR(500) NOT NULL, ab DATE, Deadline DATE, erledigt BOOLEAN NOT NULL, FOREIGN KEY (ZimmerNr) REFERENCES Zimmer(ZimmerNr) );



CREATE TABLE Ausstattung ( AusstattungsNr SERIAL PRIMARY KEY, Bezeichnung VARCHAR(100) NOT NULL );

CREATE TABLE verfuegt_ueber ( ZimmerNr INTEGER NOT NULL, AusstattungsNr INTEGER NOT NULL, PRIMARY KEY (ZimmerNr, AusstattungsNr),FOREIGN KEY (ZimmerNr) REFERENCES Zimmer(ZimmerNr), FOREIGN KEY (AusstattungsNr) REFERENCES Ausstattung(AusstattungsNr) );



CREATE TABLE Aufenthalt ( AufenthaltsNr SERIAL PRIMARY KEY, KundenNr INTEGER NOT NULL, MitarbeiterNr INTEGER NOT NULL, von DATE NOT NULL, bis DATE NOT NULL, Status VARCHAR(10) NOT NULL, FOREIGN KEY (KundenNr) REFERENCES Kunde(KundenNr), FOREIGN KEY (MitarbeiterNr) REFERENCES Mitarbeiter(MitarbeiterNr) );

CREATE TABLE belegt ( AufenthaltsNr INTEGER NOT NULL, ZimmerNr INTEGER NOT NULL, von DATE NOT NULL, bis DATE NOT NULL, PRIMARY KEY (AufenthaltsNr, ZimmerNr), FOREIGN KEY (AufenthaltsNr) REFERENCES Aufenthalt(AufenthaltsNr), FOREIGN KEY (ZimmerNr) REFERENCES Zimmer(ZimmerNr) );

