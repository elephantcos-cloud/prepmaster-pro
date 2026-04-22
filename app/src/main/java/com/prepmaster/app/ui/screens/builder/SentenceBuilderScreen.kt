package com.prepmaster.app.ui.screens.builder

import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prepmaster.app.data.model.SentenceBuilderItem
import com.prepmaster.app.ui.AppViewModel
import com.prepmaster.app.ui.theme.*

@Composable
fun SentenceBuilderScreen(onBack: () -> Unit, vm: AppViewModel = viewModel()) {
    val items   = remember { vm.sentenceItems.shuffled() }
    var current by remember { mutableIntStateOf(0) }
    var selected by remember(current) { mutableStateOf<String?>(null) }
    var revealed by remember(current) { mutableStateOf(false) }
    var score   by remember { mutableIntStateOf(0) }
    var done    by remember { mutableStateOf(false) }

    if (items.isEmpty()) {
        Box(Modifier.fillMaxSize().background(BgDeep), contentAlignment = Alignment.Center) {
            Text("প্রশ্ন নেই", color = TxtHint)
        }
        return
    }

    if (done) {
        BuilderResult(score, items.size,
            onRetry = { score = 0; current = 0; selected = null; revealed = false; done = false },
            onRecord = { vm.recordBuilder(score, items.size) })
        return
    }

    val item    = items[current]
    val isRight = selected == item.answer

    Column(Modifier.fillMaxSize().background(BgDeep)) {
        // Header
        Surface(color = BgSurface, shadowElevation = 2.dp) {
            Column(Modifier.fillMaxWidth().padding(16.dp, 48.dp, 16.dp, 12.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack, null, tint = TxtPrimary)
                    }
                    Column(Modifier.weight(1f)) {
                        Text("Sentence Builder", style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold)
                        Text("সঠিক Preposition বেছে নাও", style = MaterialTheme.typography.bodySmall,
                            color = TxtSecondary)
                    }
                    Surface(shape = RoundedCornerShape(20.dp), color = Mint.copy(0.15f)) {
                        Text("$score/${items.size}", Modifier.padding(12.dp, 4.dp),
                            color = Mint, fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.labelLarge)
                    }
                }
                Spacer(Modifier.height(8.dp))
                LinearProgressIndicator(
                    progress = (current.toFloat() / items.size).coerceIn(0f, 1f),
                    modifier = Modifier.fillMaxWidth().height(5.dp).clip(RoundedCornerShape(3.dp)),
                    color = Cyan, trackColor = BgElevated
                )
            }
        }

        Column(
            Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Question counter
            Text("প্রশ্ন ${current + 1} / ${items.size}",
                style = MaterialTheme.typography.labelLarge, color = TxtSecondary)

            // Sentence card
            Card(colors = CardDefaults.cardColors(BgCard),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(20.dp)) {
                    Text("সঠিক Preposition দিয়ে বাক্য পূরণ করো:",
                        style = MaterialTheme.typography.labelLarge, color = TxtSecondary)
                    Spacer(Modifier.height(12.dp))
                    // Sentence with blank highlighted
                    val parts = item.sentence.split("___")
                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        Text(parts.getOrElse(0) { "" },
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Medium)
                        // Blank box
                        Box(
                            Modifier.defaultMinSize(minWidth = 72.dp)
                                .background(
                                    if (revealed) (if (isRight) Mint.copy(0.2f) else Coral.copy(0.2f))
                                    else Cyan.copy(0.12f),
                                    RoundedCornerShape(8.dp)
                                )
                                .border(2.dp,
                                    if (revealed) (if (isRight) Mint else Coral)
                                    else Cyan.copy(0.5f),
                                    RoundedCornerShape(8.dp))
                                .padding(horizontal = 10.dp, vertical = 6.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                if (revealed) item.answer else (selected ?: "___"),
                                color = if (revealed) (if (isRight) Mint else Coral) else Cyan,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                        Text(parts.getOrElse(1) { "" },
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Medium)
                    }
                    Spacer(Modifier.height(8.dp))
                    Text(item.translation, style = MaterialTheme.typography.bodySmall,
                        color = TxtSecondary)
                }
            }

            // Options grid
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                item.options.chunked(2).forEach { row ->
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        row.forEach { opt ->
                            val isSelected = selected == opt
                            val optIsCorrect = opt == item.answer
                            val bg = when {
                                !revealed -> if (isSelected) Purple.copy(0.25f) else BgCard2
                                optIsCorrect -> Mint.copy(0.2f)
                                isSelected && !optIsCorrect -> Coral.copy(0.2f)
                                else -> BgCard2
                            }
                            val border = when {
                                !revealed -> if (isSelected) Purple else Divider
                                optIsCorrect -> Mint
                                isSelected && !optIsCorrect -> Coral
                                else -> Divider
                            }
                            Surface(
                                onClick = { if (!revealed) { selected = opt } },
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(14.dp),
                                color = bg,
                                border = BorderStroke(1.5.dp, border)
                            ) {
                                Row(
                                    Modifier.fillMaxWidth().padding(14.dp, 12.dp),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    if (revealed && optIsCorrect)
                                        Icon(Icons.Filled.CheckCircle, null, tint = Mint,
                                            modifier = Modifier.size(16.dp).padding(end = 4.dp))
                                    if (revealed && isSelected && !optIsCorrect)
                                        Icon(Icons.Filled.Cancel, null, tint = Coral,
                                            modifier = Modifier.size(16.dp).padding(end = 4.dp))
                                    Text(opt, fontWeight = FontWeight.Bold, color = TxtPrimary,
                                        style = MaterialTheme.typography.titleMedium)
                                }
                            }
                        }
                        if (row.size == 1) Spacer(Modifier.weight(1f))
                    }
                }
            }

            // Explanation (shown after reveal)
            AnimatedVisibility(visible = revealed) {
                Card(colors = CardDefaults.cardColors(Gold.copy(0.1f)),
                    shape = RoundedCornerShape(14.dp),
                    border = BorderStroke(1.dp, Gold.copy(0.3f)),
                    modifier = Modifier.fillMaxWidth()) {
                    Row(Modifier.padding(14.dp)) {
                        Icon(Icons.Filled.Lightbulb, null, tint = Gold,
                            modifier = Modifier.size(20.dp))
                        Spacer(Modifier.width(8.dp))
                        Text(item.explanation, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }

            Spacer(Modifier.height(4.dp))

            // Action button
            Button(
                onClick = {
                    if (!revealed && selected != null) {
                        revealed = true
                        if (isRight) score++
                    } else if (revealed) {
                        if (current < items.size - 1) {
                            current++
                            selected = null
                            revealed = false
                        } else {
                            done = true
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth().height(52.dp),
                shape = RoundedCornerShape(14.dp),
                enabled = selected != null || revealed,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (revealed && isRight) Mint else if (revealed) Coral else Purple
                )
            ) {
                Text(
                    when {
                        !revealed -> "উত্তর দেখো"
                        current < items.size - 1 -> "পরবর্তী"
                        else -> "শেষ করো"
                    },
                    fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

@Composable
private fun BuilderResult(score: Int, total: Int, onRetry: () -> Unit, onRecord: () -> Unit) {
    val pct   = if (total > 0) score * 100 / total else 0
    val color = when { pct >= 80 -> Mint; pct >= 50 -> Gold; else -> Coral }
    val msg   = when { pct >= 80 -> "চমৎকার!"; pct >= 50 -> "ভালো করেছ!"; else -> "আরো চেষ্টা করো" }

    LaunchedEffect(Unit) { onRecord() }

    Column(Modifier.fillMaxSize().background(BgDeep),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Box(Modifier.size(120.dp).background(color.copy(0.15f), CircleShape),
            contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("$pct%", style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.ExtraBold, color = color)
            }
        }
        Spacer(Modifier.height(20.dp))
        Text(msg, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        Text("$score / $total সঠিক", style = MaterialTheme.typography.bodyLarge, color = TxtSecondary)
        Spacer(Modifier.height(32.dp))
        Button(onClick = onRetry, shape = RoundedCornerShape(14.dp),
            modifier = Modifier.fillMaxWidth(0.6f).height(52.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Purple)) {
            Text("আবার খেলো", fontWeight = FontWeight.Bold)
        }
    }
}
