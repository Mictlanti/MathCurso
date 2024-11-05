package com.horizon.matemticascurso.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.CardFormula
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.DiferenciaCuadrados
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.Exponente
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ExponenteLarge
import kotlin.reflect.KProperty

val recycleModifier = Modifier
    .fillMaxWidth()
    .padding(bottom = 10.dp)

@Composable
fun CuadradoPerfectoPositivo() {
    CardFormula() {
        Exponente(base = "(a + b)", exponente = "2", modifier = Modifier)
        bodyLarge(text = " = ", modifier = Modifier)
        Exponente(base = "a", exponente = "2", modifier = Modifier)
        bodyLarge(text = " + 2ab + ", modifier = Modifier)
        Exponente(base = "b", exponente = "2", modifier = Modifier)
    }
}

@Composable
fun CuadradoPerfectoNegativo() {
    CardFormula() {
        Exponente(base = "(a - b)", exponente = "2", modifier = Modifier)
        bodyLarge(text = " = ", modifier = Modifier)
        Exponente(base = "a", exponente = "2", modifier = Modifier)
        bodyLarge(text = " - 2ab + ", modifier = Modifier)
        Exponente(base = "b", exponente = "2", modifier = Modifier)
    }
}

@Composable
fun FormulaDiferenciaCuadrados() {
    CardFormula {
        Row {
            bodyLarge(text = "(a + b)(a - b) = ", modifier = Modifier)
            DiferenciaCuadrados(
                baseOne = "a",
                exponenteOne = "2",
                baseTwo = " - b",
                exponenTwo = "2"
            )
        }
    }
}

@Composable
fun FormulaProductoNotable(fontSize: TextUnit = 20.sp) {
    CardFormula {
        Row {
            bodyLarge(text = "(x + a)(x + 2) = ", modifier = Modifier, fontSize = fontSize)
            Exponente(base = "a", exponente = "2", modifier = Modifier, fontSize = fontSize)
            bodyLarge(text = " + (a + b)x + ab", modifier = Modifier, fontSize = fontSize)
        }
    }
}

@Composable
fun FormulaProductoNotableTwo(fontSize: TextUnit = 16.sp) {
    CardFormula {
        Row {
            bodyLarge(text = "(ax + b)(cx + d) = ", modifier = Modifier, fontSize = fontSize)
            Exponente(base = "acx", exponente = "2", modifier = Modifier, fontSize = fontSize)
            bodyLarge(text = " + (ad + bc)x + bd", modifier = Modifier, fontSize = fontSize)
        }
    }
}

@Composable
fun Canvas() {
    @Composable
    fun DragAndDropAnimation() {
        var offsetX by remember { mutableStateOf(0f) }
        var offsetY by remember { mutableStateOf(0f) }

        // Track drag state
        var dragOffset by remember { mutableStateOf(Offset.Zero) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()  // Indicate that gesture is consumed
                        dragOffset += dragAmount  // Update the offset
                    }
                }
        ) {
            /*Canvas(
                modifier = Modifier
                    .size(100.dp)
                    .offset { IntOffset(dragOffset.x.toInt(), dragOffset.y.toInt()) }
                    .background(Color.Blue)
            ) {

            }*/
        }
    }
}

@Composable
fun FormulaFactorizacionOne() {
    CardFormula {
        Row {
            ExponenteLarge(
                b1 = "x",
                b2 = " + (a + b)x + ",
                b3 = "ab =",
                e1 = "2",
                e2 = "",
                e3 = "",
                modifier = Modifier
            )
        }
    }
}

@Composable
fun FormulaFactoTwo(fontSize: TextUnit = 16.sp) {
    CardFormula {
        Row {
            Exponente(base = "acx", exponente = "2", modifier = Modifier, fontSize = fontSize)
            bodyLarge(text = " + (ad + bc)x + bd = ", modifier = Modifier, fontSize = fontSize)
            bodyLarge(text = "(ax + b)(cx + d)", modifier = Modifier, fontSize = fontSize)
        }
    }
}