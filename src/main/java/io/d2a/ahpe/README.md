<p align="center">
  <img src="./assets/ahpe.png" alt="ape sitting on a desk and reading a book" height="316px">
</p>

# AHPE

> **A**HPE **H**ELPS **P**ASSING **E**XAMS

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