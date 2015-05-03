# Softwarearchitektur
## Vaadin Framework
## Systemanforderungen
### Datenpersistenz

Die PatientApp benötigt lokale Daten, da eine Verbindung zum Klinikserver nicht immer möglich oder erwünscht ist. MongoDB ist eine einfache, quelloffene und perfomante Lösung. Es ist die am weitesten verbreiteste NoSQL-Datenbank, verwendet also keine SQL Abfragen um Daten zu erstellen, erhalten oder manipulieren. Schematas der Daten können im mächtigen Format JSON ("JavaScript Object Notation") abgelegt werden. JSON ist ein weit verbreitetes Textformat, um Informationen auszutauschen oder speichern. Der grosse Vorteil dabei ist, dass JSON-Texte immer in Objekte umgewandlet werden können und umgekehrt. Da Vaadin aus dem in Java geschriebenen Programm eine Webapplikation erstellt, entsteht kein direkter Technologieumbruch, was die Unterstützung von MongoDB weiter befürwortet. Eine MongoDB besteht grundsätzlich aus einer Textdatei auf dem Dateisystem - es ist kein DBMS notwendig. Die Kommunikation mit den Daten übernimmt das MongoDB-Objekt, das es in praktisch allen Programmiersprachen gibt.  

### GPS & Foto

Die zu entwickelnde Applikation benutzt für das Spiel "LifeUp" in gewissen Fällen GPS-Koordinaten, um beispielsweise das Erreichen oder Besuchen eines bestimmten Ortes zu überprüfen. Das Framework Vaadin, das verwendet wird, übersetzt mithilfe des GWTKs das in Java geschrieben Progamm in eine Webapplikation. Während in der Standard Androidentwicklungsumgebung GPS eine häufige und unterstüzte Komponente ist, kann das Vaadin-Framework eine solche Unterstützung nicht vollständig gewährleisten. Die HTMl5 Funktion, die Vaadin verwendet, nennt sich GPS.getIfSupported(). Falls das GPS auf dem Endgerät nicht benutzt werden kann, muss eine solche GPS-Funktionalität simuliert, respektive darauf reagiert werden, damit das LifeUp-Spiel keine Aktivitäten vorschreiben kann, die nicht überprüfbar sind. Das genaue Vorgehen für das Simulieren ist nocht ausstehend.

Ein ähnliches Problem existiert auch für die Foto-Komponente, die im Spiel verwendet werden soll. Vaadin hat keinen Zugriff auf solche Bauteile. Das Problem, dass das Aufnehmen von Fotos nicht möglich ist, wird durch eine einfache Umgehung gelöst: Es können lokale Bilder, die sich auf dem Endgerät befinden, hochgeladen werden. Diese werden dann wie als neues Foto behandelt. 
 
 
## Patterns
### MVC
#### Modell
#### View
#### Controller

### MVP
#### Modell
#### View
#### Presenter
### Vaadin MVP
### Implementation

## Softwarearchitektur
## Appendix
