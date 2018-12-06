# Contributing Guidelines
bitte einmal komplett lesen :)

# Git 
- Download & Install git
- Erstelle eine account auf [github](https://github.com "github")

#### User Config
Run
```
git config --global user.name "Your Name"
git config --global user.email "your_email@whatever.com"
```

#### Clone Repository
```
git clone https://github.com/lhrb/swec8.git
```

### Wichtig niemals im master branch arbeiten!!!
Ein Merge in den Master Branch findet erst nach dem Code Review statt.

#### Erstelle einen Feature Branch

```
git checkout -b feature_name
```
Bitte den Präfix "feature" benutzen, name sollte aussagekräftig sein

#### Add
nach der Bearbeitung einer Datei kann man diese mittels
```
git add dateiname
```
dem Index hinzufügen.

#### Commit
Die Datei zum HEAD hinzufügen
```
git commit -m "commit message"
```
- <b>Präfixe wie "Add, Fix, Update, Create, Delete, Remove" benutzen!</b>
- Versuchen jede Änderung, wenn möglich, in einen einzelnen Commit
- Einen mehrzeiligen Commit erstellt man, indem man die Anführungzeichen nicht schließt.
```
git commit -m "Add ....
Create ...
Update ... "
```
Commit mit Titel und Beschreibung
```
git commit -m "Titel" -m "Beschreibung"
```
#### Push
Die Dateien zum Repository senden
```
git push origin branch_name
```
branch_name ist der name eures feature branch ;)

#### Update
Euer Repo kann mittels
```
git pull
```
auf den neusten Stand gebracht werden d.h. alle branches werden gepulled.
Um den <b>master branch</b> auf den neuesten stand zu bringen
```
git pull origin master
```
<b>Achtung</b> wenn ihr eclipse benutzt müsst ihr evtl mal 
```
gradlew eclipse
```
ausführen um alle Datein der ide hinzuzufügen.

#### Branching
In einen anderen Branch wechseln 
```
git checkout branchname
```
Branch löschen
```
git branch -d branchname 
```

