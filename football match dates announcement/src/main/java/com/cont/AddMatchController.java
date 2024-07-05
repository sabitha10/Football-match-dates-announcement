
package com.cont;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cont.Match;
import com.cont.MatchDao;


@WebServlet("/AddMatchController")
public class AddMatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// retrieve data
		String title=request.getParameter("title").trim();
		String place=request.getParameter("place").trim();
		String date=request.getParameter("date").trim();
		
		
	
		ArrayList<String> list =new ArrayList<String>();
		if(title.length()==0)
			list.add("Enter title field");
		if(place.length()==0)
			list.add("Enter place field");
		
		
		
		if(!list.isEmpty())
		{
			request.setAttribute("errors",list);
			RequestDispatcher rd=request.getRequestDispatcher("AddMatchFormServlet");
			rd.forward(request, response);
			

		}
		Match m=new Match(title, place, date);
		MatchDao md=new MatchDao();
		md.storeData(m);
		RequestDispatcher rd1=request.getRequestDispatcher("Acknowledgement.html");
		rd1.forward(request, response);
		
			}

}