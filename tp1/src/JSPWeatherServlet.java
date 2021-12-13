
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imt.nordeurope.douai.j2ee.tp.AlexandreLam.WeatherHandler;

/**
 * Servlet implementation class JSPWeatherServlet
 */
@WebServlet("/JSPWeather")
public class JSPWeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WeatherHandler weatherHandler;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JSPWeatherServlet() {
		super();
		this.weatherHandler = new WeatherHandler();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("weatherlist", this.weatherHandler.getCountryHandlerList());
		request.getRequestDispatcher("/WEB-INF/Weather.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("selectedIndex", request.getParameter("countryIndex"));
		String newTemp = request.getParameter("newTemperature");
		String countryIndex = request.getParameter("countryIndex");
		if (newTemp.length() != 0)
			this.weatherHandler.getCountryHandlerList().get(Integer.parseInt(countryIndex))
					.setCountryTemp(Integer.parseInt(newTemp));
		doGet(request, response);

	}

}
