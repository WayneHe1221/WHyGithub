package waynehe.whygithub.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import io.ktor.http.Url
import waynehe.whygithub.model.User

@Composable
fun UserSummary(user: User) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // User's image
        KamelImage(
            resource = asyncPainterResource(
                data = Url(user.avatar_url)
            ),
            modifier = Modifier.size(72.dp).clip(shape = CircleShape),
            contentDescription = "Avatar",
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Account: ${user.login}",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontFamily = FontFamily.Default,
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "ID: ${user.id} - ${user.node_id}",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Default,
                    letterSpacing = (0.8).sp,
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Spacer(modifier = Modifier.height(4.dp))

            ClickableText(
                text = AnnotatedString(user.html_url),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily.Default,
                    color = Color.Gray,
                    letterSpacing = (0.8).sp,
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                onClick = {

                }
            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}