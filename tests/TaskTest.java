/**
 * Rose Benson
 * Module 4
 * CS 320
 */

package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import Task.Task;

public class TaskTest {
	
	@Test
	@DisplayName("Valid Task Construction")
	void testValidTask() {	
		Task task = new Task("12345", "Dishes", "Washed and put away");
		assertEquals("12345", task.getUniqueId());
		assertEquals("Dishes", task.getName());
		assertEquals("Washed and put away", task.getDescription());
		
	}
	
	/**
	 * Task Unique Id can't be null
	 */
	
	@DisplayName("Uniqiue Id is null")
	@Test
	void testNullUniqueId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Dishes", "Washed and put away");
		});
	}
	/**
	 * Task Unique Id is too long > 10
	 */
	@Test
	@DisplayName("Unique ID is too long")
	void testUniqueIdToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678910", "Dishes", "Washed and put away");	
		});
	}
	/**
	 * Task Name is null
	 */

	@Test
	@DisplayName("Name is null")
	void testNullName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", null, "Washed and put Away");
		});
	}
	/**
	 * Task Name is too long > 20
	 */
	@Test
	@DisplayName("Name is too long")
	void testNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "This task name is too long", "Washed and put away");
		});
	}
	
	/**
	 * Task description can't be null
	 */
	@Test
	@DisplayName("Description is null")
	void testNullDescription() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "Dishes", null);
		});
	}
	
	/**
	 * Task description is too long can't > 50
	 */
	@Test
	@DisplayName("Description is too long")
	void testDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "Dishes", "This description is way too long input new description");
		});
	}
	
	
}
