import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sourceServlet")
public class SourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("userName");

		// instantiate a session objection
		HttpSession session = request.getSession();

		// set an attribute that can be retrieved by the next servlet
		session.setAttribute("user", username);

		// create a hyperlink to go to the next servlet which will process the request
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Reimbursement System</h1>");
		out.println("<h3>Welcome, </h3><h3>"+username+"</h3></br>");
		out.println("<a href='index.html'>go to application</a>");
		//out.println("<a href='targetServlet'>Click Here to get the UserName</a>");
	}
}
