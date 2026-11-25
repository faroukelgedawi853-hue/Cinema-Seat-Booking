# Cinema Seat Booking — HashMap Task

A Java console project for practicing `HashMap` and `HashSet` when a custom class (`Seat`) is used as a key.

## Requirements

- Java JDK 8 or later
- A terminal or IDE such as IntelliJ IDEA / VS Code

## Project structure

```text
CinemaSeatBooking/
├── src/
│   └── Task_CinemaBooking.java
└── README.md
```

## How to run

Open a terminal in the project folder and run:

```bash
javac -d out src/Task_CinemaBooking.java
java -cp out Task_CinemaBooking
```

In VS Code, you can also open the project folder and run `Task_CinemaBooking.java` if the Java extensions are installed.

## What the program demonstrates

- Part A: adding bookings with `put()`
- Part B: retrieving a booking with `get()`
- Part C: checking a key with `containsKey()`
- Part D: attempting a booking with `putIfAbsent()`
- Part E: moving a booking with `remove()` and `put()`
- Part F: tracking broken seats with `HashSet` and checking with `contains()`
- Part G: counting bookings with `size()`
- Overriding `equals()` and `hashCode()` in the `Seat` class

## Important note

The `Seat` class uses `row` and `number` to determine whether two seat objects represent the same seat. The fields are `final` so a seat's identity cannot change after the object is created.

## Assignment questions

Write your own answers to the questions from the original task here. They have intentionally been left unanswered.

1. Why did we have to override `hashCode()` and `equals()`?
2. Delete `hashCode()` but keep `equals()`, and run again. What happens? Why?
3. Why are `row` and `number` `final`? What could go wrong if the number of a booked seat could be changed after it was put in the map?
4. Change `equals(Object o)` to `equals(Seat o)`. What happens? Then also remove `@Override` and run again. What happens now?
5. BONUS: Replace the whole `Seat` class with `record Seat(char row, int number) {}`. Run it. What happens, and why?

## GitHub

Create a new public repository on GitHub, then from the project folder run:

```bash
git init
git add .
git commit -m "Complete cinema seat booking HashMap task"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPOSITORY.git
git push -u origin main
```

Replace the remote URL with your own repository URL.
