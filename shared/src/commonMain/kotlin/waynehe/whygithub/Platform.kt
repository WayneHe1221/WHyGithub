package waynehe.whygithub

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform