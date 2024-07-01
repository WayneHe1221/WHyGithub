package io.kraftsman.server.data

import waynehe.whygithub.data.User
import waynehe.whygithub.data.apiBaseUrl

val userDatabase = listOf(
    User(
        id = 1,
        username = "shengyou",
        password = "0000",
        displayName = "Shengyou Fan",
        email = "shengyou.fan@jetbrains.com",
        profileImageUrl = "$apiBaseUrl/static/shengyou.jpg",
    ),
    User(
        id = 2,
        username = "johndoe",
        password = "1111",
        displayName = "John Doe",
        email = "john.doe@example.com",
        profileImageUrl = "$apiBaseUrl/static/johndoe.jpg",
    ),
)
