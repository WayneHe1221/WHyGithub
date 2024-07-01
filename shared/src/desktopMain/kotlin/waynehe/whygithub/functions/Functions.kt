package waynehe.whygithub.functions

import waynehe.whygithub.model.Target

actual fun getPlatformName(): String = Target.ANDROID.name
    .lowercase()
    .replaceFirstChar(Char::uppercaseChar) +
        " (API ${android.os.Build.VERSION.SDK_INT})"

actual fun getTarget(): Target = Target.ANDROID
