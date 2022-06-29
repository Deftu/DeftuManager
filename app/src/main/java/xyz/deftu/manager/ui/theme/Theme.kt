package xyz.deftu.manager.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController

val Crimson = Color(0xFF990000)
val Gray = Color(0xFF1F1F1F)

val MatteBlack = Color(0xFF28282B)
val MatteWhite = Color(0xFFFDFBF9)

val Error = Color(0xFFb83030)

private val DarkColorPalette = darkColors(
    primary = Crimson,
    primaryVariant = Crimson,
    secondary = Gray,
    secondaryVariant = Gray,
    background = MatteBlack,
    surface = MatteBlack,
    error = Error,
)

private val LightColorPalette = lightColors(
    primary = Crimson,
    primaryVariant = Crimson,
    secondary = Gray,
    secondaryVariant = Gray,
    background = MatteWhite,
    surface = MatteWhite,
    error = Error,
)

@Composable
fun Themed(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(
        colors = if (darkTheme) DarkColorPalette else LightColorPalette,
        typography = Typography(
            body1 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
            ),
        shapes = Shapes(
            small = RoundedCornerShape(4.dp),
            medium = RoundedCornerShape(4.dp),
            large = RoundedCornerShape(0.dp)
        ),
        content = content
    )

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (darkTheme) MatteBlack else MatteWhite,
            darkIcons = !darkTheme
        )
    }
}