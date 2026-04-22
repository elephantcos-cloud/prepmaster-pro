package com.prepmaster.app.ui.screens.comparison

import androidx.compose.foundation.background
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prepmaster.app.data.model.ComparisonGroup
import com.prepmaster.app.data.model.ComparisonItem
import com.prepmaster.app.ui.AppViewModel
import com.prepmaster.app.ui.components.PrepIllustration
import com.prepmaster.app.ui.theme.*

@Composable
fun ComparisonScreen(onBack: () -> Unit, vm: AppViewModel = viewModel()) {
    val groups = vm.comparisons
    var selected by remember { mutableStateOf<ComparisonGroup?>(null) }

    if (selected != null) {
        ComparisonDetailScreen(group = selected!!, onBack = { selected = null })
        return
    }

    Column(Modifier.fillMaxSize().background(BgDeep)) {
        Surface(color = BgSurface, shadowElevation = 2.dp) {
            Row(Modifier.fillMaxWidth().padding(16.dp, 48.dp, 16.dp, 14.dp), verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onBack) { Icon(Icons.Filled.ArrowBack, null, tint = TxtPrimary) }
                Spacer(Modifier.width(4.dp))
                Column {
                    Text("Comparison", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
                    Text("Similar preposition-এর পার্থক্য", style = MaterialTheme.typography.bodySmall, color = TxtSecondary)
                }
            }
        }
        LazyColumn(Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(groups) { group ->
                val color = Color(group.color)
                Card(
                    onClick = { selected = group },
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(BgCard),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        Box(Modifier.size(48.dp).background(color.copy(0.15f), RoundedCornerShape(12.dp)), contentAlignment = Alignment.Center) {
                            Icon(Icons.Filled.CompareArrows, null, tint = color, modifier = Modifier.size(24.dp))
                        }
                        Spacer(Modifier.width(14.dp))
                        Column(Modifier.weight(1f)) {
                            Text(group.title, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
                            Text(group.titleBn, style = MaterialTheme.typography.bodySmall, color = TxtSecondary)
                            Spacer(Modifier.height(6.dp))
                            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                group.items.forEach { item ->
                                    Surface(shape = RoundedCornerShape(8.dp), color = color.copy(0.18f)) {
                                        Text(item.prep, Modifier.padding(8.dp, 3.dp), color = color, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelMedium)
                                    }
                                }
                            }
                        }
                        Icon(Icons.Filled.ChevronRight, null, tint = TxtHint)
                    }
                }
            }
        }
    }
}

@Composable
private fun ComparisonDetailScreen(group: ComparisonGroup, onBack: () -> Unit) {
    val color = Color(group.color)
    Column(Modifier.fillMaxSize().background(BgDeep)) {
        Surface(color = BgSurface, shadowElevation = 2.dp) {
            Row(Modifier.fillMaxWidth().padding(16.dp, 48.dp, 16.dp, 14.dp), verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onBack) { Icon(Icons.Filled.ArrowBack, null, tint = TxtPrimary) }
                Spacer(Modifier.width(4.dp))
                Column {
                    Text(group.title, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
                    Text(group.titleBn, style = MaterialTheme.typography.bodySmall, color = TxtSecondary)
                }
            }
        }
        LazyColumn(Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            item {
                Card(colors = CardDefaults.cardColors(BgCard), shape = RoundedCornerShape(16.dp), modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp)) {
                        Text("Quick Comparison", fontWeight = FontWeight.Bold, color = color)
                        Spacer(Modifier.height(10.dp))
                        group.items.forEachIndexed { idx, item ->
                            Row(Modifier.fillMaxWidth().padding(vertical = 5.dp), verticalAlignment = Alignment.Top) {
                                Surface(shape = RoundedCornerShape(6.dp), color = color.copy(0.2f)) {
                                    Text(item.prep, Modifier.padding(10.dp, 3.dp), color = color, fontWeight = FontWeight.ExtraBold, style = MaterialTheme.typography.labelLarge)
                                }
                                Spacer(Modifier.width(10.dp))
                                Column {
                                    Text(item.meaningBn, fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.bodyMedium)
                                    Text(item.rule, style = MaterialTheme.typography.bodySmall, color = TxtSecondary)
                                }
                            }
                            if (idx < group.items.size - 1) Divider(color = Divider, modifier = Modifier.padding(vertical = 3.dp))
                        }
                    }
                }
            }
            items(group.items) { item -> ComparisonItemCard(item = item, color = color) }
        }
    }
}

@Composable
private fun ComparisonItemCard(item: ComparisonItem, color: Color) {
    Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(BgCard), shape = RoundedCornerShape(16.dp)) {
        Column(Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(Modifier.size(44.dp).background(color.copy(0.2f), RoundedCornerShape(10.dp)), contentAlignment = Alignment.Center) {
                    Text(item.prep, fontWeight = FontWeight.ExtraBold, color = color, style = MaterialTheme.typography.titleMedium)
                }
                Spacer(Modifier.width(12.dp))
                Column(Modifier.weight(1f)) {
                    Text(item.prep, fontWeight = FontWeight.ExtraBold, style = MaterialTheme.typography.titleLarge, color = color)
                    Text(item.meaningBn, style = MaterialTheme.typography.bodyMedium)
                }
                if (item.imageType.isNotEmpty()) PrepIllustration(item.imageType, color, Modifier.size(70.dp))
            }
            Spacer(Modifier.height(10.dp))
            Surface(shape = RoundedCornerShape(10.dp), color = color.copy(0.08f), modifier = Modifier.fillMaxWidth()) {
                Text(item.rule, Modifier.padding(12.dp), style = MaterialTheme.typography.bodySmall)
            }
            Spacer(Modifier.height(10.dp))
            Text("উদাহরণ:", style = MaterialTheme.typography.labelLarge, color = color)
            Spacer(Modifier.height(6.dp))
            item.examples.forEach { ex ->
                Row(Modifier.padding(vertical = 3.dp)) {
                    Box(Modifier.size(6.dp).clip(CircleShape).background(color).align(Alignment.CenterVertically))
                    Spacer(Modifier.width(8.dp))
                    Column {
                        Text(ex.sentence, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Medium)
                        Text(ex.translation, style = MaterialTheme.typography.bodySmall, color = TxtSecondary)
                    }
                }
            }
        }
    }
}
