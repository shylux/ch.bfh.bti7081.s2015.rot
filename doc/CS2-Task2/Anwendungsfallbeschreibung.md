#Anwendungsfallbeschreibung (Use Case Scenario)

| Nr. und Name |  1. Blutzuckerspiegel messen |
|---|---|
| Szenario  |  Intervallgesteurte Blutzuckermessung |
| Kurzbeschreibung | Blutzuckerspiegel wird gemessen und ausgwertet |
| Beteiligte Akteure  | Sensor, Patient  |
| Auslöser / Vorbedingung  | Vordefiniertes Zeitinterval, eingeschaltetes System  |
| Ergebnisse / Nachbedingung  |   |

##Ablauf
| Nr. | Wer | Was |
| --- | --- | --- |
| 1 | System | Timer wird gestartet |
| 2 | System | Nach abgelaufenem, vordefiniertem Interval wird Messung ausgelöst |
| 3 | System | Messung wird ausgewertet |
| 4 | System | Entscheid Verabreichung |

##Ausnahmen, Varianten
| Nr. | Wer | Was |
| --- | --- | --- |
| 4.1 | System | Falls Blutzuckerspiegel zu hoch -> Verabreichung starten (Option: Insulin verabreichen) |
| 4.1.1 | System | Falls zu hoch: Verabreichen |
| 4.1.2 | System | Falls viel zu hoch: Verabreichen und Warnung ausgeben |
| 4.1.3 | System | Falls zu tief: Warnung ausgeben |
| --- | --- | --- |
| 4.2 | System | Gehe zu Nr. 1 |
