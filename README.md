# Influencer Collaboration and Sponsership Platform Simulation (Java OOP Project)

This project is a command-line based simulation of a Social Media Influencer Collaboration and Sponsorship Platform, built using Java and emphasizing Object-Oriented Programming (OOP) principles. It models the interactions between different user types: Administrators, Brand Managers, Influencers, and Advertisers.

## Overview

The platform allows users to log in based on their roles and perform specific actions. Brand Managers can search for suitable Influencers and Advertisers to create and manage marketing campaigns within a set budget. Influencers can manage their profiles and participate in campaigns. Advertisers manage their platform details and commission rates. Administrators oversee the platform by managing users and viewing overall activity. Data is persisted using simple text files.

## Key Features

*   **Multiple User Roles:** Supports distinct functionalities for:
    *   **Admin:** Manages users (add/remove), views overall stats, lists users, views campaigns.
    *   **Brand Manager:** Manages brand details, sets campaign requirements (niche, followers), searches for/selects Influencers and Advertisers, creates/manages campaigns, manages budgets, makes payments, stops campaigns.
    *   **Influencer:** Manages profile (password, name, niche, platforms, followers), calculates engagement rate, views assigned campaign, views earnings, signs contracts.
    *   **Advertiser:** Manages profile (password, name, platform, commission), views assigned campaign, manages contracts.
*   **User Authentication:** Simple username/password login system for all roles.
*   **Data Persistence:** Reads initial user data from and writes updated data back to `.txt` files (acting as a flat-file database).
*   **Campaign Management:**
    *   Represents campaigns linking a Brand Manager, Influencer, and Advertiser.
    *   Includes budget management and tracking.
    *   Basic performance metric calculation based on user stats.
*   **Contract Simulation:**
    *   Nested `Contract` class within `Campaign`.
    *   Supports contract signing and date tracking.
    *   Handles payments from Brand Manager budget to Influencer and Advertiser (factoring in commission).
    *   Includes custom exception (`InsufficientBudgetException`) for budget handling.
*   **Selection Helpers:** Logic (`SelectionHelper`) assists Brand Managers in finding suitable Influencers (based on niche, followers) and Advertisers (based on platform compatibility).
*   **Dashboard:** Basic system overview showing counts of users and campaigns.
*   **Text-Based Interface:** All interactions occur through a command-line menu system.
*   **OOP Concepts:** Demonstrates inheritance (`User` base class), interfaces (`Authenticate`, `Update`), encapsulation, and polymorphism.

## Tech Stack

*   **Language:** Java
*   **Core Concepts:** Object-Oriented Programming (OOP)
*   **Data Storage:** Flat Text Files (`.txt`)
*   **Input/Output:** `java.util.Scanner`, `java.io.*` (FileReader, BufferedReader, FileWriter)
*   **Build System:** Gradle (based on project structure files like `build.gradle`, `gradlew`)
*   **Development Environment:** Standard Java Development Kit (JDK), IDE (like Eclipse, IntelliJ IDEA, VS Code) or command line.

## How It Works

1.  **Initialization:** The `Platform.main` method starts the application. It uses `FileReader` classes (`InfluencerReader`, `AdvertiserReader`, `BrandManagerReader`, and reads `admin.txt`) to load initial user data into arrays in memory.
2.  **User Choice:** Prompts the user to log in as an existing user or register as a new user.
3.  **New User Registration:** If chosen, prompts for user type and details, creates the corresponding user object (`Influencer`, `Advertiser`, `BrandManager`), adds it to the appropriate array in the `Admin` object, and updates the relevant `.txt` file using `FileWriters.Add`.
4.  **Login:** `LoginManager` takes username/password input and checks credentials against the loaded user arrays (and the static Admin).
5.  **Role-Based Menu:** Upon successful login, the application identifies the user type (`instanceof`) and displays the corresponding menu (`showAdminMenu`, `showBrandManagerMenu`, etc.).
6.  **User Actions:** Users interact via the console menu. Choices trigger methods within the logged-in user's object (`Admin`, `BrandManager`, `Influencer`, `Advertiser`) or helper classes (`SelectionHelper`, `Campaign`).
7.  **Campaign Creation:** Brand Managers use `SelectionHelper` to find matching Influencers/Advertisers, then create a `Campaign` object, linking the participants and initializing the contract.
8.  **Campaign Interaction:** Users can view campaign details, Influencers can sign contracts, Brand Managers can make payments (which updates budgets/earnings and throws `InsufficientBudgetException` if needed), and manage the campaign status.
9.  **Data Updates:** Profile updates (like password changes, adding platforms) modify the user objects in memory. The `Admin`'s add/remove user functions also modify the arrays. Crucially, the `FileWriters.Add` class is used after modifications to *overwrite* the respective `.txt` files, persisting the changes for the next run.

## Data Storage & Path Configuration

*   The application uses `.txt` files located within the `src/` directory (`admin.txt`, `advertisers.txt`, `brandmanagers.txt`, `influencers.txt`) as its primary data store.
*   **IMPORTANT:** The file paths are currently **hardcoded** within the `FileReaders` classes (`AdvertiserReader.java`, `BrandManagerReader.java`, `InfluencerReader.java`), `FileWriters/Add.java`, and potentially `Platform.java` (for admin data) to point to a specific user's directory (`/Users/palakkshetrapal/Documents/FinalOops/src/`).
*   **You MUST update these hardcoded paths** in the mentioned `.java` files to reflect the correct location of the `.txt` files on your system after cloning the repository.

## Setup and Running

1.  **Prerequisites:**
    *   Java Development Kit (JDK) installed (version 8 or higher recommended).
    *   Gradle installed (optional, but recommended if using the build files).
    *   An IDE like Eclipse, IntelliJ IDEA, or VS Code (recommended for ease of use) or command-line compilation tools (`javac`, `java`).
2.  **Get the Code:**
    *   Clone this repository to your local machine.
3.  **Configure File Paths (CRITICAL):**
    *   Open the following Java files:
        *   `src/FileReaders/AdvertiserReader.java`
        *   `src/FileReaders/BrandManagerReader.java`
        *   `src/FileReaders/InfluencerReader.java`
        *   `src/FileWriters/Add.java`
        *   `src/Functions/Platform.java` (check the `static` block for admin file reading)
    *   Locate the hardcoded file paths (e.g., `/Users/palakkshetrapal/Documents/FinalOops/src/advertisers.txt`).
    *   **Change these paths** to the correct absolute or relative path where the `.txt` files reside within the cloned project directory on *your* system.
4.  **Build the Project:**
    *   **Using Gradle (if `gradlew` is present):** Open a terminal/command prompt in the project's root directory and run:
        ```bash
        ./gradlew build
        ```
        (or `gradlew.bat build` on Windows)
    *   **Using an IDE:** Import the project into your IDE and use its build functionality.
    *   **Using `javac` (Manual):** Compile all `.java` files, ensuring correct classpath setup.
5.  **Run the Application:**
    *   **Using Gradle:**
        ```bash
        ./gradlew run
        ```
        (or `gradlew.bat run`)
    *   **Using an IDE:** Find the `Platform.java` file (in `src/Functions/`) and run its `main` method.
    *   **Using `java` (Manual):** Navigate to the compiled classes directory (e.g., `build/classes/java/main`) and run:
        ```bash
        java Functions.Platform
        ```
6.  **Interact:** Follow the prompts displayed in the console.

