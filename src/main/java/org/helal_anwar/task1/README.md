# Simple Math Calculator 🧮

A lightweight, fully-featured command-line calculator written in **pure Java**.  
It supports chained expressions with addition, subtraction, multiplication, division, exponentiation, factorials, and negative numbers—all evaluated in a single line.

![Java](https://img.shields.io/badge/language-Java-orange.svg)
![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Status](https://img.shields.io/badge/build-passing-brightgreen.svg)

---

## ✨ Features

- **Chained expressions** & operator precedence  
  `2+3+4*3/4-6`
- **Negative numbers** handled seamlessly  
  `-4*-8`
- **Exponentiation**  
  `2^8`
- **Factorials** (with `BigInteger` for large results)  
  `20!`
- **Scientific notation** support
- **Interactive REPL** with:
  - `e` → exit
  - `cls` → clear screen
- ANSI-colored banner and outputs for a pleasant CLI experience

---


---

## 🗒️ Usage Examples

| Input expression                  | Output  | Explanation                           |
|----------------------------------|---------|---------------------------------------|
| `2+3*4`                          | `14.0`  | Multiplication before addition        |
| `-5*-6`                          | `30.0`  | Double negatives                      |
| `2^10`                           | `1024.0`| Exponentiation                        |
| `10/3`                           | `3.333…`| Double precision division             |
| `6!`                             | `720`   | Factorial via `BigInteger`            |
| `cls`                            | —       | Clears terminal screen                |
| `e`                              | —       | Exits the program                     |

---

## ⚙️ How It Works (High-Level)

1. **Substitution layer**  
   Special Unicode placeholders temporarily replace patterns such as `*-` or `/-` so the parser can safely split on operators without confusing leading negatives.
2. **Parsing**  
   - Expression is first split on `+` (after converting subtraction to `+-` form).  
   - Each segment is recursively processed for `*`, `/`, `^`, and `!`.
3. **Evaluation**  
   - Uses `double` arithmetic for general operations.  
   - Factorials switch to `BigInteger` to avoid overflow.  
   - Final result is the summation of all processed segments.
4. **REPL loop** for continuous user interaction.

---

## 📈 Roadmap

- [ ] Add parentheses `(` `)` support  
- [ ] Implement modulo `%` operator  
- [ ] Unit tests with JUnit  
- [ ] Maven/Gradle build script  
- [ ] Package as an executable JAR

---

## 📝 License

Released under the MIT License. See `LICENSE` for details.

---

⭐ **If you find this project useful, please give it a star!** ⭐


