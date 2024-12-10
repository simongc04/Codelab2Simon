import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

private fun generateTasks() = List(51) { index -> TaskEntity(index, "Task #$index") }

class TaskManager : ViewModel() {
    private val _taskList = generateTasks().toMutableStateList()
    val taskList: List<TaskEntity> get() = _taskList

    fun deleteTask(task: TaskEntity) {
        _taskList.remove(task)
    }

    fun updateTaskStatus(task: TaskEntity, isChecked: Boolean) {
        _taskList.find { it.taskId == task.taskId }?.apply {
            isSelected = isChecked
        }
    }
}

private fun List<TaskEntity>.findTask(taskId: Int) = find { it.taskId == taskId }
