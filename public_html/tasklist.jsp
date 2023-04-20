<%@ page import="java.util.List" %>
<%@ page import="java112.toDo.Task" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>To-Do List</title>
  <!-- <link rel="stylesheet" href="styles/style.css"> -->
  <style>
    table {
      width: 100%;
      border-collapse: collapse;
    }
    th, td {
      padding: 8px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }
    th {
      background-color: #f2f2f2;
    }
    tr:hover {
      background-color: #f5f5f5;
    }
    .completed {
      text-decoration: line-through;
    }
  </style>
</head>
<body>
<h1>To-Do List</h1>
<table>
  <tr>
    <th>ID</th>
    <th>Due Date</th>
    <th>Description</th>
    <th>Completion Status</th>
    <th>Actions</th>
  </tr>
  <%
  List<Task> taskList = (List<Task>) request.getAttribute("taskList");
  if (taskList != null) {
      for (Task task : taskList) {
  %>
    <tr>
      <td><%= task.getId() %></td>
      <td><%= task.getDueDate() %></td>
      <td class="<%= task.isCompletionStatus() ? "completed" : "" %>"><%= task.getDescription() %></td>
      <td><%= task.isCompletionStatus() ? "Completed" : "Not Completed" %></td>
      <td>
        <% if (!task.isCompletionStatus()) { %>
          <form method="post" action="/java112/toDoList">
            <input type="hidden" name="taskId" value="<%= task.getId() %>">
            <input type="submit" value="Mark as Completed">
          </form>
        <% } %>
      </td>
    </tr>
  <%
      }
  }
  %>
</table>
<br />
<h3>Add New Task</h3>
<form method="post" action="/java112/toDoList">
  <label for="dueDate">Due Date:</label>
  <input type="date" id="dueDate" name="dueDate" required>
  <br>
  <label for="description">Description:</label>
  <input type="text" id="description" name="description" required>
  <br>
  <input type="submit" value="Add Task">
</form>
<br />
<a href="/java112/appDiagram.jsp">View App Diagram</a>
</body>
</html>
