package waynehe.whygithub

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import waynehe.whygithub.functions.getTarget
import waynehe.whygithub.model.Target
import waynehe.whygithub.ui.screens.mobile.UserListScreen as MobileUserListScreen
import waynehe.whygithub.ui.screens.desktop.UserListScreen as DesktopUserListScreen

@Composable
fun MainApplication() {

    val screen = when (getTarget()) {
        Target.DESKTOP -> DesktopUserListScreen
        else -> MobileUserListScreen
    }

    Navigator(screen)
}
