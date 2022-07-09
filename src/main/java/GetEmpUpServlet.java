import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.proj01.models.Employee;
import com.proj01.services.PGEmployeeRepository;
import com.proj01.services.PostgresConnector;

import com.fasterxml.jackson.*;


@WebServlet("/GetEmpUpServlet")
public class GetEmpUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//private Gson gson = new Gson();
	//private String jsonInString = "";
	private PostgresConnector connector;
	private PGEmployeeRepository employeeRepository;

	public GetEmpUpServlet() {
		this.connector = new PostgresConnector();
		this.employeeRepository = new PGEmployeeRepository(this.connector);

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();


		
		String user = (String)(session.getAttribute("user"));

		GetEmpUpServlet app = new GetEmpUpServlet();
		List<Employee> employees = app.employeeRepository.getEmpUp(user);


		response.setStatus(200);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write(new ObjectMapper().writeValueAsString(employees));
		//out.println("Must register first to Edit Employee Details");
//		for(Employee e : employees) {
//		out.println(e.getEmail()+e.getEmpAddress()+e.getEmpName()+e.getEmpPhone()+e.getUserId());
//		}
//		out.println("<a href='index.html'>Back</a><br>");
//
//	
//		out.println("<body bgcolor='aliceblue' style='font-family:verdana'>");
//		out.println("<h2>Employees</h2>");
//
//		out.println("<table cellpadding='6'><tr><td></td><td>id</td><td>Name</td><td>Phone</td><td>Address</td><td>Email</td>");
//		for(Employee e : employees) {
//
//		out.println("<tr><td><b>Employee:</b></td><td bgcolor='#CCC'>"+e.getUserId()+"</td><td bgcolor='#FFF'>" +e.getEmpName()+"</td><td bgcolor='#FFF'>"+e.getEmpPhone()+"</td><td bgcolor='#FFF'>"+e.getEmpAddress()+"</td><td bgcolor='#FFF'>"+e.getEmail()+"</td><td><form method='get' action='delete'>"
//				+ "		<input type='submit' value='Delete Employee'><input style='visibility: hidden;' name='id' value='"+e.getUserId()+"'/>"
//			
//				+ "	</form></td></tr>");
//
//		}
//		out.println("</table>");



		
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
