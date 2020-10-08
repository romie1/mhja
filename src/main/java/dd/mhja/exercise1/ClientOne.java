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
 * Servlet implementation class ClientOne
 */
@WebServlet("/client/one")
public class ClientOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(ClientAll.class);  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 LOG.trace("enter ClientOne Servlet");
		 
		 ClientDAO dao = new ClientDAO();
		 String parameter = request.getParameter("id");
		 try {
			 if(!parameter.isEmpty()) {
				 int id = Integer.parseInt(parameter);
				 request.setAttribute("client", dao.get(id));
				 request.getRequestDispatcher("/exercise1/client.jsp").forward(request, response);
			 }else{
				 request.getRequestDispatcher("/exercise1/clientHome.html").forward(request, response);
			 }
		 }catch(NumberFormatException e) {
			 request.getRequestDispatcher("/exercise1/clientHome.html").forward(request, response);
		 }
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
