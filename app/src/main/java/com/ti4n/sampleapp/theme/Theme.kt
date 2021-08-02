package com.ti4n.sampleapp.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val caption = Color.DarkGray
val divider_color = Color.LightGray
private val red = Color(0xFFE30425)
private val white = Color.White
private val purple_700 = Color(0xFF720D5D)
private val purple_800 = Color(0xFF5D1049)
private val purple_900 = Color(0xFF4E0D3A)

val colors = lightColors(
    primary = purple_800,
    secondary = red,
    surface = purple_900,
    onSurface = white,
    primaryVariant = purple_700
)

val BottomSheetShape = RoundedCornerShape(
    topStart = 20.dp,
    topEnd = 20.dp,
    bottomStart = 0.dp,
    bottomEnd = 0.dp
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(colors = colors, typography = typography) {
        content()
    }
}
