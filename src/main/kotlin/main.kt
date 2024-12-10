import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun MainScreen(taskManager: TaskManager) {
    MaterialTheme {
        MainContent(taskManager)
    }
}

@Composable
private fun MainContent(taskManager: TaskManager) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(16.dp)) {
            ContentDisplay()

            TaskOverview(
                tasks = taskManager.taskList,
                onTaskChecked = { task, isChecked ->
                    taskManager.updateTaskStatus(task, isChecked)
                },
                onTaskRemoved = { task ->
                    taskManager.deleteTask(task)
                }
            )
        }
    }
}

fun main() = application {
    val taskManager = TaskManager()

    Window(onCloseRequest = ::exitApplication, title = "Task Manager simon") {
        MainScreen(taskManager)
    }
}
