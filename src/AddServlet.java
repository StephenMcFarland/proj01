
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj01.services.PostgresConnector;
import com.proj01.services.PGEmployeeRepository;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private PostgresConnector connector;
	private PGEmployeeRepository employeeRepository;

	public AddServlet() {
		this.connector = new PostgresConnector();
		this.employeeRepository = new PGEmployeeRepository(this.connector);

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AddServlet app = new AddServlet();
		
		int user_id = Integer.parseInt(request.getParameter("id"));
		String empName = request.getParameter("empName");
		long empPhone = Long.parseLong(request.getParameter("empPhone"));
		String empAddress = request.getParameter("empAddress");
		String email = request.getParameter("email");
		app.employeeRepository.save(user_id, empName, empPhone, empAddress, email);

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<a href='index.html'>Back</a><br>");
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
