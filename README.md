# Reversi

🎯 **Project** for Software Development Methods (Java + Gradle + TDD)

This is a **console-based Reversi game** (8x8 board), written in **Java**, using **Gradle** and **JUnit 5** for testing.  
It was created to apply concepts from the Software Development Methods course:  
✅ Object-Oriented Programming  
✅ Test-Driven Development (TDD)  
✅ Clean and simple design  
✅ Continuous Integration ready (Gradle)

---

## 📂 Project Structure

```
src/
├── main/
│   └── java/
│       └── reversi/
│           ├── Main.java       # Console game runner
│           └── Board.java      # Game logic (board, moves, score)
└── test/
    └── java/
        └── reversi/
            └── BoardTest.java  # Unit tests with JUnit 5
```

---

## ▶️ How to Run the Game

```bash
./gradlew run
```

Then follow the instructions in the terminal.  
Players take turns entering **row and column** (e.g., `2 3`) to place pieces.

---

## ✅ How to Run the Tests

```bash
./gradlew test
```

Tests are written using **JUnit 5** in the `BoardTest.java` file.

---

## 🧪 Example Tests Included
- Board initialization with correct starting pieces
- Valid move detection
- Move application and flipping pieces
- Game over condition
- Score calculation

---

## 💬 Notes
- No GUI (Swing) is used to keep it simple and beginner-friendly
- Easy to extend: you can add classes like `Player` or add new features step by step

---

## 🔧 Tech Used
- Java 17+
- Gradle
- JUnit 5
