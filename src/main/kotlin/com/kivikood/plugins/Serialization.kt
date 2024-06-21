package com.kivikood.plugins

import com.kivikood.DatabaseKey
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
    val database = attributes[DatabaseKey]
    val userService = UserService(database)
    routing {
        get("/json/users") {
            call.respond(userService.all())
        }
    }
}
