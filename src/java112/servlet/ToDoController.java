package java112.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java112.toDo.*;
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

        //Below code is for testing purposes
        Date tdate = new Date("04/29/2023");
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

        taskId++;
        //Date dueDate = request.getParameter("dueDate");
        Date dueDate = new Date("04/29/2023"); // <== testing only
        String description = request.getParameter("description");
        boolean completionStatus = false;

        Task newTask = new Task(taskId, dueDate, description, completionStatus);

        taskList.add(newTask);

        request.setAttribute("taskList", taskList);
        
        String url = "/tasklist.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}
