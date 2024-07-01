package waynehe.whygithub.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import waynehe.whygithub.model.User

@Composable
fun UserSummaryList(userList: List<User>) {
    Column {
        userList.forEach { user ->
            UserSummary(user)
        }
    }
}