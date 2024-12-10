import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class TaskEntity(
    val taskId: Int,
    val description: String,
    Checked: Boolean = false
) {


    var isSelected by mutableStateOf(Checked)

}

