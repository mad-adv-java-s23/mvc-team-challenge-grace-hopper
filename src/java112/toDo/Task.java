package java112.toDo;
import java.util.Date;
/**
 * This JavaBean class represents a task in Team grace Hopper's To-Do application.
 * @author npatino
 */
 public class Task {
     private int id;
     private Date dueDate;
     private String description;
     private boolean completionStatus;
     /**
      * Constructs a new empty Task.
      */
     public Task() {
     }
     /**
      * Constructs a new Task with the given ID, due date, description, and completion status.
      * @param id the ID of the task
      * @param dueDate the due date of the task
      * @param description the description of the task
      * @param completionStatus the completion status of the task
      */
     public Task(int id, Date dueDate, String description, boolean completionStatus) {
         this.id = id;
         this.dueDate = dueDate;
         this.description = description;
         this.completionStatus = completionStatus;
     }
     /**
      * Gets the ID of the task.
      * @return the ID of the task
      */
     public int getId() {
         return id;
     }
     /**
      * Sets the ID of the task.
      * @param id the ID of the task
      */
     public void setId(int id) {
         this.id = id;
     }
     /**
      * Gets the due date of the task.
      * @return the due date of the task
      */
     public Date getDueDate() {
         return dueDate;
     }
     /**
      * Sets the due date of the task.
      * @param dueDate the due date of the task
      */
     public void setDueDate(Date dueDate) {
         this.dueDate = dueDate;
     }
     /**
      * Gets the description of the task.
      * @return the description of the task
      */
     public String getDescription() {
         return description;
     }
     /**
      * Sets the description of the task.
      * @param description the description of the task
      */
     public void setDescription(String description) {
         this.description = description;
     }
     /**
      * Returns the completion status of the task.
      * @return true if the task is completed, false otherwise
      */
     public boolean isCompletionStatus() {
         return completionStatus;
     }
     /**
      * Sets the completion status of the task.
      * @param completionStatus true if the task is completed, false otherwise
      */
     public void setCompletionStatus(boolean completionStatus) {
         this.completionStatus = completionStatus;
     }
 }
