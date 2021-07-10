import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.proj01.models.Reimbursement;
import com.proj01.services.PostgresConnector;
import com.proj01.services.ReimbursementService;

@WebServlet("/ReimAddServlet")
public class ReimAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PostgresConnector connector;
	private ReimbursementService reimbursementService;

	public ReimAddServlet() {
		this.connector = new PostgresConnector();
		this.reimbursementService = new ReimbursementService(this.connector);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimAddServlet app = new ReimAddServlet();
		HttpSession session = request.getSession();

		// retrieve the attribute from the session
		String username = (String)(session.getAttribute("user"));



		int reim_id = Integer.parseInt(request.getParameter("id"));
		String reimOwner = username;//request.getParameter("owner");
		//String reimResolver = request.getParameter("resolver");
		double reimAmount = Double.parseDouble(request.getParameter("amount"));
		String reimStatus = request.getParameter("status");
		app.reimbursementService.saveReim(reim_id, reimOwner, "", reimAmount, reimStatus);


	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("<a href='index.html'>Back</a><br>");
	//out.println(reimOwner+" "+username);
//	out.println("<a href='targetServlet'>Click Here to get the UserName</a><br>");
//	out.println("<a href='addReim.html'>Click Here to add Reimbursement</a><br>");
//	out.println("<a href='add.html'>Click Here to add/Register new employee</a><br>");
//	out.println("<a href='delete.html'>Click Here to delete employee</a><br>");
//	out.println("<a href='update.html'>Click Here to update employee</a><br><br>");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
