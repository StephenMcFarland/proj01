
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.proj01.models.Reimbursement;
import com.proj01.services.PostgresConnector;
import com.proj01.services.ReimbursementService;

@WebServlet("/ReimGetReimsByEmp")
public class ReimGetReimsByEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PostgresConnector connector;
	private ReimbursementService reimbursementService;

	public ReimGetReimsByEmpServlet() {
		this.connector = new PostgresConnector();
		this.reimbursementService = new ReimbursementService(this.connector);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ReimGetReimsByEmpServlet app = new ReimGetReimsByEmpServlet();

		

		String username = request.getParameter("user");

		List<Reimbursement> reimbursements = app.reimbursementService.getReimsByEmpAll(username);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='index.html'>Back</a><br>");

		out.println("<body bgcolor='aliceblue' style='font-family:verdana'>");
		out.println("<h2>Reimbursements</h2>");
		out.println(
				"<table cellpadding='6'><tr><td></td><td> <b>id</b></td><td><b>Owner</b></td><td><b>Resolver</b></td><td><b>Amount</b></td><td><b>Status</b></td></tr>");

		for (Reimbursement r : reimbursements) {

			out.println("<tr><td><b>Reimbursement</b></td><td bgcolor='#FFCCFC'>" + r.getReimId()
					+ "</td><td bgcolor='#FFFD90'>" + r.getReimOwner() + "</td><td>" + r.getReimResolver()
					+ "</td><td bgcolor='#33FF0F'>" + r.getReimAmount() + "</td><td>" + r.getReimStatus()
					+ "</td></tr>");
			// out.println(e.getUserId()+" &emsp;" +e.getEmpName()+"&emsp;
			// "+e.getEmpPhone()+" &emsp;"+e.getEmpAddress()+"&emsp; "+e.getEmail());

		}
		out.println("</table>");

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
