package io.kraftsman.server.plugins

import io.ktor.server.application.Application
import io.ktor.server.routing.routing

fun Application.configureLogin() {

    routing {
//        post("/users/login") {
//            val loginRequest = call.receive<LoginRequest>()
//            val loggedInUser = userDatabase.firstOrNull {
//                it.username == loginRequest.username &&
//                it.password == loginRequest.password
//            }
//
//            call.respond(
//                LoginResponse(
//                    result = (loggedInUser != null),
//                    message = if (loggedInUser != null) { "login success" } else { "wrong username and password" },
//                    user = loggedInUser
//                )
//            )
//        }
    }
}
