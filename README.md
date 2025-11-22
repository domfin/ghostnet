# Ghost Net Fishing – Fallstudie

Dieses Repository enthält die Projektdateien zur Fallstudie im Kurs  
**IPWA02-01 – Interaktive Webanwendungen** an der IU Internationale Hochschule.

## Projektbeschreibung

Ziel des Projekts ist die prototypische Entwicklung einer einfachen Webanwendung zur Meldung und Verwaltung von Geisternetzen.  
Nutzer:innen können Netze mit Standort, Größe und Beschreibung erfassen, den Status im Bergungsprozess aktualisieren und bergende Personen verwalten.

Die Anwendung wurde mit **Jakarta EE (JSF, JPA)** umgesetzt und läuft vollständig lokal über **Payara Micro**.  
Eine H2-Datenbank wird automatisch erzeugt.

## Enthaltene Dateien

### Quellcode & Konfiguration
- `src/main/java/` – Java-Quellcode (Controller, Repositories, Entities)
- `src/main/resources/` – Ressourcen (u. a. `persistence.xml`)
- `src/main/webapp/` – JSF-Seiten (`index.xhtml`, `netz-bearbeiten.xhtml`, `personen.xhtml`)
- `pom.xml` – Maven-Konfiguration  
- `run.bat` – Startskript für das Projekt  
- `README.md` – Diese Projektbeschreibung

### Payara Micro (aufgrund GitHub-Limit geteilt)
Im Verzeichnis: tools/payara/ liegen vier Archive:

- payara-micro.zip.001
- payara-micro.zip.002
- payara-micro.zip.003
- payara-micro.zip.004

Diese ersetzen die ursprüngliche `payara-micro.jar`, weil GitHub einzelne Dateien nur bis **25 MB** akzeptiert.

**So wird die Datei wiederhergestellt:**

1. Alle vier Dateien in denselben Ordner legen:  
   `tools/payara/`
2. Rechtsklick → „Alle extrahieren“
3. Das Ergebnis ist: tools/payara/payara-micro.jar

Diese Datei wird **für den Start zwingend benötigt**.

### Automatisch erzeugte Ordner:
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
2. Die vier Payara-Archive im Ordner `tools/payara/` **wieder zu einer Datei zusammenführen**:
- payara-micro.zip.001
- payara-micro.zip.002
- payara-micro.zip.003
- payara-micro.zip.004
→ Alle vier Dateien markieren → Rechtsklick → *„Alle extrahieren“*  
→ Ergebnis:
tools/payara/payara-micro.jar
3. Java-Version prüfen: java -version
4. `run.bat` ausführen.  
5. Browser öffnen und aufrufen: http://localhost:8080/ghostnet

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


