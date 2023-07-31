# NoteApp - Java Note-taking Application with Firebase Authentication and Firestore

![note-taking-app-icon - Copy](https://github.com/deepakdevengineer/NotesApp/assets/129176978/6db134b8-132b-45b1-9d43-675b2c924526)


NoteApp is a Java-based note-taking application that provides user authentication using Firebase Authentication and stores note data using Firebase Firestore. This allows users to securely create, manage, update, and delete notes, along with a personalized and colorful note-taking experience.

## Features

- **Firebase Authentication:** User authentication is handled using Firebase Authentication, allowing new users to create an account with their email and password. Returning users can log in using their registered email and password, ensuring a safe and streamlined login process.

- **Firebase Firestore:** NoteApp utilizes Firebase Firestore, a cloud-based NoSQL database, to store user data and notes. This ensures data persistence and synchronization across multiple devices.

- **Note Management:** Once logged in, users can create, view, update, and delete notes. This functionality allows users to keep their thoughts organized and accessible.

- **Colorful Notes:** Users can personalize their notes with different colors, making the note-taking experience more visually appealing and enjoyable.


## Screenshots
![Screenshot_20230731_201605_NotesApp](https://github.com/deepakdevengineer/NotesApp/assets/129176978/d3a4b068-066a-4924-ac44-bf1903dd3679)
![Screenshot_20230731_201449_NotesApp](https://github.com/deepakdevengineer/NotesApp/assets/129176978/8e4c2bb2-2ead-4537-a29a-ba4dc3247c06)

https://github.com/deepakdevengineer/NotesApp/assets/129176978/4ede9f18-509f-4a70-9702-acc7a0762a67








## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-username/NoteApp.git
   cd NoteApp
   ```

2. **Firebase Setup:**

   - Create a [Firebase project](https://console.firebase.google.com/) if you haven't already.
   - Enable Firebase Authentication and choose the desired authentication methods (email/password in this case).
   - Enable Firebase Firestore to store the note data.

3. **Configure Firebase Credentials:**

   Add the Firebase configuration file to the project. This file can be downloaded from the Firebase Console. Place the file in the `src/main/resources` directory and rename it to `firebase-credentials.json`.

4. **Build and Run the Application:**

   NoteApp requires [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) and [Apache Maven](https://maven.apache.org/) to be installed on your system. Make sure you have them installed before proceeding.

   ```bash
   mvn clean package
   java -jar target/noteapp.jar
   ```

5. **Access the Application:**

   Open your web browser and navigate to http://localhost:8080 to access NoteApp.

## Usage

1. **Create an Account:**

   Click on the "Sign Up" button on the home page and provide a valid email address and a secure password. The user account will be created using Firebase Authentication.

2. **Log In:**

   After account creation, click on the "Log In" button on the home page and enter your registered email and password to log in. Firebase Authentication will verify your credentials.

3. **Create a Note:**

   Once logged in, you will be taken to the dashboard. Click on the "New Note" button, enter the note details, and choose a color for the note. Click "Save" to create the note. The note data will be stored in Firebase Firestore.

4. **View Notes:**

   All your notes will be displayed on the dashboard. Click on a note to view its details.

5. **Update a Note:**

   To update a note, click on the "Edit" button on the note's view page. Modify the note content or color and click "Save" to update the note. The updated data will be synchronized with Firebase Firestore.

6. **Delete a Note:**

   To delete a note, click on the "Delete" button on the note's view page. Confirm the action, and the note will be permanently deleted from Firebase Firestore.

7. **Log Out:**

   Click on the "Log Out" button to securely log out of your account.

## Technologies Used

- Java: Core programming language for developing the backend logic.
- Spring Boot: Framework for building robust and scalable Java applications.
- Thymeleaf: Template engine for rendering HTML pages with dynamic content.
- Firebase Authentication: Securely handles user authentication.
- Firebase Firestore: Cloud-based NoSQL database for storing user and note data.
- Bootstrap: Front-end framework for creating responsive and visually appealing user interfaces.

## Contributing

Contributions to NoteApp are welcome! If you find any bugs or have suggestions for improvements, please open an issue or submit a pull request. Before contributing, please review the [Contribution Guidelines](CONTRIBUTING.md).

## License

NoteApp is open-source software released under the [MIT License](LICENSE).

## Contact

For any inquiries or support, please email us at support@noteapp.com or visit our website [noteapp.com](https://www.noteapp.com).

---
Note: The above email and website are fictional and used for demonstration purposes only.

Thank you for using NoteApp! Happy note-taking! 📝
