package dd.mhja.exercise1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class ClientDeletion
 */
@WebServlet("/client/delete")
public class ClientDeletionSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(ClientCreationSrv.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.debug("Enter ClientDeletionSrv Servlet");
		
		ClientDAO dao = new ClientDAO();
		String parameter = request.getParameter("id");
		try {
			Integer id = Integer.valueOf(parameter);
			if(id != null ) {
				request.setAttribute("id", id);
				request.getRequestDispatcher("/exercise1/clientDeleted.html").forward(request, response);
			}else {
				request.getRequestDispatcher("/exercise1/clientHome.html").forward(request, response);
			}
		} catch (NumberFormatException nfe) {
			request.getRequestDispatcher("/exercise1/clientHome.html").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
