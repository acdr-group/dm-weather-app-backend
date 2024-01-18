# dm Weather-App
Das  ist das Backend für die dm Weather App. Es ist in Java geschrieben und nutzt Spring Boot.

## Projekt starten
Das Projekt kann mit folgendem Befehl gebaut werden:
`./gradlew bootRun`
Falls der Befehl nicht funktioniert, sollte man gradlew ausführbar machen, dazu führt man diesen Befehl aus: `chmod +x gradlew` 

Zum Stoppen benutzen Sie `Ctrl + C`.

## Tests
Die Tests können mit folgendem Befehl ausgeführt werden:
`./gradlew test`

## Docker
Im Wurzelverzeichnis DB starten:
`docker compose up`

Docker Image des Projekts bauen: 
`docker buildx build <IMAGE_NAME_UND_TAG>`

Umgebungsvariablen je nach Umgebung setzen (Dies kann auch in die compose.yaml Datei fürs Docker-Image gesetzt werden): 
`WEATHERAPPAUTHENTICATION_ACCESSTOKEN=86c42a625b5936d0f923264babb0dd90 & WEATHERAPPAUTHENTICATION_APIBASEURL=https://api.openweathermap.org/data` 
## Authoren

- Ramses II Tetang
- Chloe Chan
- Dominik Schwemmle
- Alexey Safonov