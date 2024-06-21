package com.kivikood.plugins

import com.kivikood.DatabaseKey
import com.kivikood.factories.DatabaseFactory
import io.ktor.server.application.*

fun Application.configureDatabases() {
    val database = DatabaseFactory.create(this)
    attributes.put(DatabaseKey, database)
}
