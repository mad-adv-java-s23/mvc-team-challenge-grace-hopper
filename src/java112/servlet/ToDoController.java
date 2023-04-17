package java112.servlet;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java112.toDo.*;
import java.text.SimpleDateFormat; // added by Nick
import java.text.ParseException; // added by Nick
import java.util.*;

@WebServlet(
        name = "toDoList",
        urlPatterns = {"/toDoList"}
)
/**
 * Servlet controller for 'To Do List' web app...
 * @author kangelo
 */
public class ToDoController extends HttpServlet {

    private int taskId;
    private ArrayList<Task> taskList;

    /**
     * Initializes the servlet. Sets taskId to 0.
     *
     * @exception  ServletException  if there is a Servlet failure
     */
     public void init() throws ServletException {

         taskId = 0;
         taskList = new ArrayList<Task>();

         Date tdate = null;
         try {
             tdate = new SimpleDateFormat("MM/dd/yyyy").parse("04/29/2023");
         } catch (ParseException e) {
             e.printStackTrace();
         }
         Task task1 = new Task(taskId, tdate, "Demo Task", false);

         taskList.add(task1);
     }


    /**
     * Handles HTTP GET requests.
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("taskList", taskList);

        String url = "/tasklist.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String taskIdParam = request.getParameter("taskId");
        if (taskIdParam != null) {
            int taskId = Integer.parseInt(taskIdParam);
            for (Task task : taskList) {
                if (task.getId() == taskId) {
                    task.setCompletionStatus(true);
                    break;
                }
            }
        } else {
            this.taskId++;
            String dueDateString = request.getParameter("dueDate");
            Date dueDate = null;
            try {
                dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(dueDateString); // changed by Nick
            } catch (ParseException e) { // added by Nick
                e.printStackTrace();
            } // added by Nick
            String description = request.getParameter("description");
            boolean completionStatus = false;

            Task newTask = new Task(taskId, dueDate, description, completionStatus);

            taskList.add(newTask);
        }

        request.setAttribute("taskList", taskList);

        String url = "/tasklist.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}
