/**
* Rose Benson
* Module 4
* CS 320
*/

package Task;

public class Task {
	
	// Can't be longer than 10 characters and can not be null and shall not be updatable
	private String UniqueId; 
	// Can't be longer than 20 characters  and can't be null
	private String Name;
	// Can't be longer than 50 characters and can not be null
	private String Description;
	
	//Unique identifier cannot be null, longer than 10 character, and through an exception
	
	public Task(String UniqueId, String Name, String Description) {
		if (UniqueId == null || UniqueId.length() > 10) { 
			//Testing for an exception
			throw new IllegalArgumentException("Invalide ID");
		}
		if (Name == null || Name.length() > 20) {
			//Testing for an exception
			throw new IllegalArgumentException("Invalid name");
		}
		if (Description == null || Description.length() > 50) {
			//Testing for an exception
			throw new IllegalArgumentException("Invalid description");
		}
		
		
		// Assigning values after validating
		this.UniqueId = UniqueId;
		this.Name = Name;
		this.Description = Description;
	}
	
	/**
	 * @return the task ID
	 * Task ID cannot be updated
	 */
	
	public String getUniqueId() {
		return UniqueId;
	}
	
	/**
	 * @return task name.
	 */
	
	public String getName() {
		return Name;
	}
	
	/**
	 * Throws an exception if the test fails.
	 * @param Name new task Name
	 */
	public void setName(String Name) {
		if (Name == null || Name.length() > 20) {
			throw new IllegalArgumentException("Invalid name");
		}
		this.Name = Name;
	}
	
	public String getDescription() {
		return Description;
	}
	
	/**
	 * Throws an exception if the test fails.
	 * @param description new task description
	 */
	
	public void setDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		this.Description = description;
	}

}
