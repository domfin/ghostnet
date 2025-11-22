# Ghost Net Fishing – Fallstudie

Dieses Repository enthält die Projektdateien zur Fallstudie im Kurs  
**IPWA02-01 – Interaktive Webanwendungen** an der IU Internationale Hochschule.

## Projektbeschreibung

Ziel des Projekts ist die prototypische Entwicklung einer einfachen Webanwendung zur Meldung und Verwaltung von Geisternetzen.  
Nutzer:innen können Netze mit Standort, Größe und Beschreibung erfassen, den Status im Bergungsprozess aktualisieren und bergende Personen verwalten.

Die Anwendung wurde mit **Jakarta EE (JSF, JPA)** umgesetzt und läuft vollständig lokal über **Payara Micro**.  
Eine H2-Datenbank wird automatisch erzeugt.

## Enthaltene Dateien

- `src/` – Java-Quellcode (Controller, Repositories, Entities)
- `webapp/` – JSF-Seiten (`index.xhtml`, `netz-bearbeiten.xhtml`, `personen.xhtml`)
- `tools/payara/payara-micro.jar` – Payara Micro Runtime
- `run.bat` – Startskript für das Projekt
- `pom.xml` – Maven-Projektkonfiguration
- `README.md` – Diese Projektbeschreibung

Automatisch erzeugte Ordner:
- `db/` – Lokale H2-Datenbankdateien
- `payara_rt/` – Arbeitsverzeichnis von Payara Micro
- `target/` – Generiertes WAR-File

## Systemvoraussetzungen

| Software | Version |
|----------|---------|
| **Java JDK** | 21 |
| **Windows** | empfohlen |

Keine zusätzliche Installation von Datenbanken oder Servern notwendig.

## Start der Anwendung

1. Projekt nach **C:\work\ghostnet\\** kopieren.  
2. Java-Version prüfen: java -version
3. `run.bat` ausführen.  
4. Browser öffnen und aufrufen: http://localhost:8080/ghostnet

Die Anwendung ist danach sofort einsatzbereit.

## Funktionen

- Meldung neuer Geisternetze (Standort, Größe, Beschreibung)
- Statusverwaltung: *GEMELDET*, *BEVORSTEHEND*, *GEBORGEN*, *VERSCHOLLEN*
- Bearbeiten bestehender Einträge
- Verwaltung bergender Personen
- Persistente Speicherung durch automatische H2-Datenbank

## Hinweis

Dieses Projekt wurde im Rahmen einer Fallstudie erstellt und dient der exemplarischen Umsetzung einer einfachen Jakarta-EE-Webanwendung.  
Der Fokus liegt auf Verständlichkeit, Nachvollziehbarkeit und einer klaren Struktur — nicht auf Produktionsreife.


