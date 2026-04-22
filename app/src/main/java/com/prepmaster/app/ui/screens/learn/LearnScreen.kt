package com.prepmaster.app.ui.screens.learn

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prepmaster.app.ui.AppViewModel
import com.prepmaster.app.ui.components.PrepIllustration
import com.prepmaster.app.ui.theme.*

@Composable
fun LearnScreen(onCategory: (String) -> Unit, vm: AppViewModel = viewModel()) {
    val cats       = vm.categories
    val progress   by vm.progress.collectAsStateWithLifecycle()
    val learnedIds  = progress.filter { it.learned }.map { it.prepId }.toSet()

    Column(Modifier.fillMaxSize().background(BgDeep)) {
        Surface(color = BgSurface, shadowElevation = 2.dp) {
            Column(Modifier.fillMaxWidth().padding(16.dp, 48.dp, 16.dp, 14.dp)) {
                Text("শেখো", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.ExtraBold)
                Text("${cats.size}টি Category — ${cats.sumOf{it.prepositions.size}} Preposition", style = MaterialTheme.typography.bodySmall, color = TxtSecondary)
            }
        }

        LazyColumn(Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(cats) { cat ->
                val catLearned = cat.prepositions.count { it.id in learnedIds }
                val prog       = if (cat.prepositions.isNotEmpty()) catLearned.toFloat() / cat.prepositions.size else 0f
                val color      = Color(cat.color)

                Card(
                    onClick = { onCategory(cat.id) },
                    modifier = Modifier.fillMaxWidth(),
                    colors   = CardDefaults.cardColors(BgCard),
                    shape    = RoundedCornerShape(20.dp)
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            PrepIllustration(
                                cat.prepositions.firstOrNull()?.imageType ?: "img_in",
                                color, Modifier.size(72.dp)
                            )
                            Spacer(Modifier.width(14.dp))
                            Column(Modifier.weight(1f)) {
                                Text(cat.title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.ExtraBold, color = color)
                                Text(cat.titleBn, style = MaterialTheme.typography.bodyMedium, color = TxtPrimary)
                                Text(cat.description, style = MaterialTheme.typography.bodySmall, color = TxtSecondary)
                                Spacer(Modifier.height(4.dp))
                                Text("${cat.prepositions.size} টি Preposition", style = MaterialTheme.typography.labelMedium, color = color)
                            }
                            Icon(Icons.Filled.ChevronRight, null, tint = TxtHint)
                        }
                        Spacer(Modifier.height(12.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            LinearProgressIndicator(
                                progress = prog,
                                modifier = Modifier.weight(1f).height(6.dp).clip(RoundedCornerShape(3.dp)),
                                color = color, trackColor = BgElevated
                            )
                            Spacer(Modifier.width(10.dp))
                            Text("$catLearned/${cat.prepositions.size}", style = MaterialTheme.typography.labelSmall, color = TxtSecondary)
                        }
                    }
                }
            }
        }
    }
}
