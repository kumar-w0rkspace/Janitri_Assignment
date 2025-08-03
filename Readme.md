# Janitri QA Internship Assignment

This repository contains automation test scripts created as part of the QA Internship assignment for **Janitri Innovations**.

## 📌 Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- OpenCSV (for data-driven testing)
- Firefox (Primary Browser)
- GitHub Actions (Optional for CI)

## 🧪 Test Modules Covered

- Login Page Validation
  - UI validation (Title, Inputs, Password Toggle)
  - Blank credential validation
  - Invalid login behavior
  - Password masking/unmasking toggle
- Negative Scenarios
  - Form field validation and alert detection
  - Screenshot capture on failure
- Data-Driven Testing
  - Reads user data from CSV using OpenCSV
- Reporting
  - Auto-generated `report.txt` logging all steps, failures, skipped actions
  - Screenshots stored in `/screenshots` directory

## 🚀 How to Run

1. Clone the repo  
   `git clone https://github.com/kumar-w0rkspace/Janitri_Assignment.git`

2. Open the project in your favorite IDE

3. Run the `ChromeOnly.xml` file for Chrome execution or
    Run the `Sequential.xml` file for Chrome, Firefox and edge one by one
  


## ✍ Author

**Kumar**  
🔗 [GitHub Profile](https://github.com/kumar-w0rkspace)

