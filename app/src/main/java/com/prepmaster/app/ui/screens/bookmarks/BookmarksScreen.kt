package com.prepmaster.app.ui.screens.bookmarks

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prepmaster.app.data.model.PrepItem
import com.prepmaster.app.ui.AppViewModel
import com.prepmaster.app.ui.components.PrepIllustration
import com.prepmaster.app.ui.theme.*

@Composable
fun BookmarksScreen(onBack: () -> Unit, vm: AppViewModel = viewModel()) {
    val bookmarkIds by vm.bookmarkIds.collectAsStateWithLifecycle()
    val bookmarked  = remember(bookmarkIds) { vm.getBookmarkedPreps(bookmarkIds) }

    Column(Modifier.fillMaxSize().background(BgDeep)) {
        // Header
        Surface(color = BgSurface, shadowElevation = 2.dp) {
            Row(Modifier.fillMaxWidth().padding(16.dp, 48.dp, 16.dp, 14.dp),
                verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onBack) {
                    Icon(Icons.Filled.ArrowBack, null, tint = TxtPrimary)
                }
                Spacer(Modifier.width(4.dp))
                Column(Modifier.weight(1f)) {
                    Text("Bookmarks", style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold)
                    Text("${bookmarked.size}টি Preposition সংরক্ষিত",
                        style = MaterialTheme.typography.bodySmall, color = TxtSecondary)
                }
                Icon(Icons.Filled.Bookmark, null, tint = Gold, modifier = Modifier.size(24.dp))
            }
        }

        if (bookmarked.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Filled.BookmarkBorder, null, tint = TxtHint,
                        modifier = Modifier.size(72.dp))
                    Spacer(Modifier.height(16.dp))
                    Text("কোনো Bookmark নেই", style = MaterialTheme.typography.titleMedium,
                        color = TxtHint)
                    Spacer(Modifier.height(8.dp))
                    Text("Learn screen থেকে Preposition bookmark করো",
                        style = MaterialTheme.typography.bodySmall, color = TxtHint)
                }
            }
            return
        }

        LazyColumn(Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)) {
            items(bookmarked) { prep ->
                BookmarkCard(prep = prep, onRemove = { vm.toggleBookmark(prep) })
            }
        }
    }
}

@Composable
private fun BookmarkCard(prep: PrepItem, onRemove: () -> Unit) {
    val cat    = prep.categoryId
    val color  = when(cat) {
        "place"     -> CatPlace;  "time"      -> CatTime
        "movement"  -> CatMove;   "manner"    -> CatManner
        "cause"     -> CatCause;  "agent"     -> CatAgent
        "possession"-> CatPoss;   "compound"  -> CatCompound
        "source"    -> CatSource; else        -> Purple
    }
    Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(BgCard),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, color.copy(0.2f))) {
        Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
            if (prep.imageType.isNotEmpty()) {
                PrepIllustration(prep.imageType, color, Modifier.size(60.dp))
                Spacer(Modifier.width(12.dp))
            }
            Column(Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(shape = RoundedCornerShape(6.dp), color = color.copy(0.2f)) {
                        Text(prep.word, Modifier.padding(8.dp, 3.dp),
                            color = color, fontWeight = FontWeight.ExtraBold,
                            style = MaterialTheme.typography.titleMedium)
                    }
                    Spacer(Modifier.width(8.dp))
                    Text(prep.meaning, style = MaterialTheme.typography.bodyMedium,
                        color = TxtPrimary)
                }
                Spacer(Modifier.height(4.dp))
                Text(prep.examples.firstOrNull()?.sentence ?: "",
                    style = MaterialTheme.typography.bodySmall, color = TxtSecondary,
                    maxLines = 1)
            }
            IconButton(onClick = onRemove) {
                Icon(Icons.Filled.Bookmark, null, tint = Gold, modifier = Modifier.size(22.dp))
            }
        }
    }
}
