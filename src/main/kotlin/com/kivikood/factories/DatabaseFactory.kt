package com.kivikood.factories

import com.kivikood.EnvironmentConfig
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database

object DatabaseFactory {
    fun create(application: Application): Database {
        val environment = EnvironmentConfig.environment
        val config = application.environment.config
        val dbUrl = config.property("${environment}.database.url").getString()
        val dbDriver = config.property("${environment}.database.driver").getString()
        val dbUser = config.property("${environment}.database.user").getString()
        val dbPassword = config.property("${environment}.database.password").getString()

        return Database.connect(
            url = dbUrl,
            driver = dbDriver,
            user = dbUser,
            password = dbPassword
        )

    }
}