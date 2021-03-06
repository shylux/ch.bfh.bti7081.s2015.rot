#Case Study1: Task2

## Aufgabe 1

###Ergebnisse 1. Analyse
Das Projekt kann in mehrere Teilprojekte aufgeteilt werden, deshalb ist es nicht notwendig alle Teilprojekte mit der selben Projektplanungsmethode durchzuführen.
Die Teilprojekte sind grob wie folgt festzulegen:

* Termine, Behandlung, medikamentöse Behandlung für **patients**
* Termine, Behandlung, Behandlungsübersicht für **doctors/Nurses/Health Visitors**
* Terminplanung für **receptionists**
* Berichterstellung für Management **Clinical Record Staff**

Die Teilprojekte lassen sich auf einzelne Usergruppen herunterbrechen.  
Da es sich um einen komplett neuen Ablauf im Gesundheitssystem handelt, und sich generell die Prozesse im Gesundheitswesen momentan im Wandel befinden (Einheitskrankenkassen, Personalreduzierung Spitex), können sich die Projektanforderungen im Laufe des Projekts verändern. Ein zu detailliertes Requirent Engineering ist demnach nicht empfehlenswert.
Weiterhin kann davon ausgegangen werden, dass die Software kontinuierlich weiterentwickelt wird.

Jedoch müssen die „Legislation Requirements“ 	im Vorfeld genau definiert und spezifiziert werden, da es sich bei diesem Requirements um „Critical Success Factors“ handelt.

Weiterhin kann davon ausgegangen werden, dass die Software kontinuierlich weiterentwickelt wird.
Gemäss diesem Aspekt ist ein agiles Prozess Modell vorzuziehen, aber mit einer detaillierteren initialen Analyse und Spezifikationsphase. 

###Customer / Users
Die Zusammenarbeit mit dem Kunden sollte unproblematisch sein. Jedoch um die Software zu testen und realistisches Feedback zu erhalten, braucht es ein Feedback von den Usern, welche das System nutzen werden.
Nicht mit allen Usergruppen kann eine kontinuierliche Zusammenarbeit vorausgesetzt werden.
Ärzte haben in der Regel kaum Zeit und die Patienten sollten nicht zu oft belästigt werden.
Deshalb eignet sich für die Teilprojekte 1 und 3 nur bedingt eine agile Vorgehensweise.  Diese Projekte sind Plan-Driven zu entwickeln.
Für die Teilprojekte 2 und 4 erachten wir die agile Vorgehensweise als unproblematisch.
Gemäss diesem Aspekt ist ein Plan-Driven Prozessmodell oder Mischform vorzuziehen.

###Team
Alle Teammitglieder haben praktische Erfahrung in den Prozessmodellen HERMES und Extreme Programming. Unser Team besteht aus 6 Personen. Wobei die meisten Entwickler am liebsten agil entwickeln. Die Kommunikation ist über mehrere Kanäle sichergestellt und stellt kein Problem dar. Aus diesem Grund ist ein agiles Prozess Modell vorzuziehen.

###Fazit
|Pro Agil   | Pro Plan-Driven |
|---------- |---------------- |
|Gesundheitsbranche befindet sich im Wandel|Patienten und Ärtzte können nur begrentzt ins Projekt involviert werden|
|Teammitglieder entwickeln lieber agil|„Legislation Requirements“ erfordern genaue Planung|
|Anforderungen können sich ändern||
|System wird laufend weiterentwickelt||

Wir entscheiden uns deshalb für eine Mischform. Die Vorgehensweise ist iterativ, aber die Iterationen sind länger als bei den üblichen Iterativen Prozessmodellen. Dies ermöglicht ebenfalls das Requirement Engineering umfangreicher zu gestalten.

Aus Zeitgründen wird die Scrum-Retrospektive nur bei Bedarf durchgeführt und  so kurz wie möglich gehalten. 

## Aufgabe 2

# Prozess Modell für MHC-PMS

## Zweck des Dokuments
Dieses Dokument soll allen Projektbeteiligten aufzeigen welche Rolle sie im Projekt wahrnehmen und in welchen Aktivitäten sie integriert sind.

## Stakeholder
Folgende Stakeholder sind im Projekt involviert.
- Medizinalstab
- Ärzte
- Krankenpfleger
- Patienten
- Receptionisten
- Kunde

## Genereller Ablauf
Wir verwenden eine Abwandlung von dem Prozess Model [Scrum](http://de.wikipedia.org/wiki/Scrum).
Die Entwicklung erfolgt iterativ. Jedoch sind die Iterationen länger als bei Scrum. Zusätzlich wird das Daily Scrum Meeting  wöchentlich abgehalten, da das Entwicklerteam nicht am selben Ort arbeiten. Dies setzt eine präzisere Spezifikation zu Beginn einer Iteration. Vorteil davon ist, dass dadurch die Testakteure (Doktoren und Patienten) weniger belastet werden.

## Prozess Model

### Visualisierung des Projektmodells

![alt tag](https://github.com/shylux/ch.bfh.bti7081.s2015.rot/blob/master/doc/task02/Scrumrum.png)

### Phase 1: Planung
Zu Beginn definiert der Kunde und das Entwicklerteam die Aufgaben.

#### Involvierte Akeure
- Kunde
- Entwicklungsteam

#### Ziele
Backlog für diese Iteration erstellen.

#### Beziehung zwischen anderen Phasen/Artekfaten
Das Ergebnis der letzten Iteration beeinflusst den Backlog.

#### Artefakte
- Produkt Backlog

### Phase 2: Design / Entwicklung

Aus dem Backlog werden User Stories und Tasks generiert. Bei Unklarheiten/Bedarf Rücksprache mit dem Kunden. 
1x pro Woche ist ein teaminternes Meeting, um den Projektstand und evt. Risiken zu überprüfen.
Ansonsten wird in dieser Phase die Applikation entwickelt.

#### Involvierte Akeure
- Entwicklungsteam
- Kunde 

#### Ziele
Lauffähige Software anhand des Backlogs erstellen.

#### Beziehung zwischen anderen Phasen/Artekfaten
Diese Phase baut auf dem Backlog auf.

#### Artefakten
- Taks
- User Stories
- Lauffähiges Produkt
- Testprotokoll
- Ergebnis Weekly Scrum

### Phase 3: Testen
Das lauffähige Programm wird von den Akteuren getestet. Ergebnisse werden schriftlich festgehalten um allfällige Fehler später reproduzieren zu können. 
**Hinweis** Meistens ist nur ein Teil der Aktuere daran beteiligt. (Je nachdem welche Teilprojekte in der entsprechenden Iteration bearbeitet wurden)

Nach dem Testen ist mit dem Kunden ein Review zu halten und allenfalls der Backlog anzupassen. Wenn alle Anforderungen erfüllt und allfällige Fehler behoben sind, ist das Projekt fertig.

#### Involvierte Akteure
- Medizinalstab
- Doktoren
- Patienten
- Krankenpfleger
- Health Visitors
- Entwicklungsteam
- Kunde

#### Ziele
Fehler in der Software zu finden. Feedback der User zu erhalten.

#### Beziehung zwischen anderen Phasen/Artefakten
Diese Phase benutzt das in Phase 2 erstellte Testprotokoll.
Der Backlog wird aktualisiert.

### Artefakte
- Testbericht
- Feedback an Kunde/Entwicklerteam
- Ergebnis Sprint Review
