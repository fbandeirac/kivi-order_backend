package com.kivikood

object EnvironmentConfig {
    val environment: String = System.getenv("KTOR_ENV") ?: "test"
}