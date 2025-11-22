# Ghost Net Fishing – Fallstudie

Dieses Repository enthält die Projektdateien zur Fallstudie im Kurs  
**IPWA02-01 – Interaktive Webanwendungen** an der IU Internationale Hochschule.

## Projektbeschreibung

Ziel des Projekts ist die prototypische Entwicklung einer einfachen Webanwendung zur Meldung und Verwaltung von Geisternetzen.  
Nutzer:innen können Netze mit Standort, Größe und Beschreibung erfassen, den Status im Bergungsprozess aktualisieren und bergende Personen verwalten.

Die Anwendung wurde mit **Jakarta EE (JSF, JPA)** umgesetzt und läuft vollständig lokal über **Payara Micro**.  
Eine H2-Datenbank wird automatisch erzeugt.

## Projektstruktur (Auszug)

- `pom.xml` – Maven-Projektkonfiguration  
- `run.bat` – Startskript für Payara Micro und Deployment  
- `src/main/webapp/` – JSF-Seiten (`index.xhtml`, `netz-bearbeiten.xhtml`, `personen.xhtml`)  
- `src/main/java/` – Java-Code (Entities, Repositories, Controller, Setup)  
- `src/main/resources/META-INF/persistence.xml` – JPA-Konfiguration  
- `tools/payara/` – Verzeichnis für die Payara-Micro-JAR (siehe unten)  

Automatisch erzeugte Ordner (nicht im Repo notwendig, werden lokal angelegt):

- `db/` – H2-Datenbankdateien  
- `target/` – Build-Output (WAR-Datei)  
- `payara_rt/` – Laufzeitverzeichnis von Payara Micro

## Payara Micro

Aus Platzgründen ist **Payara Micro nicht im Repository enthalten**.  
Für den Start der Anwendung wird eine Payara-Micro-6.x-Version benötigt.

### Payara Micro herunterladen

1. Download-Seite öffnen: https://payara.fish/downloads/payara-platform-community-edition/ 
2. Die aktuelle 6.x-Version von Payara Micro als JAR herunterladen.  
3. Datei in folgendem Ordner ablegen: C:\work\ghostnet\tools\payara\payara-micro.jar
4. Falls der Download einen anderen Namen trägt  
(z. B. `payara-micro-6.2025.x.jar`), bitte in **payara-micro.jar** umbenennen.

Getestet wurde die Anwendung mit einer 6.x-Version von Payara Micro.

## Systemvoraussetzungen

| Software | Version |
|----------|---------|
| **Java JDK** | 21 |
| **Windows** | empfohlen |

Keine zusätzliche Installation von Datenbanken oder Servern notwendig.

## Start der Anwendung

1. Projekt nach **C:\work\ghostnet\\** kopieren.  
2. Payara Micro wie oben beschrieben herunterladen und ablegen unter: C:\work\ghostnet\tools\payara\payara-micro.jar
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


