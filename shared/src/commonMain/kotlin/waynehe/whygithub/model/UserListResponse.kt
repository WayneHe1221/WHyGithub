package waynehe.whygithub.model

import kotlinx.serialization.Serializable

@Serializable
data class UserListResponse(
    val result: Boolean,
    val message: String,
    val data: List<User>
)