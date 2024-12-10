import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ContentDisplay() {
    var chapterCount by rememberSaveable { mutableStateOf(0) }

    Column(modifier = Modifier.padding(16.dp)) {
        if (chapterCount > 0) {
            val chapterText = if (chapterCount == 1) "cubata" else "cubatas"
            Text("Has bebido $chapterCount $chapterText en la fiesta")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { chapterCount++ }, modifier = Modifier.fillMaxWidth()) {
            Text("Beber")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { chapterCount = 0 }, modifier = Modifier.fillMaxWidth()) {
            Text("Resetear")
        }
    }
}
