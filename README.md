# Kivi Order - Backend

### Description:
Description:
Kivi Order is a simple application designed for small businesses like home bakers, small bakeries, and cafes to manage their orders and customers. This is the backend part of the application, built using Kotlin and the Ktor framework.

### Project Structure:
```
└── main
└── kotlin
├── com
│   └── example
│       ├── Application.kt
│       ├── config
│       │   └── DatabaseConfig.kt
│       ├── models
│       │   └── User.kt
│       ├── repositories
│       │   └── UserRepository.kt
│       ├── services
│       │   └── UserService.kt
│       └── routes
│           └── UserRoutes.kt
└── resources
└── application.conf
```

### Installation:
Clone the repository:

`git clone https://github.com/yourusername/kivi-order-backend.git`

Change to the Project Directory:

`cd kivi-order-backend`

Build the Project:

`./gradlew build`

Run the Application:

`./gradlew run`

### Usage:
Endpoints:

POST /users/register - Register a new user.
POST /users/login - Login a user.
POST /orders - Create a new order.
PUT /orders/{id} - Update an existing order.
DELETE /orders/{id} - Delete an order.
GET /orders/{id} - Get order details by ID.
GET /orders - List all orders.
Configuration:

Modify application.conf to configure database connections and other settings.

### Contributing:
Fork the repository.
Create your feature branch (git checkout -b feature/fooBar).
Commit your changes (git commit -am 'Add some fooBar').
Push to the branch (git push origin feature/fooBar).
Create a new Pull Request.

### License:
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.