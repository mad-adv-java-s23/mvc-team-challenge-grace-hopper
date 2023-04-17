<!DOCTYPE html>
<html>
  <head>
    <meta name="generator" content="HTML Tidy, see www.w3.org">
    <title>To-Do List App Diagram</title>
  </head>

  <body>
    <h1>To-Do List Application Diagram</h1>
    <pre>
    +---------+            +-------------------------+           +-----------------------------------------+
    |  User   |--Interact->| tasklist.jsp (Jsp/View) |<-Request->|  ToDoController.java (Servlet/Control)  |
    +---------+            +-------------------------+           +-----------------------------------------+
                                                                                      ^
                                                                                      |
                                                                                   Update
                                                                                      |
                                                                                      v
                                                                      +----------------------------+
                                                                      | Task.java (JavaBean/Model) |
                                                                      +----------------------------+
    </pre>
    <p>
    This MVC application allows users to manage a task list. Users can view their tasks, add new tasks, and mark tasks as completed.
    </p>
    <p>
    The application flow:
    <ol>
      <li>User views the tasklist.jsp page (through the servlet) which displays a table of tasks and a form to add new tasks.</li>
      <li>When marking a task as completed, the ToDoController servlet processes the request and updates the task's completion status in the Task model.</li>
      <li>When submitting a new task, the ToDoController servlet processes the request and adds the new task to the taskList stored in the Task model.</li>
    </ol>
    </p>
    <br />
    <a href="/java112/toDoList">View Task List</a>
  </body>
</html>
