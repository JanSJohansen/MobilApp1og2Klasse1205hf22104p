package dk.tec.jaj;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AnalyzeRequest 
{
	private MatchRequest matchLevel;
	private int elevId;

	public MatchRequest getMatch() 
	{ 
		return matchLevel; 
	}
	
	public int getId() 
	{ 
		return elevId; 
	}

	public AnalyzeRequest(String pathInfo) 
	{
		Matcher matcher = Pattern.compile("/Elev/([0-9]+)").matcher(pathInfo); // + 1-N tal
		
		if(matcher.find())
		{
			matchLevel = MatchRequest.ElevId;
			elevId = Integer.parseInt(matcher.group(1));
		}
		else 
		{
			matcher = Pattern.compile("/Elev").matcher(pathInfo);
			if(matcher.find())
			{
				matchLevel = MatchRequest.Elev;
			}
			else
			{
				matchLevel = MatchRequest.NoMatch;
			}
		}
	}
}






