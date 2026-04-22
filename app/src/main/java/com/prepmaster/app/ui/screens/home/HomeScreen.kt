package com.prepmaster.app.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.prepmaster.app.ui.AppViewModel
import com.prepmaster.app.ui.theme.*

@Composable
fun HomeScreen(nav: NavController, vm: AppViewModel = viewModel()) {
    val stats       by vm.stats.collectAsStateWithLifecycle()
    val progress    by vm.progress.collectAsStateWithLifecycle()
    val bookmarkIds by vm.bookmarkIds.collectAsStateWithLifecycle()
    val cats         = vm.categories
    val learnedIds   = progress.filter { it.learned }.map { it.prepId }.toSet()
    val totalPreps   = cats.sumOf { it.prepositions.size }
    val overallProg  = if (totalPreps > 0) learnedIds.size.toFloat() / totalPreps else 0f

    LazyColumn(Modifier.fillMaxSize().background(BgDeep)) {

        item {
            Box(
                Modifier.fillMaxWidth().background(
                    Brush.linearGradient(
                        listOf(Color(0xFF1A0840), Color(0xFF0A1040), BgDeep),
                        end = Offset(Float.MAX_VALUE, 500f)
                    )
                ).padding(20.dp, 52.dp, 20.dp, 24.dp)
            ) {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Column(Modifier.weight(1f)) {
                            Text("স্বাগতম,", style = MaterialTheme.typography.bodyMedium, color = TxtSecondary)
                            Text(stats.name, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.ExtraBold)
                        }
                        Box(
                            Modifier.size(60.dp).background(
                                Brush.radialGradient(listOf(Purple, PurpleDark)), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Lv", style = MaterialTheme.typography.labelSmall, color = Color.White.copy(0.7f))
                                Text("${stats.level}", style = MaterialTheme.typography.headlineSmall, color = Color.White, fontWeight = FontWeight.ExtraBold)
                            }
                        }
                    }
                    Spacer(Modifier.height(20.dp))
                    val (xpEarned, xpNeeded) = vm.xpProgress(stats.xp)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Filled.Stars, null, tint = Gold, modifier = Modifier.size(16.dp))
                        Spacer(Modifier.width(4.dp))
                        Text("${stats.xp} XP", style = MaterialTheme.typography.labelLarge, color = Gold)
                        Spacer(Modifier.weight(1f))
                        Text("Level ${stats.level + 1} এ ${xpNeeded} XP", style = MaterialTheme.typography.labelSmall, color = TxtHint)
                    }
                    Spacer(Modifier.height(6.dp))
                    LinearProgressIndicator(
                        progress = { if (xpNeeded > 0) (xpEarned.toFloat() / xpNeeded).coerceIn(0f, 1f) else 0f },
                        modifier = Modifier.fillMaxWidth().height(8.dp).clip(RoundedCornerShape(4.dp)),
                        color = Gold, trackColor = BgElevated
                    )
                }
            }
        }

        item {
            Row(Modifier.fillMaxWidth().padding(16.dp, 8.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                StatCard("${stats.streak}", "Streak", Icons.Filled.Whatshot, Coral, Modifier.weight(1f))
                StatCard("${learnedIds.size}", "শেখা", Icons.Filled.School, Mint, Modifier.weight(1f))
                StatCard("${stats.quizCorrect}", "Quiz", Icons.Filled.Star, Gold, Modifier.weight(1f))
                StatCard("${bookmarkIds.size}", "Saved", Icons.Filled.Bookmark, Lavender, Modifier.weight(1f))
            }
        }

        item {
            Card(Modifier.fillMaxWidth().padding(horizontal = 16.dp), colors = CardDefaults.cardColors(BgCard), shape = RoundedCornerShape(16.dp)) {
                Column(Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Filled.Timeline, null, tint = Cyan, modifier = Modifier.size(18.dp))
                        Spacer(Modifier.width(8.dp))
                        Text("মোট অগ্রগতি", style = MaterialTheme.typography.titleMedium)
                        Spacer(Modifier.weight(1f))
                        Text("${learnedIds.size}/$totalPreps", style = MaterialTheme.typography.labelLarge, color = Cyan)
                    }
                    Spacer(Modifier.height(10.dp))
                    LinearProgressIndicator(
                        progress = { overallProg },
                        modifier = Modifier.fillMaxWidth().height(10.dp).clip(RoundedCornerShape(5.dp)),
                        color = Cyan, trackColor = BgElevated
                    )
                    Spacer(Modifier.height(6.dp))
                    Text("${"%.0f".format(overallProg * 100)}% সম্পন্ন", style = MaterialTheme.typography.bodySmall, color = TxtSecondary)
                }
            }
        }

        item {
            Spacer(Modifier.height(16.dp))
            Text("Quick Actions", Modifier.padding(horizontal = 16.dp), style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(10.dp))
            Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                QuickCard("Comparison", Icons.Filled.CompareArrows, Cyan, Modifier.weight(1f)) { nav.navigate("comparison") }
                QuickCard("Builder", Icons.Filled.Build, Mint, Modifier.weight(1f)) { nav.navigate("builder") }
                QuickCard("Grammar", Icons.Filled.MenuBook, Lavender, Modifier.weight(1f)) { nav.navigate("rules") }
            }
        }

        item {
            Spacer(Modifier.height(16.dp))
            Text("Category অগ্রগতি", Modifier.padding(horizontal = 16.dp), style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(10.dp))
        }

        items(cats) { cat ->
            val catLearned = cat.prepositions.count { it.id in learnedIds }
            val catProg    = if (cat.prepositions.isNotEmpty()) catLearned.toFloat() / cat.prepositions.size else 0f
            val color      = Color(cat.color)
            Card(
                Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
                colors = CardDefaults.cardColors(BgCard), shape = RoundedCornerShape(14.dp)
            ) {
                Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                    Box(Modifier.size(40.dp).background(color.copy(0.15f), RoundedCornerShape(10.dp)), contentAlignment = Alignment.Center) {
                        Text(cat.title.first().toString(), color = color, fontWeight = FontWeight.ExtraBold, style = MaterialTheme.typography.titleMedium)
                    }
                    Spacer(Modifier.width(12.dp))
                    Column(Modifier.weight(1f)) {
                        Row {
                            Text(cat.titleBn, fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.bodyMedium)
                            Spacer(Modifier.weight(1f))
                            Text("$catLearned/${cat.prepositions.size}", style = MaterialTheme.typography.labelSmall, color = TxtSecondary)
                        }
                        Spacer(Modifier.height(4.dp))
                        LinearProgressIndicator(
                            progress = { catProg },
                            modifier = Modifier.fillMaxWidth().height(5.dp).clip(RoundedCornerShape(3.dp)),
                            color = color, trackColor = BgElevated
                        )
                    }
                }
            }
        }

        item {
            Spacer(Modifier.height(16.dp))
            Text("আরো Features", Modifier.padding(horizontal = 16.dp), style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(10.dp))
            Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                QuickCard("Stories", Icons.Filled.AutoStories, Gold, Modifier.weight(1f)) { nav.navigate("stories") }
                QuickCard("Bookmarks\n${bookmarkIds.size}", Icons.Filled.Bookmark, Orange, Modifier.weight(1f)) { nav.navigate("bookmarks") }
                QuickCard("Profile", Icons.Filled.Person, CatSource, Modifier.weight(1f)) { nav.navigate("profile") }
            }
            Spacer(Modifier.height(24.dp))
        }
    }
}

