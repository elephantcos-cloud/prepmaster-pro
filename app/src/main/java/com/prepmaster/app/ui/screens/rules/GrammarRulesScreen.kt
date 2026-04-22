package com.prepmaster.app.ui.screens.rules

import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prepmaster.app.data.model.GrammarRule
import com.prepmaster.app.ui.AppViewModel
import com.prepmaster.app.ui.theme.*

@Composable
fun GrammarRulesScreen(onBack: () -> Unit, vm: AppViewModel = viewModel()) {
    val rules = vm.grammarRules
    var expanded by remember { mutableStateOf<String?>(null) }

    Column(Modifier.fillMaxSize().background(BgDeep)) {
        Surface(color = BgSurface, shadowElevation = 2.dp) {
            Row(Modifier.fillMaxWidth().padding(16.dp, 48.dp, 16.dp, 14.dp),
                verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onBack) {
                    Icon(Icons.Filled.ArrowBack, null, tint = TxtPrimary)
                }
                Spacer(Modifier.width(4.dp))
                Column {
                    Text("Grammar Rules", style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold)
                    Text("Preposition-এর ১০টি মূল নিয়ম",
                        style = MaterialTheme.typography.bodySmall, color = TxtSecondary)
                }
            }
        }

        LazyColumn(Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)) {
            itemsIndexed(rules) { idx, rule ->
                GrammarRuleCard(
                    rule = rule,
                    idx = idx + 1,
                    isExpanded = expanded == rule.id,
                    onToggle = { expanded = if (expanded == rule.id) null else rule.id }
                )
            }
        }
    }
}

@Composable
private fun GrammarRuleCard(rule: GrammarRule, idx: Int, isExpanded: Boolean, onToggle: () -> Unit) {
    val colors = listOf(CatPlace, CatTime, CatMove, CatManner, CatCause,
        CatAgent, CatPoss, CatCompound, CatSource, Purple)
    val color  = colors[(idx - 1) % colors.size]

    Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(BgCard),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, if (isExpanded) color.copy(0.4f) else Divider)) {
        Column {
            // Header - always visible
            Row(Modifier.fillMaxWidth().clickable(onClick = onToggle).padding(16.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Box(Modifier.size(36.dp).background(color.copy(0.2f), CircleShape),
                    contentAlignment = Alignment.Center) {
                    Text("$idx", color = color, fontWeight = FontWeight.ExtraBold,
                        style = MaterialTheme.typography.titleMedium)
                }
                Spacer(Modifier.width(12.dp))
                Column(Modifier.weight(1f)) {
                    Text(rule.title, fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium)
                    Text(rule.titleBn, style = MaterialTheme.typography.bodySmall,
                        color = TxtSecondary)
                }
                Icon(
                    if (isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    null, tint = TxtSecondary
                )
            }

            // Expanded content
            AnimatedVisibility(visible = isExpanded) {
                Column(Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
                    Divider(color = Divider)
                    Spacer(Modifier.height(12.dp))

                    // Rule box
                    Surface(shape = RoundedCornerShape(10.dp), color = color.copy(0.08f),
                        modifier = Modifier.fillMaxWidth()) {
                        Text(rule.rule, Modifier.padding(14.dp),
                            style = MaterialTheme.typography.bodyMedium)
                    }

                    if (rule.exceptions.isNotEmpty()) {
                        Spacer(Modifier.height(10.dp))
                        Surface(shape = RoundedCornerShape(10.dp),
                            color = Gold.copy(0.08f),
                            border = BorderStroke(1.dp, Gold.copy(0.3f)),
                            modifier = Modifier.fillMaxWidth()) {
                            Row(Modifier.padding(12.dp)) {
                                Icon(Icons.Filled.Warning, null, tint = Gold,
                                    modifier = Modifier.size(16.dp))
                                Spacer(Modifier.width(6.dp))
                                Text("Exception: ${rule.exceptions}",
                                    style = MaterialTheme.typography.bodySmall, color = Gold)
                            }
                        }
                    }

                    Spacer(Modifier.height(10.dp))
                    Text("উদাহরণ:", style = MaterialTheme.typography.labelLarge, color = color)
                    Spacer(Modifier.height(6.dp))
                    rule.examples.forEach { ex ->
                        Row(Modifier.padding(vertical = 3.dp)) {
                            Icon(Icons.Filled.Circle, null, tint = color,
                                modifier = Modifier.size(8.dp).padding(top = 6.dp))
                            Spacer(Modifier.width(8.dp))
                            Column {
                                Text(ex.sentence, fontWeight = FontWeight.Medium,
                                    style = MaterialTheme.typography.bodyMedium)
                                Text(ex.translation, style = MaterialTheme.typography.bodySmall,
                                    color = TxtSecondary)
                            }
                        }
                    }
                }
            }
        }
    }
}
