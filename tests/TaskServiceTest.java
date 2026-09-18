/**
 * Rose Benson
 * Module 4
 * CS 320
 */

package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Task.TaskService;
import Task.Task;

public class TaskServiceTest {
	
	private TaskService service;
	
	@BeforeEach
	void setup() {
		service = new TaskService();
	}
	
	/**
	 * Test adding new task
	 */
	@Test
	@DisplayName("Add Task")
	void testAddTask() {
		Task task = new Task("12345", "Dishes", "Washed and put away");
		service.addTask(task);
		
		// Check that the task was added 
		assertEquals(1, service.getTaskList().size());
		assertEquals("12345", service.getTaskList().get(0).getUniqueId());
		assertEquals("Dishes", service.getTaskList().get(0).getName());
		assertEquals("Washed and put away", service.getTaskList().get(0).getDescription());
		
	}
	
	/**
	 * Test throws an exception when duplicating Unique ID
	 */
	@Test
	@DisplayName("Duplicated Unique ID")
	void testAddDuplicateUniqueId() {
		Task task1 = new Task("12345", "Dishes", "Washed and put away");
		Task task2 = new Task("12345", "Dishes", "Washed and put away");
		
		service.addTask(task1);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(task2);
		});
	}
	
	/**
	 * Test deleting an existing task by Unique Id
	 */
	@Test
	@DisplayName("Delete existing task")
	void testDeleteTask() {
		Task task = new Task("12345", "Dishes", "Washed and put away");
		service.addTask(task);
		
		service.deleteTask("12345");
		assertEquals(0, service.getTaskList().size());
		
	}
	
	/**
	 * Test deleting a non-existing Unique ID throws an exception 
	 */
	@Test
	@DisplayName("Delete non-existant task should throw exception")
	void testDeleteNonExistantTask() {
		assertThrows(IllegalArgumentException.class, ()-> {
			service.deleteTask("1223");
		});
	}
	
	/**
	 * Test updating the name of a task
	 */
	@Test
	@DisplayName("Update task name")
	void testUpdateTaskName() {
		Task task = new Task("12345", "Dishes", "washed and put away");
		service.addTask(task);
		
		service.updateTaskName("12345", "Laundry");
		
		assertEquals("Laundry", service.getTaskList().get(0).getName());
	}
	
	/**
	 * Test updating the description of an existing task
	 */
	@Test
	@DisplayName("Update task description")
	void testUpdateTaskDescription() {
		Task task = new Task("12345", "Dishes","Washed and put away");
		service.addTask(task);
		
		service.updateTaskDescription("12345", "Cleaned the bathroom");
		assertEquals("Cleaned the bathroom", service.getTaskList().get(0).getDescription());
		
	}
	
	/**
	 * Test updating a non-existant task should throw an exception
	 */
	@Test
	@DisplayName("Updating non-existent task should throw exception")
	void testUpdateNonExistantTask() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateTaskName("123", "Finished all Yard work");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateTaskDescription("123", "Something else");
		});
	}

}