@Composable
private fun StatCard(value: String, label: String, icon: ImageVector, color: Color, modifier: Modifier) {
    Card(modifier = modifier, colors = CardDefaults.cardColors(BgCard), shape = RoundedCornerShape(14.dp)) {
        Column(Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(icon, null, tint = color, modifier = Modifier.size(20.dp))
            Spacer(Modifier.height(4.dp))
            Text(value, fontWeight = FontWeight.ExtraBold, color = color, style = MaterialTheme.typography.titleMedium)
            Text(label, style = MaterialTheme.typography.labelSmall, color = TxtSecondary)
        }
    }
}

@Composable
private fun QuickCard(label: String, icon: ImageVector, color: Color, modifier: Modifier, onClick: () -> Unit) {
    Card(onClick = onClick, modifier = modifier, colors = CardDefaults.cardColors(BgCard), shape = RoundedCornerShape(14.dp)) {
        Column(Modifier.fillMaxWidth().padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Box(Modifier.size(40.dp).background(color.copy(0.15f), RoundedCornerShape(10.dp)), contentAlignment = Alignment.Center) {
                Icon(icon, null, tint = color, modifier = Modifier.size(22.dp))
            }
            Spacer(Modifier.height(6.dp))
            Text(label, style = MaterialTheme.typography.labelSmall, color = TxtPrimary, fontWeight = FontWeight.SemiBold)
        }
    }
}
