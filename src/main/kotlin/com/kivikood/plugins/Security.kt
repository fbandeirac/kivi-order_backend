package com.kivikood.plugins

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*

fun Application.configureSecurity() {
    val config = this.environment.config
    val jwtAudienceWeb = config.propertyOrNull("jwt.audience_web").toString()
    val jwtAudienceMobile = config.propertyOrNull("jwt.audience_mobile").toString()
    val jwtDomain = config.propertyOrNull("jwt.domain").toString()
    val jwtRealm = config.propertyOrNull("jwt.realm").toString()
    val jwtSecret = config.propertyOrNull("jwt.secret").toString()
    authentication {
        jwt {
            realm = jwtRealm
            verifier(
                JWT
                    .require(Algorithm.HMAC256(jwtSecret))
                    .withAudience(jwtAudienceWeb, jwtAudienceMobile)
                    .withIssuer(jwtDomain)
                    .build()
            )
            validate { credential ->
                val audiences = listOf(jwtAudienceWeb, jwtAudienceMobile)
                if (audiences.any { it in credential.payload.audience }) JWTPrincipal(credential.payload) else null
            }
        }
    }
}
