import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun TaskOverview(
    tasks: List<TaskEntity>,
    onTaskChecked: (task: TaskEntity, isChecked: Boolean) -> Unit,
    onTaskRemoved: (task: TaskEntity) -> Unit
) {
    TaskList(
        tasks = tasks,
        onTaskChecked = onTaskChecked,
        onTaskRemoved = onTaskRemoved
    )
}

@Composable
private fun TaskList(
    tasks: List<TaskEntity>,
    onTaskChecked: (task: TaskEntity, isChecked: Boolean) -> Unit,
    onTaskRemoved: (task: TaskEntity) -> Unit
) {
    LazyColumn {
        items(tasks) { task ->
            TaskElement(
                task = task,
                onRemove = { onTaskRemoved(task) }
            )
        }
    }
}
