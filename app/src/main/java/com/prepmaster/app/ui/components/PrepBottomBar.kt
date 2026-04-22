package com.prepmaster.app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.prepmaster.app.ui.theme.*

private data class BottomItem(val route: String, val icon: ImageVector, val label: String)

private val bottomItems = listOf(
    BottomItem("home",      Icons.Filled.Home,     "Home"),
    BottomItem("learn",     Icons.Filled.School,   "শেখো"),
    BottomItem("practice",  Icons.Filled.Edit,     "Practice"),
    BottomItem("quiz",      Icons.Filled.Quiz,     "Quiz"),
    BottomItem("flashcard", Icons.Filled.Style,    "Cards"),
    BottomItem("reference", Icons.Filled.MenuBook, "Reference"),
)

@Composable
fun PrepBottomBar(current: String, onNav: (String) -> Unit) {
    NavigationBar(containerColor = BgSurface, tonalElevation = 0.dp) {
        bottomItems.forEach { item ->
            val sel = current == item.route
            NavigationBarItem(
                selected  = sel,
                onClick   = { onNav(item.route) },
                icon      = { Icon(item.icon, null) },
                label     = { Text(item.label) },
                colors    = NavigationBarItemDefaults.colors(
                    selectedIconColor   = Purple,
                    selectedTextColor   = Purple,
                    indicatorColor      = Purple.copy(0.15f),
                    unselectedIconColor = TxtHint,
                    unselectedTextColor = TxtHint,
                )
            )
        }
    }
}
