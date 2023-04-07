<!DOCTYPE html>
    <html lang="en">
       <head>
            <meta charset="utf-8">
            <title>Task List</title>
            <link rel="stylesheet" href="css/style.css" media="screen" />
       </head>
       <body>
            <header>
                <h1>Task List</h1>
                <br />
                <form method="post"  action="./DemoServlet" id="new-task-form">
                   
                    <label>Due Date</label>
                    <input type="data" name="dueDate" id="duedate">
                    
                    <br />
                    <label>Description</label>
                    <input type="text" name="description" id="description" placeholder="What do you have planned?">
                    
                    <div>
                        <input type="submit" value="Submit">
                        <input type="reset" value="Reset">
                    </div>
                </form>
            </header>
            <br />
             <main>
              <section class="task-list">
                <h2>Tasks</h2>
                  <div id="task">
                    <c:forEach var="task" items="${taskList}">
                        <li>${task}</li>
                      </c:forEach>
                    </div>
              </section>
             </main>
       </body>
    </html>