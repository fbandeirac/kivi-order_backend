package com.kivikood.routes

import com.kivikood.plugins.User
import com.kivikood.plugins.UserService
import com.kivikood.plugins.Users
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.userRoutes(userService: UserService) {
    // Create user
    post("/user") {
        val user = call.receive<User>()
        val id = userService.create(user)
        if (id != null) {
            call.respond(HttpStatusCode.Created, id)
        } else {
            call.respond(HttpStatusCode.BadRequest, "Invalid user data")
        }
    }

    // Read user
    get("/user/{id}") {
        val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
        val user = userService.read(id)
        if (user != null) {
            call.respond(HttpStatusCode.OK, user)
        } else {
            call.respond(HttpStatusCode.NotFound)
        }
    }

    // Update user
    put("/user/{id}") {
        val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
        val user = call.receive<User>()
        val updatedUser = userService.update(id, user)
        if (updatedUser != null) {
            call.respond(HttpStatusCode.OK, updatedUser)
        } else {
            call.respond(HttpStatusCode.NotFound, "User with ID $id not found")
        }
    }

    // Delete user
    delete("/user/{id}") {
        val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
        val deletedRows = userService.delete(id)
        if (deletedRows > 0) {
            call.respond(HttpStatusCode.OK)
        } else {
            call.respond(HttpStatusCode.NotFound, "User with ID $id not found")
        }
    }
}