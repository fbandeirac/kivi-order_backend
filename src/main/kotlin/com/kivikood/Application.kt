package com.kivikood

import com.kivikood.plugins.*
import io.ktor.server.application.*
import io.ktor.util.*
import org.jetbrains.exposed.sql.Database

val DatabaseKey = AttributeKey<Database>("Database")

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSecurity()
    configureHTTP()
    configureDatabases()
    configureSerialization()
    configureRouting()
}
