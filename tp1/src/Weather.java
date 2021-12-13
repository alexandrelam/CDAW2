

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp1.WeatherHandler;

/**
 * Servlet implementation class Weather
 */
@WebServlet("/Weather")
public class Weather extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private WeatherHandler weatherHandler;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Weather() {
        super();
        this.weatherHandler = new WeatherHandler();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    PrintWriter out = response.getWriter();
	    out.println("<h1>Liste des pays</h1>");
	    out.println("<form method='POST'>");
	    out.print("<input name='newTemperature'>");
	    out.println("<select name='countryIndex'>");
	    for(int i = 0; i<this.weatherHandler.getCountryHandlerList().size(); i++) {
	    	String name = this.weatherHandler.getCountryHandlerList().get(i).getCountryName();
	    	Integer temp = this.weatherHandler.getCountryHandlerList().get(i).getCountryTemp();
	    	out.println("<option value='" + i + "' name='" + name +"'>" + name + " - " + temp + "</option>");
	    }
	    out.println("</select>");
	    out.println("<button type='submit' value='countryIndex'>submit</button>");
	    out.println("</form>");
	 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String newTemp = request.getParameter("newTemperature");
		String countryIndex = request.getParameter("countryIndex");
		this.weatherHandler.getCountryHandlerList().get(Integer.parseInt(countryIndex)).setCountryTemp(Integer.parseInt(newTemp));
		 out.println("<h1>Liste des pays</h1>");
		    out.println("<form method='POST'>");
		    out.print("<input name='newTemperature'>");
		    out.println("<select name='countryIndex'>");
		    for(int i = 0; i<this.weatherHandler.getCountryHandlerList().size(); i++) {
		    	String name = this.weatherHandler.getCountryHandlerList().get(i).getCountryName();
		    	Integer temp = this.weatherHandler.getCountryHandlerList().get(i).getCountryTemp();
		    	out.println("<option value='" + i + "' name='" + name +"'>" + name + " - " + temp + "</option>");
		    }
		    out.println("</select>");
		    out.println("<button type='submit' value='countryIndex'>submit</button>");
		    out.println("</form>");
	}

}