#### [.gitignore](.gitignore)
sollte gepflegt werden. Bitte keine localen configs etc. in das repository pushen
[zum weiterlesen](https://git-scm.com/docs/gitignore)

#### Pull Konflikte
Es gibt 3 Möglochkeiten

Lokale änderungen verwerfen
```
git fetch --all 
git reset --hard origin/branch_name
```
Lokale änderungen, die bereits im HEAD sind, in einem branch speichern
```
git checkout master
git branch new-branch-to-save-current-commits
git fetch --all
git reset --hard origin/master
```
Uncommited Changes speichern
```
git stash
```

#### Zum weiterlesen
- (https://rogerdudler.github.io/git-guide/)
- (https://githowto.com/)
- (https://git-scm.com/doc)

## Generelle Konventionen
zum erhöhen der Lesbarkeit
- Nach ~90 Spalten einen Zeilenumbruch verwenden
- keine Tabs nur Leerzeichen verwenden!
- Mindestens 2 Leerzeichen zum einrücken verwenden (besser 4)
- versuchen Englische Begriffe zu verwenden

## Bezeichnungen
|Typ | Regel | Beispiel |
|----|:-----:|----------|
| Klassen | Name sollte ein Nomen sein. Das erste Wort muss mit einem Großbuchstaben beginnen | class ImageSprite; | 
| Interfaces | Name muss mit Großbuchstaben beginnen | interface RasterDelegate; | 
| Methoden | Name sollte ein Verb sein und mit einem Kleinbuchstaben beginnen | runFast(); |
| Variablen | möglichst aussagekräftige Namen verwenden. Mit Kleinbuchstaben beginnen | int screenWidth; |
| Konstanten | Nur Großbuchstaben, Wörte sind mit Underscore ("_") zu trennen | static final int SCREEN_WIDTH; |
| Packages | nur Kleinbuchstaben| com.github.lhrb.sinnvollerpaketpfad

## Kommentare
Jede Klasse/Methode <b>muss</b> kommentiert werden!

Im Kommentarblock über der Klasse/Methode muss angegeben, 
welche Funktionalität zur Verfügung gestellt wird. 
Also "<b>Was</b> macht die Klasse/Methode". 
Das "Wie" kann, falls notwendig, mit inline Kommentaren beschrieben werden.
```java
/**
 * Angeben was die Methode macht
 * @param x beschreibtung 
 * @return beschreibung
 * @throws Exception beschreibung
*/
public int beispiel(int x) throws Exception{
  //inline Kommentare können hilfreich sein
  return 1;
}
```
Es gibt noch viel mehr [javadoc tags](https://www.tutorialspoint.com/java/java_documentation.htm)

## Test Klassen
[JUnit](https://junit.org/junit4/ "junit4") 
- Zu jeder Klasse muss eine entsprechende JUnit Test Klasse angelegt werden!
- Jede Methode braucht eine entsprechende Test Methode!
- Es sollte mindestens ein Test Case dargestellt werden 
- Die Test Klassn/Methoden haben den gleichen Namen mit dem Präfix "Test" zb. TestKlassenName

## Exception Handling
Exceptions sind in Java "teuer", deshalb versuchen Exceptions mittels Kontrollabfrage auszuschließen
```java
//good practice
if(obj != null){
  obj.operation();
  //....
}

//bad practice
try{
  obj.operation();
}catch(NullPointerException e){
  //...
}
```
- "Behandelbare" Exceptions so früh wie möglich beheben! 
- Alle anderen mittels "throw" weiterleiten
- Exceptions sind <b>nicht</b> als Kontrollfluß Elemente zu Missbrauchen!!!
- Aussagekräftige Exceptions verwenden [Exception](https://docs.oracle.com/javase/10/docs/api/java/lang/Exception.html), 
[RuntimeException](https://docs.oracle.com/javase/10/docs/api/java/lang/RuntimeException.html)
- Eigene Exceptions sind im gleichen Paket, wie die Klasse, die diese wirft abzulegen 

## Filestructure
Source code ablegen unter
```
src/main/java/com/github/lhrb/myshooter/paketname/ClassName.java
```
die Test Klassen unter
```
src/test/gleicherPfadWieDieZuTestendeKlasse/TestKlasse
zb.
src/test/java/com/github/lhrb/myshooter/paketname/TestClassName.java
```
Resourcen wie zb. Bilder werden im Wurzelverzeichnis unter
```
resources/sinnvollerOrdnerName/
zb
resources/img/
resources/config/
```

# Gradle 
[Download & Install](https://gradle.org/install/ "gradle") gradle

#### Verfügbare tasks ansehen
```
gradle tasks
```
#### Das Project ausführen
```
gradle run
```

### IDE einrichten
Es können im moment nur für Eclipse und IntellJ alle benötigten Dateien erstellt werden.
Solltet ihr noch eine andere IDE benutzten achtet bitte darauf, die von diesem Program evtl erstellten Dateien
in der [.gitignore](.gitignore) anzugeben.
Um diese zu erstellen einfach
```
gradle eclipse
bzw.
gradle idea
```
ausführen. Das Projekt kann dann in die entsprechende IDE importiert werden.
Für weitere Hilfestellung benutzt eine [Suchmaschine](https://duckduckgo.com/ "DuckDuckGo") eurer Wahl

### Dependencies
Falls ihr externe Dependencies verwenden wollt/müsst, sucht das entsprechende Artifact auf 
[MavenCentral](https://mvnrepository.com/ "MavenCentral").
Das Code snippet, welches ihr zur [build.gradle](build.gradle) unter dependecies { ... }, hinzufügen müsst, 
könnt ihr direkt von der Seite Maven Repository kopieren. 

Falls ihr eine der oben genannten IDE's benutzt müsst ihr nocheinmal zb den "gradle eclipse" task ausführen
und ggf. eure IDE aktualieren (F5)

### Testing
eure Unit Tests könnt ihr mit dem Task
```
gradle test
```
ausführen. Es wird dann ein Webinterface mit den Ergebnissen angelegt.  
