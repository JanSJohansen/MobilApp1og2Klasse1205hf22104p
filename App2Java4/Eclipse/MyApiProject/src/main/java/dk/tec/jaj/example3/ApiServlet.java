package dk.tec.jaj.example3;

import java.io.BufferedReader;
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
import dk.tec.jaj.DBTools;
import dk.tec.jaj.Elev;



//@WebServlet("/ApiServlet")
public class ApiServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, 
			             HttpServletResponse response) throws ServletException, IOException 
	{
		BufferedReader in = request.getReader();
		String json = in.readLine();
		System.out.println(json);
		
		ObjectMapper mapper = new ObjectMapper();
		
		Elev newElev = mapper.readValue(json, Elev.class);
		System.out.println(newElev.navn);
	
		
	}
	
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();		
		AnalyzeRequest analyze = new AnalyzeRequest(request.getPathInfo());
		
		
		ObjectMapper mapper = new ObjectMapper();
		DBTools db = new DBTools();
		
		switch(analyze.getMatch())
		{
			case ElevId:
			   int elevId = analyze.getId();
			   Elev elev = db.getElevById(elevId);
			   String json = mapper.writeValueAsString(elev);
			   out.print(json);
			  
			   break;
			   
			case Elev:
				//out.print(mapper.writeValueAsString(elever));
				 break;
				 
			case NoMatch:
				out.print("Match: NoMatch");
				break;
		}		
	}
}
