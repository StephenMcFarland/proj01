import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj01.services.PGEmployeeRepository;
import com.proj01.services.PostgresConnector;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PostgresConnector connector;
	private PGEmployeeRepository employeeRepository;

	public UpdateServlet() {
		this.connector = new PostgresConnector();
		this.employeeRepository = new PGEmployeeRepository(this.connector);

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		UpdateServlet app = new UpdateServlet();
		// List<Employee> employees = app.employeeRepository.getAll();
		// List<Employee> employees = app.employeeRepository.getById(2);
		// app.employeeRepository.delete(6);
		int user_id = Integer.parseInt(request.getParameter("id"));
		String empName = request.getParameter("empName");
		long empPhone = Long.parseLong(request.getParameter("empPhone"));
		String empAddress = request.getParameter("empAddress");
		String email = request.getParameter("email");
		app.employeeRepository.update(user_id, empName, empPhone, empAddress, email);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='index.html'>Back</a><br>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
