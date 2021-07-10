import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.proj01.models.Employee;
import com.proj01.services.PGEmployeeRepository;
import com.proj01.services.PostgresConnector;

import com.fasterxml.jackson.*;


@WebServlet("/GetEmpServlet")
public class GetEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//private Gson gson = new Gson();
	//private String jsonInString = "";
	private PostgresConnector connector;
	private PGEmployeeRepository employeeRepository;

	public GetEmpServlet() {
		this.connector = new PostgresConnector();
		this.employeeRepository = new PGEmployeeRepository(this.connector);

	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		GetEmpServlet app = new GetEmpServlet();
		List<Employee> employees = app.employeeRepository.getAll();
		//String userJsonString = this.gson.toJson(employees);
		//String employeeJsonString = new Gson().toJson(employees);
//		PrintWriter out = resp.getWriter();
//		resp.setContentType("application/json");
//		resp.setCharacterEncoding("UTF-8");
//		out.print(employeeJsonString);
//		out.flush();


		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<a href='index.html'>Back</a><br>");

		//ObjectMapper mapper = new ObjectMapper();
		//Employee e = new Employee();

		//String jsonInString = ""

		//out.println(employees);
		out.println("<body bgcolor='aliceblue' style='font-family:verdana'>");
		out.println("<h2>Employees</h2>");

		out.println("<table cellpadding='6'><tr><td></td><td>id</td><td>Name</td><td>Phone</td><td>Address</td><td>Email</td>");
		for(Employee e : employees) {

		out.println("<tr><td><b>Employee:</b></td><td bgcolor='#CCC'>"+e.getUserId()+"</td><td bgcolor='#FFF'>" +e.getEmpName()+"</td><td bgcolor='#FFF'>"+e.getEmpPhone()+"</td><td bgcolor='#FFF'>"+e.getEmpAddress()+"</td><td bgcolor='#FFF'>"+e.getEmail()+"</td></tr>");

		}
		out.println("</table>");



		//resp.getWriter().write(jsonInString);
//		 ObjectMapper om = new ObjectMapper();
//	        String responseText = "";
//	        if(req.getParameterMap().containsKey("name")) {
//	            //String name = req.getParameter("name");
//	            //Employee e = employeeService.getEmployeeByName(name);
//	            List<Employee> employeeList = employeeRepository.getById(2);
//	            //int[] employeeList = {1,2,1235845123,4,4,9};
//	            responseText = om.writeValueAsString(employeeList);
//	           // responseText = om.writeValueAsString(Arrays.asList(e));
//	        } else {
//	            //List<Employee> employeeList = employeeService.getAll();
//	            responseText = om.writeValueAsString(employees);
//	        }
//	        resp.setContentType("application/json");
//	        resp.setStatus(200);
//	        resp.getWriter().write(responseText.toString());
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
