package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import dataModel.Vendor;
import helper.YelpAPI;




@WebServlet("/Search")
public class Search extends HttpServlet  {
	private static final long serialVersionUID = 1L;

    public Search() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String category = request.getParameter("category");
		String location = request.getParameter("location");
		
		ArrayList<Vendor> vendorList = new ArrayList<Vendor>();
		
		try {
			vendorList = YelpAPI.createVendorObjects(YelpAPI.searchForVendors(category, location));
			request.setAttribute("vendors", vendorList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("search-results.jsp");
	        dispatcher.forward(request, response);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
