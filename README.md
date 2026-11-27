# Playwright Java Automation Framework

## Overview

This project is an automated testing framework built with **Java**, **Maven**, **Playwright**, and **JUnit 5**.

## Prerequisites

- Java JDK
- Maven
- Git

## Project Configuration

The project configuration is handled by:

`src/main/java/com/automation/config/Config.java`

This class loads environment variables from the `.env` file and provides configuration values such as credentials, browser selection, and execution settings.

## Framework Components

### `src/main/java/com/automation/factory/PlaywrightFactory.java`

Responsible for initializing Playwright and launching the browser based on the configured browser type and execution mode.

### `src/test/java/com/automation/base/BaseTest.java`

Provides the base test setup and teardown functionality shared across test classes.

- Initializes the browser before test execution.
- Creates a new `BrowserContext` and `Page` for each test.
- Closes the `BrowserContext` after each test.
- Closes the browser after all tests have finished.

## Setup

### 1. Clone the repository

### 2. Configure environment variables

Create a `.env` file in the project root directory.

Add the following:

```env
USERNAME=standard_user
PASSWORD=secret_sauce
```

### 3. Run the tests

Execute the tests using Chromium in headed mode:

```bash
mvn test -Dbrowser=chromium -Dheadless=false
```

## Browser Configuration

- `browser` – specifies the browser to use (e.g., `chromium`, `firefox`, or `webkit`).
- `headless` – controls whether the browser runs in headless mode.

