package com.prepmaster.app.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import com.prepmaster.app.ui.theme.*
import kotlin.math.*

@Composable
fun PrepIllustration(imageType: String, color: Color, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(color.copy(0.08f), RoundedCornerShape(16.dp))
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height
            val boxColor   = color.copy(0.7f)
            val ballColor  = Color(0xFFFF6B6B)
            val arrowColor = Color(0xFF00E676)
            val groundC    = color.copy(0.3f)
            val sw         = 3f

            fun drawBox(x: Float, y: Float, bw: Float, bh: Float) {
                drawRect(color = boxColor, topLeft = Offset(x, y), size = Size(bw, bh), style = Stroke(sw))
                drawRect(color = boxColor.copy(0.2f), topLeft = Offset(x, y), size = Size(bw, bh))
            }
            fun drawBall(cx: Float, cy: Float, r: Float) {
                drawCircle(brush = Brush.radialGradient(listOf(Color(0xFFFF9090), Color(0xFFDD3333)),
                    center = Offset(cx - r * 0.3f, cy - r * 0.3f), radius = r * 1.5f),
                    radius = r, center = Offset(cx, cy))
                drawCircle(color = Color.White.copy(0.3f), radius = r * 0.3f,
                    center = Offset(cx - r * 0.25f, cy - r * 0.25f))
            }
            fun drawGround(y: Float) {
                drawLine(groundC, Offset(w * 0.05f, y), Offset(w * 0.95f, y), sw)
            }
            fun drawArrow(x1: Float, y1: Float, x2: Float, y2: Float) {
                drawLine(arrowColor, Offset(x1, y1), Offset(x2, y2), sw * 1.5f, cap = StrokeCap.Round)
                val angle = atan2((y2 - y1).toDouble(), (x2 - x1).toDouble())
                val aLen = 18f; val aAngle = 0.4f
                drawLine(arrowColor, Offset(x2, y2),
                    Offset(x2 - (aLen * cos(angle - aAngle)).toFloat(), y2 - (aLen * sin(angle - aAngle)).toFloat()), sw * 1.5f)
                drawLine(arrowColor, Offset(x2, y2),
                    Offset(x2 - (aLen * cos(angle + aAngle)).toFloat(), y2 - (aLen * sin(angle + aAngle)).toFloat()), sw * 1.5f)
            }
            fun drawPerson(cx: Float, cy: Float, size: Float, col: Color) {
                drawCircle(col, size * 0.3f, Offset(cx, cy - size * 0.5f))
                drawLine(col, Offset(cx, cy - size * 0.2f), Offset(cx, cy + size * 0.3f), sw * 2, cap = StrokeCap.Round)
                drawLine(col, Offset(cx - size * 0.35f, cy), Offset(cx + size * 0.35f, cy), sw * 2, cap = StrokeCap.Round)
                drawLine(col, Offset(cx, cy + size * 0.3f), Offset(cx - size * 0.3f, cy + size * 0.7f), sw * 2, cap = StrokeCap.Round)
                drawLine(col, Offset(cx, cy + size * 0.3f), Offset(cx + size * 0.3f, cy + size * 0.7f), sw * 2, cap = StrokeCap.Round)
            }
            fun drawClock(cx: Float, cy: Float, r: Float) {
                drawCircle(color = boxColor, radius = r, center = Offset(cx, cy), style = Stroke(sw))
                drawCircle(color = boxColor.copy(0.1f), radius = r, center = Offset(cx, cy))
                drawLine(arrowColor, Offset(cx, cy), Offset(cx, cy - r * 0.6f), sw * 2, cap = StrokeCap.Round)
                drawLine(arrowColor, Offset(cx, cy), Offset(cx + r * 0.45f, cy), sw * 1.5f, cap = StrokeCap.Round)
                for (i in 0 until 12) {
                    val a = (i * 30 - 90) * PI / 180
                    val iLen = if (i % 3 == 0) 0.18f else 0.12f
                    drawLine(boxColor,
                        Offset(cx + (r * (1f - iLen) * cos(a)).toFloat(), cy + (r * (1f - iLen) * sin(a)).toFloat()),
                        Offset(cx + (r * cos(a)).toFloat(), cy + (r * sin(a)).toFloat()), sw)
                }
                drawCircle(color = arrowColor, radius = 4f, center = Offset(cx, cy))
            }

            when (imageType) {
                "img_in" -> {
                    val bx = w*0.2f; val by = h*0.25f; val bw = w*0.6f; val bh = h*0.55f
                    drawBox(bx, by, bw, bh); drawBall(w/2, by+bh*0.55f, bh*0.2f); drawGround(by+bh+10)
                }
                "img_on" -> {
                    val bx = w*0.15f; val by = h*0.45f; val bw = w*0.7f; val bh = h*0.35f
                    drawBox(bx, by, bw, bh); drawBall(w/2, by-bh*0.25f, bh*0.22f); drawGround(by+bh+10)
                }
                "img_under","img_below" -> {
                    val bx = w*0.15f; val by = h*0.2f; val bw = w*0.7f; val bh = h*0.35f
                    drawBox(bx, by, bw, bh); drawBall(w/2, by+bh+bh*0.35f, bh*0.22f); drawGround(by+bh+bh*0.7f+10)
                }
                "img_over","img_above" -> {
                    val bx = w*0.15f; val by = h*0.5f; val bw = w*0.7f; val bh = h*0.3f
                    drawBox(bx, by, bw, bh); drawBall(w/2, by-bh*0.6f, bh*0.25f); drawGround(by+bh+10)
                }
                "img_beside","img_next_to","img_by" -> {
                    val bx = w*0.1f; val by = h*0.3f; val bw = w*0.42f; val bh = h*0.45f
                    drawBox(bx, by, bw, bh); drawBall(bx+bw+w*0.15f, by+bh/2, bh*0.22f); drawGround(by+bh+10)
                }
                "img_between" -> {
                    val bh = h*0.4f; val by = h*0.3f
                    drawBox(w*0.05f, by, w*0.27f, bh); drawBox(w*0.68f, by, w*0.27f, bh)
                    drawBall(w/2, by+bh/2, bh*0.2f); drawGround(by+bh+10)
                }
                "img_among" -> {
                    val r = h*0.1f
                    for (i in 0..4) {
                        val angle = i*(2*PI/5).toFloat()
                        drawBox(w/2+(w*0.3f*cos(angle.toDouble()).toFloat())-r*1.2f,
                            h/2+(h*0.28f*sin(angle.toDouble()).toFloat())-r, r*2.4f, r*2f)
                    }
                    drawBall(w/2, h/2, r*1.1f)
                }
                "img_behind" -> {
                    val bx = w*0.15f; val by = h*0.3f; val bw = w*0.7f; val bh = h*0.45f
                    drawBall(w/2, by+bh*0.3f, bh*0.15f); drawBox(bx, by, bw, bh); drawGround(by+bh+10)
                }
                "img_in_front_of" -> {
                    val bx = w*0.15f; val by = h*0.2f; val bw = w*0.7f; val bh = h*0.45f
                    drawBox(bx, by, bw, bh); drawBall(w/2, by+bh+bh*0.3f, bh*0.2f); drawGround(by+bh+bh*0.6f+10)
                }
                "img_opposite" -> {
                    drawBox(w*0.05f, h*0.3f, w*0.3f, h*0.4f); drawBox(w*0.65f, h*0.3f, w*0.3f, h*0.4f)
                    drawLine(arrowColor, Offset(w*0.38f, h/2), Offset(w*0.62f, h/2), sw*1.5f)
                }
                "img_to","img_toward" -> {
                    drawBall(w*0.15f, h/2, h*0.08f); drawArrow(w*0.25f, h/2, w*0.72f, h/2)
                    drawBox(w*0.7f, h*0.3f, w*0.25f, h*0.4f)
                }
                "img_from","img_from_origin" -> {
                    drawBox(w*0.05f, h*0.3f, w*0.25f, h*0.4f)
                    drawBall(w*0.42f, h/2, h*0.08f); drawArrow(w*0.32f, h/2, w*0.75f, h/2)
                    drawBall(w*0.85f, h/2, h*0.08f)
                }
                "img_into" -> {
                    val bx = w*0.35f; val by = h*0.2f; val bw = w*0.55f; val bh = h*0.55f
                    drawBox(bx, by, bw, bh); drawBall(w*0.2f, h*0.45f, h*0.08f)
                    drawArrow(w*0.3f, h*0.45f, bx+bw*0.4f, h*0.55f)
                }
                "img_onto" -> {
                    val bx = w*0.15f; val by = h*0.45f; val bw = w*0.7f; val bh = h*0.35f
                    drawBox(bx, by, bw, bh); drawBall(w*0.15f, h*0.3f, h*0.09f)
                    drawArrow(w*0.2f, h*0.38f, w/2, by)
                    drawBall(w/2, by-h*0.09f, h*0.09f); drawGround(by+bh+10)
                }
                "img_out_of" -> {
                    val bx = w*0.1f; val by = h*0.2f; val bw = w*0.55f; val bh = h*0.55f
                    drawBox(bx, by, bw, bh); drawBall(w*0.78f, h*0.45f, h*0.08f)
                    drawArrow(bx+bw*0.6f, h*0.5f, w*0.7f, h*0.45f)
                }
                "img_through" -> {
                    drawRect(color=boxColor.copy(0.3f), topLeft=Offset(w*0.3f,h*0.15f), size=Size(w*0.4f,h*0.7f))
                    drawBall(w*0.1f, h/2, h*0.08f); drawArrow(w*0.2f, h/2, w*0.8f, h/2)
                    drawBall(w*0.88f, h/2, h*0.08f)
                }
                "img_across" -> {
                    drawLine(groundC, Offset(w*0.3f,h*0.45f), Offset(w*0.7f,h*0.45f), sw*3)
                    drawBall(w*0.1f, h*0.35f, h*0.08f); drawArrow(w*0.2f, h*0.35f, w*0.88f, h*0.35f)
                }
                "img_along" -> {
                    drawLine(groundC, Offset(w*0.05f,h*0.55f), Offset(w*0.95f,h*0.55f), sw*3)
                    drawBall(w*0.15f, h*0.45f, h*0.07f); drawArrow(w*0.25f, h*0.45f, w*0.75f, h*0.45f)
                }
                "img_up" -> {
                    drawLine(groundC, Offset(w*0.05f,h*0.85f), Offset(w*0.95f,h*0.85f), sw*3)
                    drawArrow(w*0.5f, h*0.75f, w*0.5f, h*0.1f); drawBall(w*0.5f, h*0.08f, h*0.07f)
                }
                "img_down" -> {
                    drawLine(groundC, Offset(w*0.05f,h*0.85f), Offset(w*0.95f,h*0.85f), sw*3)
                    drawBall(w*0.5f, h*0.1f, h*0.07f); drawArrow(w*0.5f, h*0.2f, w*0.5f, h*0.75f)
                }
                "img_past" -> {
                    drawBox(w*0.35f, h*0.25f, w*0.3f, h*0.5f)
                    drawBall(w*0.1f, h*0.35f, h*0.08f); drawArrow(w*0.2f, h*0.35f, w*0.9f, h*0.35f)
                }
                "img_before" -> {
                    drawBall(w*0.15f, h/2, h*0.09f); drawArrow(w*0.27f, h/2, w*0.72f, h/2)
                    val cx = w*0.82f; val cy = h/2; val sr = h*0.12f
                    for (i in 0 until 5) {
                        val a = (i*144-90)*PI/180; val a2 = ((i*144+72)-90)*PI/180
                        drawLine(arrowColor, Offset(cx+(sr*cos(a)).toFloat(),cy+(sr*sin(a)).toFloat()),
                            Offset(cx+(sr*0.4f*cos(a2)).toFloat(),cy+(sr*0.4f*sin(a2)).toFloat()), sw)
                    }
                }
                "img_after" -> {
                    val cx = w*0.2f; val cy = h/2; val sr = h*0.12f
                    for (i in 0 until 5) {
                        val a = (i*144-90)*PI/180; val a2 = ((i*144+72)-90)*PI/180
                        drawLine(arrowColor, Offset(cx+(sr*cos(a)).toFloat(),cy+(sr*sin(a)).toFloat()),
                            Offset(cx+(sr*0.4f*cos(a2)).toFloat(),cy+(sr*0.4f*sin(a2)).toFloat()), sw)
                    }
                    drawArrow(w*0.35f, h/2, w*0.73f, h/2); drawBall(w*0.82f, h/2, h*0.09f)
                }
                "img_at_time","img_on_time","img_in_time","img_during" -> {
                    drawClock(w/2, h/2, h*0.35f)
                }
                "img_since","img_for_time","img_until","img_within","img_throughout" -> {
                    drawLine(boxColor, Offset(w*0.1f,h*0.5f), Offset(w*0.9f,h*0.5f), sw*2)
                    listOf(0.15f,0.35f,0.55f,0.75f,0.9f).forEachIndexed { i, x ->
                        drawCircle(if(i<3) arrowColor else boxColor.copy(0.4f), 8f, Offset(w*x, h*0.5f))
                    }
                    drawArrow(w*0.1f,h*0.5f,w*0.92f,h*0.5f)
                    drawBall(w*0.15f,h*0.38f,h*0.07f); drawBall(w*0.75f,h*0.38f,h*0.07f)
                    drawLine(arrowColor, Offset(w*0.15f,h*0.44f), Offset(w*0.75f,h*0.44f), sw,
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(8f,4f)))
                }
                "img_with" -> {
                    drawPerson(w*0.3f, h*0.35f, h*0.35f, boxColor)
                    drawPerson(w*0.7f, h*0.35f, h*0.35f, arrowColor)
                    drawLine(arrowColor, Offset(w*0.45f,h*0.55f), Offset(w*0.55f,h*0.55f), sw*3, cap=StrokeCap.Round)
                    drawGround(h*0.82f)
                }
                "img_by_agent","img_by_manner" -> {
                    drawPerson(w*0.25f, h*0.4f, h*0.3f, boxColor)
                    drawArrow(w*0.38f, h*0.42f, w*0.62f, h*0.42f)
                    drawRect(color=arrowColor.copy(0.3f), topLeft=Offset(w*0.58f,h*0.5f), size=Size(w*0.3f,h*0.3f))
                    drawRect(color=arrowColor, topLeft=Offset(w*0.58f,h*0.5f), size=Size(w*0.3f,h*0.3f), style=Stroke(sw))
                }
                "img_of","img_of_origin" -> {
                    drawBox(w*0.05f, h*0.2f, w*0.35f, h*0.3f)
                    drawBox(w*0.6f, h*0.5f, w*0.35f, h*0.3f)
                    drawLine(arrowColor, Offset(w*0.22f,h*0.5f), Offset(w*0.77f,h*0.5f), sw,
                        pathEffect=PathEffect.dashPathEffect(floatArrayOf(10f,5f)))
                }
                "img_in_spite_of","img_despite" -> {
                    for (i in 0..4) drawLine(boxColor.copy(0.6f), Offset(w*0.45f,h*(0.1f+i*0.18f)),
                        Offset(w*0.55f,h*(0.1f+i*0.18f)), sw*8)
                    drawBall(w*0.15f,h*0.5f,h*0.08f); drawArrow(w*0.25f,h*0.5f,w*0.85f,h*0.5f)
                }
                "img_with_instrument" -> {
                    // Hand + pen
                    drawLine(boxColor, Offset(w*0.3f,h*0.4f), Offset(w*0.7f,h*0.7f), sw*4, cap=StrokeCap.Round)
                    drawLine(arrowColor, Offset(w*0.68f,h*0.72f), Offset(w*0.88f,h*0.82f), sw*2)
                    drawCircle(arrowColor, 5f, Offset(w*0.3f,h*0.4f))
                }
                "img_on_device" -> {
                    drawRect(color=boxColor.copy(0.15f), topLeft=Offset(w*0.25f,h*0.2f), size=Size(w*0.5f,h*0.6f))
                    drawRect(color=boxColor, topLeft=Offset(w*0.25f,h*0.2f), size=Size(w*0.5f,h*0.6f), style=Stroke(sw))
                    drawLine(arrowColor, Offset(w*0.35f,h*0.38f), Offset(w*0.65f,h*0.38f), sw)
                    drawLine(arrowColor, Offset(w*0.35f,h*0.5f), Offset(w*0.65f,h*0.5f), sw)
                    drawLine(arrowColor, Offset(w*0.35f,h*0.62f), Offset(w*0.55f,h*0.62f), sw)
                }
                "img_because_of","img_due_to","img_owing_to" -> {
                    drawBox(w*0.05f, h*0.3f, w*0.25f, h*0.4f)
                    drawArrow(w*0.33f, h*0.5f, w*0.62f, h*0.5f)
                    drawBox(w*0.65f, h*0.3f, w*0.3f, h*0.4f)
                    drawLine(Color.Red.copy(0.6f), Offset(w*0.08f,h*0.3f), Offset(w*0.08f,h*0.7f), sw*8)
                }
                "img_out_of_reason","img_from_cause" -> {
                    drawBall(w*0.3f, h*0.45f, h*0.12f)
                    drawArrow(w*0.44f, h*0.45f, w*0.82f, h*0.45f)
                    drawBox(w*0.72f, h*0.3f, w*0.22f, h*0.35f)
                }
                "img_to_poss" -> {
                    drawPerson(w*0.2f, h*0.38f, h*0.3f, boxColor)
                    drawLine(arrowColor, Offset(w*0.35f,h*0.48f), Offset(w*0.65f,h*0.48f),
                        pathEffect=PathEffect.dashPathEffect(floatArrayOf(8f,4f)), strokeWidth=sw*1.5f)
                    drawBox(w*0.65f, h*0.3f, w*0.28f, h*0.35f)
                }
                "img_toward" -> {
                    drawBall(w*0.15f, h/2, h*0.08f)
                    drawArrow(w*0.26f, h/2, w*0.68f, h/2)
                    drawBox(w*0.65f, h*0.3f, w*0.28f, h*0.4f)
                }
                "img_around" -> {
                    drawBox(w*0.3f, h*0.3f, w*0.4f, h*0.4f)
                    val cx = w/2; val cy = h/2; val r = h*0.42f
                    for (i in 0..6) {
                        val a = (i * 45 - 20) * PI / 180
                        val bx = cx + (r * cos(a)).toFloat()
                        val by = cy + (r * sin(a)).toFloat()
                        drawCircle(arrowColor.copy(0.6f - i*0.07f), 5f, Offset(bx, by))
                    }
                }
                "img_in_time" -> {
                    drawClock(w/2, h*0.45f, h*0.32f)
                    drawArrow(w*0.2f, h*0.8f, w*0.8f, h*0.8f)
                }
                "img_next_to" -> {
                    drawBox(w*0.08f, h*0.28f, w*0.38f, h*0.44f)
                    drawBall(w*0.62f, h*0.5f, h*0.12f)
                    drawLine(arrowColor.copy(0.5f), Offset(w*0.49f,h*0.5f), Offset(w*0.5f,h*0.5f), sw*4)
                }
                "img_in_addition_to" -> {
                    drawBox(w*0.05f, h*0.25f, w*0.3f, h*0.4f)
                    drawBox(w*0.42f, h*0.25f, w*0.3f, h*0.4f)
                    val cx = w*0.9f; val cy = h*0.45f
                    drawLine(arrowColor, Offset(cx-12f,cy), Offset(cx+12f,cy), sw*2)
                    drawLine(arrowColor, Offset(cx,cy-12f), Offset(cx,cy+12f), sw*2)
                }
                "img_instead_of" -> {
                    drawBall(w*0.2f, h*0.45f, h*0.1f)
                    drawLine(Color.Red.copy(0.7f), Offset(w*0.12f,h*0.35f), Offset(w*0.28f,h*0.55f), sw*2)
                    drawArrow(w*0.32f, h*0.45f, w*0.72f, h*0.45f)
                    drawBall(w*0.82f, h*0.45f, h*0.1f)
                }
                "img_on_behalf_of" -> {
                    drawPerson(w*0.25f, h*0.38f, h*0.28f, boxColor)
                    drawArrow(w*0.4f, h*0.48f, w*0.6f, h*0.48f)
                    drawPerson(w*0.75f, h*0.38f, h*0.28f, arrowColor)
                    drawLine(arrowColor, Offset(w*0.6f,h*0.7f), Offset(w*0.9f,h*0.7f), sw*2)
                }
                "img_according_to" -> {
                    drawRect(color=boxColor.copy(0.2f), topLeft=Offset(w*0.1f,h*0.15f), size=Size(w*0.5f,h*0.5f))
                    drawRect(color=boxColor, topLeft=Offset(w*0.1f,h*0.15f), size=Size(w*0.5f,h*0.5f), style=Stroke(sw))
                    for (i in 0..2) drawLine(boxColor.copy(0.5f), Offset(w*0.2f,h*(0.3f+i*0.1f)), Offset(w*0.5f,h*(0.3f+i*0.1f)), sw)
                    drawArrow(w*0.65f,h*0.35f,w*0.65f,h*0.65f)
                }
                "img_in_case_of" -> {
                    drawBox(w*0.3f, h*0.2f, w*0.4f, h*0.35f)
                    drawLine(Color.Red.copy(0.7f), Offset(w*0.3f,h*0.2f), Offset(w*0.7f,h*0.55f), sw*2)
                    drawLine(Color.Red.copy(0.7f), Offset(w*0.7f,h*0.2f), Offset(w*0.3f,h*0.55f), sw*2)
                    drawLine(boxColor, Offset(w*0.5f,h*0.6f), Offset(w*0.5f,h*0.75f), sw*2)
                    drawCircle(boxColor, sw*3, Offset(w*0.5f,h*0.8f))
                }
                "img_on_top_of" -> {
                    drawBox(w*0.15f, h*0.45f, w*0.7f, h*0.35f)
                    drawBall(w/2, h*0.38f, h*0.1f)
                    drawGround(h*0.82f)
                }
                "img_by_means_of" -> {
                    drawBox(w*0.05f, h*0.3f, w*0.25f, h*0.35f)
                    drawArrow(w*0.33f, h*0.47f, w*0.67f, h*0.47f)
                    drawBox(w*0.7f, h*0.3f, w*0.25f, h*0.35f)
                    drawLine(arrowColor.copy(0.5f), Offset(w*0.4f,h*0.47f), Offset(w*0.6f,h*0.47f), sw*3)
                }
                "img_with_regard_to","img_in_comparison_with" -> {
                    drawBox(w*0.05f, h*0.2f, w*0.38f, h*0.5f)
                    drawBox(w*0.55f, h*0.2f, w*0.38f, h*0.5f)
                    drawLine(arrowColor, Offset(w*0.43f,h*0.45f), Offset(w*0.55f,h*0.45f), sw*2)
                    drawLine(arrowColor, Offset(w*0.49f,h*0.39f), Offset(w*0.49f,h*0.51f), sw*2)
                }
                else -> {
                    drawRect(color=color.copy(0.15f), topLeft=Offset(w*0.1f,h*0.2f), size=Size(w*0.8f,h*0.6f), style=Stroke(sw))
                    drawBall(w*0.5f, h*0.5f, h*0.15f)
                }
            }
        }
    }
}
