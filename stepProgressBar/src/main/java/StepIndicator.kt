import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.center
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StepProgressBar(
    modifier: Modifier = Modifier,
    stepList: List<StepModel> = emptyList(),
    completedTextColor: Color = Color.Red,
    completedBackgroundColor: Color = Color.Red,
    completedDrawLineColor: Color = Color.Red,
    uncompletedTextColor: Color = Color.Gray,
    uncompletedBackgroundColor: Color = Color.Gray,
    uncompletedDrawLineColor: Color = Color.Gray,
    completedIcon : ImageVector = Icons.Default.Check,
    iconColor : Color = Color.White
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        stepList.forEachIndexed { index, item ->
            TextStep(
                step = item,
                modifier = Modifier
                    .weight(1f, fill = true)
                    .height(100.dp),
                isFirst = index == 0,
                isLast = index == stepList.size.minus(1),
                completedTextColor = completedTextColor,
                completedBackgroundColor = completedBackgroundColor,
                uncompletedTextColor = uncompletedTextColor,
                uncompletedBackgroundColor = uncompletedBackgroundColor,
                completedDrawLineColor = completedDrawLineColor,
                uncompletedDrawLineColor = uncompletedDrawLineColor,
                completedIcon = completedIcon,
                iconColor = iconColor
            )
        }
    }
}

@Composable
fun TextStep(
    modifier: Modifier = Modifier,
    step: StepModel,
    isFirst: Boolean = false,
    isLast: Boolean = false,
    completedTextColor: Color = Color.Red,
    completedBackgroundColor: Color = Color.Green,
    uncompletedTextColor: Color = Color.Black,
    uncompletedBackgroundColor: Color = Color.Gray,
    completedDrawLineColor: Color = Color.Green,
    uncompletedDrawLineColor: Color = Color.Gray,
    completedIcon : ImageVector,
    iconColor : Color
) {
    val background = if (step.isCompleted) completedBackgroundColor else uncompletedBackgroundColor
    val textColor = if (step.isCompleted) completedTextColor else uncompletedTextColor

    var center by remember {
        mutableStateOf(Offset.Zero)
    }
    val offSet = with(LocalDensity.current) { 2.dp.toPx() }
    Column(
        modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .onSizeChanged {
                    center = Offset(x = it.center.x.toFloat(), y = it.center.y.toFloat())
                }
                .drawBehind {
                    drawLine(
                        color = if (step.isCompleted) completedDrawLineColor else uncompletedDrawLineColor,
                        start = if (isFirst) center else Offset(x = 0f, y = center.y),
                        end = if (isLast) center else Offset(x = center.x * 2f, y = center.y),
                        strokeWidth = offSet
                    )
                },
            contentAlignment = Alignment.Center
        ) {
            if (step.isCompleted) {
                Icon(
                    imageVector = completedIcon,
                    contentDescription = null,
                    tint = iconColor,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(24.dp) // Daire boyutu artırıldı
                        .background(background)
                        .padding(4.dp)
                )
            } else {
                Canvas(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(24.dp) // Daire boyutu artırıldı
                        .background(background)
                        .padding(9.dp)
                ) {
                    drawCircle(color = background)
                }
            }
        }


        step.title?.let {
            Text(
                text = it,
                color = textColor,
                fontSize = 11.sp,
                lineHeight = 12.sp,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

    }
}
