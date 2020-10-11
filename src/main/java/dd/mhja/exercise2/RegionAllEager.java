package dd.mhja.exercise2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class RegionAllEager
 */
@WebServlet("/region/allEager")
public class RegionAllEager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(RegionAllEager.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.trace("enter RegionAllEager Servlet");

		RegionDAO dao = new RegionDAO();
		List<Region> regions = dao.readAllEager();
		request.setAttribute("regions", regions);
		request.getRequestDispatcher("/exercise2/regionsAll.jsp").forward(request, response);

	}

}
