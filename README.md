# MyCalculator App

A simple and user-friendly calculator application built using Java in Android Studio. The app allows users to perform basic arithmetic operations like addition, subtraction, multiplication, and division. It includes a clean and scrollable interface for real-time calculation display.

---

## Features

- **Basic Arithmetic Operations**: Addition, subtraction, multiplication, division.
- **Real-Time Calculation**: Displays the solution as you type.
- **Clear & Reset Options**: Clear (`C`) and All Clear (`AC`) buttons to manage inputs.
- **Interactive Scrollable Display**: Solution scrolls automatically to keep recent input in view.
- **Error Handling**: Displays "Err" for invalid inputs or operations.

---

## Tech Stack

- **Language**: Java
- **Framework**: Android SDK
- **UI Components**: Material Design Buttons and TextViews
- **Scripting Engine**: Rhino for mathematical expression evaluation

---

## Setup and Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-repository-url.git
   ```
2. **Open in Android Studio**:
   - Import the project into Android Studio.
   - Allow Gradle to sync and download dependencies.
4. **Run the application**:
   - Connect your Android device or start an emulator.
   - Click on the Run button to install and launch the app.

---

## Code Overview

### MainActivity.java
Handles the main logic for the calculator:

- Manages button clicks and updates the solution and result displays.
- Uses Rhino scripting engine for evaluating mathematical expressions.
- Includes error handling for invalid inputs.

### Key Methods

- assignID(MaterialButton btn, int id): Links buttons from the UI to their respective IDs.
- onClick(View v): Handles user interactions and updates the display.
- getResult(String data): Evaluates the mathematical expression using Rhino.

---

## UI Layout
- Buttons: Number keys (0-9), Operators (+, -, *, /), Clear (C), All Clear (AC), Parentheses ((, )), Dot (.), Equal (=).
- TextViews:
  - Solution: Displays the current input or expression.
  - Result: Displays the calculated result.

---

## Screenshots
![Screenshot](https://github.com/user-attachments/assets/fc944847-ea10-4283-9452-19117eb18644)

---

## Future Enhancements

- Scientific Mode: Support for trigonometric and logarithmic functions.
- History: Save and view past calculations.
- Themes: Add dark mode support.

---

## Contact
If you have any questions or suggestions, feel free to reach out:
- **Author**: [Shashanka C K](mailto:your-email@example.com)  
- **GitHub**: [Shashank452](https://github.com/Shashank452)  
- **LinkedIn**: [Shashanka C K](https://www.linkedin.com/in/shashanka-c-k)
