package com.prepmaster.app.ui.screens.learn

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.*
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prepmaster.app.ui.AppViewModel
import com.prepmaster.app.ui.components.PrepIllustration
import com.prepmaster.app.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrepDetailScreen(catId: String, onBack: () -> Unit, vm: AppViewModel = viewModel()) {
    val cat        = vm.getCategory(catId) ?: return
    val progress   by vm.progress.collectAsStateWithLifecycle()
    val bookmarkIds by vm.bookmarkIds.collectAsStateWithLifecycle()
    val learnedIds  = progress.filter { it.learned }.map { it.prepId }.toSet()
    val catColor    = Color(cat.color)

    var selectedIdx by remember { mutableIntStateOf(0) }
    val prep = cat.prepositions.getOrNull(selectedIdx)

    Column(Modifier.fillMaxSize().background(BgDeep)) {
        // Top bar
        Surface(color = BgSurface, shadowElevation = 2.dp) {
            Row(Modifier.fillMaxWidth().padding(4.dp, 40.dp, 8.dp, 8.dp),
                verticalAlignment = Alignment.CenterVertically) {
                IconButton(onBack) { Icon(Icons.Filled.ArrowBack, null, tint = TxtPrimary) }
                Column(Modifier.weight(1f)) {
                    Text(cat.titleBn, style = MaterialTheme.typography.headlineSmall)
                    Text("${cat.prepositions.size} টি Preposition",
                        style = MaterialTheme.typography.bodySmall, color = catColor)
                }
                // Bookmark toggle
                if (prep != null) {
                    val isBookmarked = prep.id in bookmarkIds
                    IconButton(onClick = { vm.toggleBookmark(prep) }) {
                        Icon(
                            if (isBookmarked) Icons.Filled.Bookmark else Icons.Filled.BookmarkBorder,
                            null,
                            tint = if (isBookmarked) Gold else TxtSecondary,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }

        // Prep selector row
        LazyRow(contentPadding = PaddingValues(horizontal = 14.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            itemsIndexed(cat.prepositions) { idx, p ->
                val isSelected  = idx == selectedIdx
                val isLearned   = p.id in learnedIds
                val isBookmarked = p.id in bookmarkIds
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = when { isSelected -> catColor; isLearned -> catColor.copy(0.2f); else -> BgCard },
                    border = if (isLearned && !isSelected) BorderStroke(1.dp, catColor.copy(0.4f)) else null,
                    modifier = Modifier.clickable { selectedIdx = idx }
                ) {
                    Row(Modifier.padding(10.dp, 6.dp), verticalAlignment = Alignment.CenterVertically) {
                        if (isBookmarked) Icon(Icons.Filled.Bookmark, null,
                            tint = if (isSelected) Color.White else Gold,
                            modifier = Modifier.size(12.dp))
                        if (isLearned) Icon(Icons.Filled.Check, null,
                            tint = if (isSelected) Color.White else catColor,
                            modifier = Modifier.size(12.dp))
                        if (isBookmarked || isLearned) Spacer(Modifier.width(3.dp))
                        Text(p.word,
                            color = if (isSelected) Color.White else if (isLearned) catColor else TxtSecondary,
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal)
                    }
                }
            }
        }

        if (prep == null) return@Column

        Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
            // ── Illustration + Title ──────────────────────────────────
            Card(Modifier.fillMaxWidth().padding(16.dp),
                colors = CardDefaults.cardColors(BgCard), shape = RoundedCornerShape(20.dp)) {
                Column(Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        PrepIllustration(prep.imageType, catColor, Modifier.size(120.dp))
                        Spacer(Modifier.width(16.dp))
                        Column {
                            Text(prep.word, style = MaterialTheme.typography.displayLarge,
                                color = catColor, fontWeight = FontWeight.ExtraBold)
                            Spacer(Modifier.height(4.dp))
                            Surface(shape = RoundedCornerShape(8.dp), color = catColor.copy(0.15f)) {
                                Text(prep.meaning, Modifier.padding(10.dp, 4.dp),
                                    color = catColor, fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.titleMedium)
                            }
                        }
                    }
                    Spacer(Modifier.height(12.dp))
                    Surface(shape = RoundedCornerShape(10.dp),
                        color = catColor.copy(0.08f), modifier = Modifier.fillMaxWidth()) {
                        Text(prep.definition, Modifier.padding(12.dp),
                            style = MaterialTheme.typography.bodyMedium)
                    }
                    if (prep.structure.isNotEmpty()) {
                        Spacer(Modifier.height(8.dp))
                        Surface(shape = RoundedCornerShape(10.dp),
                            color = Purple.copy(0.1f), modifier = Modifier.fillMaxWidth()) {
                            Row(Modifier.padding(12.dp)) {
                                Icon(Icons.Filled.Code, null, tint = PurpleLight,
                                    modifier = Modifier.size(14.dp))
                                Spacer(Modifier.width(6.dp))
                                Text(prep.structure, style = MaterialTheme.typography.bodySmall,
                                    color = PurpleLight, fontWeight = FontWeight.Medium)
                            }
                        }
                    }
                }
            }

            // ── Examples ─────────────────────────────────────────────
            Card(Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                colors = CardDefaults.cardColors(BgCard), shape = RoundedCornerShape(20.dp)) {
                Column(Modifier.padding(16.dp)) {
                    Text("উদাহরণ", style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold, color = catColor)
                    Spacer(Modifier.height(12.dp))
                    prep.examples.forEachIndexed { idx, ex ->
                        Surface(shape = RoundedCornerShape(12.dp),
                            color = catColor.copy(0.05f),
                            border = BorderStroke(1.dp, catColor.copy(0.15f)),
                            modifier = Modifier.fillMaxWidth()) {
                            Column(Modifier.padding(14.dp)) {
                                // Highlight the prep word
                                val words = ex.sentence.split(" ")
                                val annotated = buildAnnotatedString {
                                    words.forEachIndexed { i, w ->
                                        val clean = w.lowercase().trimEnd('.', ',', '!', '?')
                                        if (clean == ex.highlight.lowercase() || clean == prep.word.lowercase()) {
                                            withStyle(SpanStyle(color = catColor, fontWeight = FontWeight.ExtraBold)) { append(w) }
                                        } else append(w)
                                        if (i < words.size - 1) append(" ")
                                    }
                                }
                                Text(annotated, style = MaterialTheme.typography.bodyLarge)
                                Spacer(Modifier.height(4.dp))
                                Text(ex.translation, style = MaterialTheme.typography.bodySmall,
                                    color = TxtSecondary)
                            }
                        }
                        if (idx < prep.examples.size - 1) Spacer(Modifier.height(8.dp))
                    }
                }
            }

            Spacer(Modifier.height(12.dp))

            // ── Notes ────────────────────────────────────────────────
            if (prep.notes.isNotEmpty()) {
                Card(Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                    colors = CardDefaults.cardColors(Gold.copy(0.08f)),
                    border = BorderStroke(1.dp, Gold.copy(0.3f)),
                    shape = RoundedCornerShape(16.dp)) {
                    Row(Modifier.padding(14.dp)) {
                        Icon(Icons.Filled.Lightbulb, null, tint = Gold,
                            modifier = Modifier.size(20.dp))
                        Spacer(Modifier.width(10.dp))
                        Text(prep.notes, style = MaterialTheme.typography.bodyMedium)
                    }
                }
                Spacer(Modifier.height(12.dp))
            }

            // ── Mark as Learned button ────────────────────────────────
            val isLearned = prep.id in learnedIds
            Button(
                onClick = { vm.markLearned(prep) },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).height(52.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isLearned) Mint.copy(0.3f) else catColor,
                    contentColor = if (isLearned) Mint else Color.White
                )
            ) {
                Icon(
                    if (isLearned) Icons.Filled.CheckCircle else Icons.Filled.School,
                    null, modifier = Modifier.size(18.dp))
                Spacer(Modifier.width(8.dp))
                Text(if (isLearned) "শেখা হয়েছে (+15 XP)" else "শেখা হয়েছে বলে চিহ্নিত করো",
                    fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(24.dp))
        }
    }
}
