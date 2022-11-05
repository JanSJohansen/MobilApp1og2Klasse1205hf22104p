package dk.tec.jaj.example2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import dk.tec.jaj.AnalyzeRequest;
import dk.tec.jaj.Elev;



//@WebServlet("/ApiServlet")
public class ApiServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();		
		AnalyzeRequest analyze = new AnalyzeRequest(request.getPathInfo());
		
		ArrayList<Elev> elever = new ArrayList<Elev>();
		elever.add(new Elev(1000, "Robin", "Quismester torsdag i ulige uger")); // Cafe Strandlyst
		elever.add(new Elev(1001, "Afrina", "Mor er husmor"));
		elever.add(new Elev(1002, "Emil", "Gamer og lidt dygtig"));
		elever.add(new Elev(1003, "Oliver", "Pumber jern"));
		
		ObjectMapper mapper = new ObjectMapper();
		
		switch(analyze.getMatch())
		{
			case ElevId:
			   int elevId = analyze.getId();
			   Elev elev = elever.get(elevId);
			   String json = mapper.writeValueAsString(elev);
			   out.print(json);
			  
			   break;
			   
			case Elev:
				out.print(mapper.writeValueAsString(elever));
				 break;
				 
			case NoMatch:
				out.print("Match: NoMatch");
				break;
		}		
	}
}
