[![build_by_api](https://github.com/androceo123/selenium_course/actions/workflows/Update%20API-build.yml/badge.svg)](https://github.com/androceo123/selenium_course/actions/workflows/Update%20API-build.yml)
[![PR check naming convention](https://github.com/androceo123/selenium_course/actions/workflows/PR-linter.yml/badge.svg)](https://github.com/androceo123/selenium_course/actions/workflows/PR-linter.yml)
[![run unit tests of feature branches](https://github.com/androceo123/selenium_course/actions/workflows/run-unit-tests.yml/badge.svg)](https://github.com/androceo123/selenium_course/actions/workflows/run-unit-tests.yml)
[![Manual workflow](https://github.com/androceo123/selenium_course/actions/workflows/manual.yml/badge.svg)](https://github.com/androceo123/selenium_course/actions/workflows/manual.yml)
[![code analyzer](https://github.com/androceo123/selenium_course/actions/workflows/code_analyzer.yml/badge.svg)](https://github.com/androceo123/selenium_course/actions/workflows/code_analyzer.yml)
# Selenium WebDriver with Java – Course Automation Tests

This repository contains automated UI tests built while following the [Selenium WebDriver Tutorial (Java)](https://testautomationu.applitools.com/selenium-webdriver-tutorial-java/) course on Test Automation University. All tests can be run with a single Maven command. test

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Tests](#running-the-tests)
- [What I Learned](#what-i-learned)

## Prerequisites

- **Java 10+** installed
- **Maven** installed
- **Google Chrome** browser installed
- **ChromeDriver** executable downloaded (matching your Chrome version)
- Place the `chromedriver` binary in the `resources/` folder
- **IDE** of your choice (IntelliJ IDEA recommended)

## Installation

1. Clone this repository:

```bash
git clone https://github.com/androceo123/selenium_course.git
cd selenium_course
```

## Running the Tests

1. Simply run:

```bash
mvn clean test
```

This will compile the project, launch ChromeDriver, execute all TestNG tests, and generate test reports under `target/`

## What I Learned

Throughout this course I gained hands‑on experience with:

### Setup & Configuration

- Installing Java, Maven and Selenium dependencies
- Configuring webdriver.chrome.driver

### WebDriver Basics

- Instantiating WebDriver (ChromeDriver)
- Managing browser lifecycle (get(), quit())

### Finding & Interacting with Elements

- Locators: ID, name, class, CSS selectors, XPath
- Actions: click, sendKeys, clear
- Dropdowns (Select), keyboard actions and special keys

### Advanced Interactions

- Drag-and-drop, hover, right‑click
- Handling JavaScript alerts, file uploads, modals

### Frames & Windows

- Switching into iframe elements
- Navigating multiple windows/tabs and switching focus

### Synchronization

- Implicit, explicit and fluent waits
- Avoiding flaky tests

### JavaScript Execution

- Executing custom JS when needed

### Test Structuring with TestNG

- Annotations (@BeforeMethod, @Test, @AfterMethod)
- Assertions and grouping

### Page Object Model

- Encapsulating page elements and behaviors
- Improving maintainability

### Utilities & Extras

- Capturing screenshots
- Listening for WebDriver events for enhanced logging
- Running tests headlessly
- Cookie management
