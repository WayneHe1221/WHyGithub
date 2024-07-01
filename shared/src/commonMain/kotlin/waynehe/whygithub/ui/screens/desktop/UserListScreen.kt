package waynehe.whygithub.ui.screens.desktop

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import waynehe.whygithub.screenmodels.UserListScreenModel
import waynehe.whygithub.ui.components.UserSummaryList

object UserListScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = rememberScreenModel { UserListScreenModel() }
        val state by screenModel.state.collectAsState()

        when (val loggedInState = state) {
            is UserListScreenModel.State.Init -> {
                screenModel.fetchUserList()
            }
            is UserListScreenModel.State.UserListFetched -> {

            }
        }

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
        ) {
            when (state) {
                is UserListScreenModel.State.Init -> {
                    CircularProgressIndicator(
                        modifier = Modifier.width(64.dp),
                        color = MaterialTheme.colors.secondary,
                    )
                }
                is UserListScreenModel.State.UserListFetched -> {
                    UserSummaryList((state as UserListScreenModel.State.UserListFetched).userList)
                }
            }
        }
    }
}
