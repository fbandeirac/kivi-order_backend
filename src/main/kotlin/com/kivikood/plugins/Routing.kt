package com.kivikood.plugins

import com.kivikood.DatabaseKey
import com.kivikood.routes.userRoutes
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val database = attributes[DatabaseKey]
    val userService = UserService(database)
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        userRoutes(userService)
    }
}
