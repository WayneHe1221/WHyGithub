package waynehe.whygithub.screenmodels

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import waynehe.whygithub.model.User
import waynehe.whygithub.model.UserListResponse
import waynehe.whygithub.model.const.accessToken
import waynehe.whygithub.model.const.apiBaseUrl

class UserListScreenModel : StateScreenModel<UserListScreenModel.State>(State.Init) {

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
        defaultRequest {
            url(apiBaseUrl)
        }
        expectSuccess = true
    }

    sealed class State {
        data object Init : State()
        data class UserListFetched(val userList: List<User>) : State()
    }

    fun fetchUserList() {
        coroutineScope.launch(Dispatchers.IO) {
            val response: List<User> = httpClient.get("/users") {
                headers {
                    append(HttpHeaders.Accept, "Accept: application/vnd.github+json")
                    append(HttpHeaders.Authorization, "Bearer $accessToken")
//                    append(HttpHeaders.UserAgent, "X-GitHub-Api-Version: 2022-11-28")
                }
                contentType(ContentType.Application.Json)
            }.body()

            if (response.isNotEmpty()) {
                mutableState.value = State.UserListFetched(response)
            }
        }
    }

    override fun onDispose() {
        httpClient.close()
    }
}
