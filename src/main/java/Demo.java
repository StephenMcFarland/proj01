import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.proj01.models.Employee;
import com.proj01.services.*;
/**
 * Servlet implementation class Demo
 */
@WebServlet({ "/","/Demo", "/home", "/testurlmap", "/1" })
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PostgresConnector connector;
    private PGEmployeeRepository employeeService;

    public Demo() {
        super();

//            this.connector = new PostgresConnector();
//            this.employeeService = new PGEmployeeRepository(this.connector);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//resp.getWriter().append("Served at: ").append(req.getContextPath());
	    ObjectMapper om = new ObjectMapper();
        String responseText = "";
        if(req.getParameterMap().containsKey("name")) {
            String name = req.getParameter("name");
            //Employee e = employeeService.getEmployeeByName(name);
            //List<Employee> employeeList = employeeService.getById(6);
            int[] employeeList = {1,2,1235845123,4,4,9};
            responseText = om.writeValueAsString(employeeList);
            //responseText = om.writeValueAsString(Arrays.asList(e));
        } else {
            //List<Employee> employeeList = employeeService.getAll();
            responseText = om.writeValueAsString("employeeList");
        }
        resp.setContentType("application/json");
        resp.setStatus(200);
        resp.getWriter().write(responseText.toString());
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
