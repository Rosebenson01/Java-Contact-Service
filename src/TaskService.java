/**
 * Rose Benson
 * Module 4
 * CS 320
 */


package Task;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
	
	private final List<Task> taskList = new ArrayList<>();
	// Add a new task
	public void addTask(Task task) {
		for (Task t : taskList) {
			if (t.getUniqueId().equals(task.getUniqueId())) {
				throw new IllegalArgumentException("Task ID already exists");
			}
		}
		taskList.add(task);
		
	}
	
	//Delete a task ID
	public void deleteTask(String UniqueId) {
		boolean removed = taskList.removeIf(task -> task.getUniqueId().equals(UniqueId));
		if (!removed) {
			throw new IllegalArgumentException("Task ID is not found");
		}
	}
	//Update task name by ID
	public void updateTaskName(String UniqueId, String Name) {
		for (Task task : taskList) {
			if (task.getUniqueId().equals(UniqueId) ) {
				task.setName(Name);
				return;
			}
		}
		throw new IllegalArgumentException("Task ID is not found");
	}
	
	//Update task description by ID
	public void updateTaskDescription(String UniqueId, String Description) {
		for (Task task : taskList) {
			if (task.getUniqueId().equals(UniqueId)) {
				task.setDescription(Description);
				return;
			}
		}
		throw new IllegalArgumentException("Task ID not found");
	}
	
	// helper for testing
	public List<Task> getTaskList() {
		return taskList;
	}
}
