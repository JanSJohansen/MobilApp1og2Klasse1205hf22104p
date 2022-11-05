package dk.tec.jaj.example1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dk.tec.jaj.AnalyzeRequest;


//@WebServlet("/ApiServlet")
public class ApiServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) throws ServletException, IOException 
	{
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		//out.print("ContextPath: " + request.getContextPath());
		//out.print("\nServletPath: " + request.getServletPath());
		//out.print("\nPathInfo: " + request.getPathInfo());
		
		AnalyzeRequest analyze = new AnalyzeRequest(request.getPathInfo());
		
		switch(analyze.getMatch())
		{
			case ElevId:
			   int matchId = analyze.getId();
			   out.print("Match: Elev og Id = " + matchId);
			   break;
			   
			case Elev:
				 out.print("Match: Elev");
				 break;
				 
			case NoMatch:
				out.print("Match: NoMatch");
				break;
		}		
	}
}
