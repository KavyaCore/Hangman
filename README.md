# 🎯 Hangman (Console Game)

A classic word-guessing game built in Java. Guess the hidden word one letter at a time before you run out of attempts.

Built while practicing arrays, random selection, and working with individual characters in a string.

## Features

- Random word picked from a word bank each game
- Tracks guessed letters and shows progress (`_ a v a` style)
- Prevents guessing the same letter twice
- Limited wrong guesses (6) before the game ends
- Clear win/lose messages showing the final word

## Tech Used

- Java
- Arrays (`String[]` word bank, `boolean[]` to track guessed letters)
- `Random` class for word selection
- Character-by-character comparison with `charAt()`
- Kept intentionally simple: only plain `if-else`, indexed `for` loops, and a `while` loop — no `StringBuilder`, `indexOf()`, `continue`, or for-each loops, so every line follows the same familiar pattern

## Project Structure

```
hangman/
├── Main.java
└── README.md
```

## How to Run

```bash
javac Main.java
java Main
```

## Example

```
===== Hangman =====
Guess the word, one letter at a time!

Word: _ _ _ _ _ _
Wrong guesses: 0/6
Guess a letter: m
Correct!

Word: m _ _ _ _ _
Wrong guesses: 0/6
Guess a letter: z
Wrong guess!

Word: m _ _ _ _ _
Wrong guesses: 1/6
Guess a letter: o
Correct!

Word: m o _ _ _ _
...
Word: m o n k e y
Wrong guesses: 1/6
You guessed it! The word was: monkey
You won with 1 wrong guess(es).
```

## Customizing

Want different words? Just edit the word bank in `Main.java`:

```java
String[] words = {"banana", "monkey", "turtle", "cookie", "rabbit", "balloon", "penguin", "rainbow", "dragon", "dolphin"};
```

Add, remove, or replace any words — the rest of the code adjusts automatically.

## Possible Improvements

- Add ASCII art of the hangman that updates with each wrong guess
- Add difficulty levels with different word categories
- Add a hint system that reveals one letter after a certain number of wrong guesses

---

*Built by [Kavya Ladha](https://github.com/KavyaCore) while learning Java fundamentals.*
