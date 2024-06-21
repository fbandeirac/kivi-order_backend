# Kivi Order - Backend

### Description:

Kivi Order is a simple application designed for small businesses like home bakers, small bakeries and cafes to manage
their orders and customers. This is the backend part of the application, built using Kotlin and the Ktor framework.

### License:

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

### Installation:

Clone the repository:

`git clone https://github.com/fbandeirac/kivi-order_backend.git`

Change to the Project Directory:

`cd kivi-order_backend`

Build the Project:

`./gradlew build`

Run the Application:

`./gradlew run`

### Usage:

Endpoints:

POST /user - Register a new user.
GET /user/{id} - Get user by ID.
PUT /user/{id} - Update an existing user.
DELETE /user/{id} - Delete an user.
GET /json/users - List all users.

Configuration:

Modify application.yaml to configure database connections and other settings.

### Contributing:

Clone the repository.
Create your feature branch (git checkout -b feature/fooBar).
Commit your changes (git commit -am 'Add some fooBar').
Push to the branch (git push origin feature/fooBar).
Create a new Pull Request.

### Project Structure:

```
src
├── main
│   ├── kotlin
│   │   └── com.kivikood
│   │       ├── factories
│   │       ├── plugins
│   │       ├── routes
│   │       ├── Application.kt
│   └── resources
│       └── application.example.yaml
├── test
└── LICENSE
└── README.md
└── build.gradle.kts
└── .gitignore
```

