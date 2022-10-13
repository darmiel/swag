<p align="center">
  <img src="./assets/ahpe.png" alt="ape sitting on a desk and reading a book" height="316px">
</p>

# AHPE

> **A**HPE **H**ELPS **P**ASSING **E**XAMS

## File

Verschieden Dateioperationen:

### Lesen

```java
final File file = new File("hello.txt"); 

// 'Hallo Welt!' in Datei schreiben
AhpeFile.append(file, "Hallo Welt!")

// 'Hallo Welt!\n' in Datei schreiben
AhpeFile.appendLine(file, "Hallo Welt!")

// In Datei mit max. 5 Zeilen schreiben
for(int i = 0; i < 20; i++) AhpeFile.appendLineMax(file, "hi" + i, 2);
// in Datei steht:
// [ 1 ] hi18
// [ 2 ] hi19
```

### Schreiben

```java
final File file = new File("hello.txt"); 

// Alle Zeilen aus Datei lesen
for (final String line : AhpeFile.readLines(file)) {
    System.out.println(line);
}

// Die ersten 5 Zeilen aus Datei lesen
for (final String line : AhpeFile.readFirstLines(file, 5)) // ...

// Die letzten 5 Zeilen aus Datei lesen
for (final String line : AhpeFile.readLastLines(file, 5)) // ...
```

### Parsen

Falls irgendwelche Daten aus einer Datei "geparsed" werden sollen (z. B. im CSV Format),
kann ggf. die `AhpeFile#parseSeparatedFile`-Methode helfen.

In folgenden Fall kann man die Daten einfach parsen:

```
peter,22,deutschland
max,24,schweiz
martin,26,niederlande
```

In folgendem Fall wird es schwierig die Daten mit der Methode zu parsen:
```
name: peter, alter: 22, land: deutschland
name: max, alter: 24, land: schweiz
name: martin, alter: 26, land: niederlande
```

Sollten die Daten in einem einfachen Format sein:

1. Passende Klasse mit passendem Konstruktor (public!) zu Daten erstellen
```java
class Person {
    // ...
    public Person (final String name, final int age, final String country) {
        // ...
    }
}
```

2. Daten auslesen
```java
final List<Person> persons = AhpeFile.parseSeparatedFile(file, ",", Person.class);
```

## Misc

* `a <= b <= c` 
  * `boolean res = AhpeMisc.between(a, b, c)`
* `a < b < c`
  * `boolean res = AhpeMisc.betweenEx(a, b, c)`
* ROT-13 Enkodierung
  * `String rot13 = AhpeMisc.rot13("Hello!")`
* Zufalls-Farbe
  * `Color random = AhpeMisc.randomColor()`
* Zufalls-Zahl (zwischen)
  * `int random = AhpeMisc.randomNumber(12, 19)`
* Zufallswert aus Array
  * `int random = AhpeMisc.randomArray(new int[] {1, 4, 6, 233, 12})`
* Zufalls-Enum
  * `MyEnum random = AhpeMisc.randomArray(MyEnum.values())`
* Kleinster Wert
    * `int/double/float random = AhpeMisc.min(1, 4, 6, 2, 0)`
* Größter Wert
  * `int/double/float random = AhpeMisc.max(1, 4, 6, 2, 0)`

## Dialog

Aliases zu `JOptionPane`:

![](./assets/dialog.png)

```java
ApheDialog.info("Hello", "World");
ApheDialog.warn("Hello", "World");
ApheDialog.error("Hello", "World");
```

## Thread

Aktion nach 10s ausführen

```java
AhpeThread.after(10, TimeUnit.SECONDS, () -> {
    // ... 
});
```

## Swing (Swag)

### Enum Radio Button Group

Zeigt Radio Buttons mit den Werten von einem Objekt (oder Enums) an.  
Beim Wechsel wird `onChange` mit dem neuen State aufgerufen.

![](assets/swing-radio.png)

```java
enum State {
    ONLINE,
    OFFLINE,
    DND
}
// ...
final JPanel panel = Radio.group(State.OFFLINE, State.ONLINE, State.DND) // or Radio.group(State.values())
    .onChange(state -> { // also available as onChange(BiConsumer<T, ActionEvent>)
        System.out.println("Switched State to: " + state);
    })
    .asPanel();
```

---

### Placeholders

Die `Placeholder`-Klasse erlaubt es, Platzhalter in `JTextField`s und `JTextArea`s anzuzeigen:

https://user-images.githubusercontent.com/71837281/195694951-6f9f1007-491b-4b0e-ad6b-13a562604783.mov

> `Placeholder#extend(String, [JTextField, JTextArea, JPasswordField])`

```java
final JTextField nameField = new JTextField();
final JTextField ageField = new JTextField();
// ...
this.add(Placeholder.extend("Name", nameField));
this.add(Placeholder.extend("Alter", ageField));
```

---

### Component Builders

Ein paar Builder Klassen zum schnelleren Erstellen von Layouts / Controls

#### Grid

![](./assets/swing-grid.png)

```java
this.add(Grid.builder()
        .headers("Name", "Age", "Action")
        .with("Peter", 32, "Cannot be fired")
        .with("Max", 19, new Button("Fire"))
        .with("Simon", 40, "Cannot be fired")
        .build());
```

Kann auch für Eingabfelder verwendet werden:

![](./assets/swing-grid-2.png)

```java
this.add(Grid.builder()
        .with("Name", Placeholder.extend("Name", new JTextField()))
        .with("Alter", Placeholder.extend("Alter", new JTextField()))
        .with("Adresse", Placeholder.extend("Adresse", new JTextField()))
        .with("Geschlecht", Placeholder.extend("Geschlecht", new JTextField()))
        .build());
```


#### Buttons and Layouts

```java
this.add(Box.vertical()
    .with(Header.of("Knopf"))
    .with(Placeholder.extend("Name",new TextField()
            .enter(() -> System.out.println("Pressed Enter!")))
        )
    .with(Box.horizontal()
        .with(new Button("Klick")
            .click((event) -> System.out.println("Ich wurde geklickt"))
            .focus())
        .with(new Button("Mich auch")
            .click(this::handleClick)
            .disable())
    )
    .with(Grid.builder()
        .headers("Name", "Alter")
        .with("Peter", 12)
        .with("Max", new Button("Loeschen")
        .click((event) -> delete("Max"))
    ))
);
```