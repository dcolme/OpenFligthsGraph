package Display.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class UrlToList {
	
    static List Aeropuertos  = getUrlContents("https://raw.githubusercontent.com/jpatokal/openflights/master/data/airports.dat");
    static List Rutas  = getUrlContents("https://raw.githubusercontent.com/jpatokal/openflights/master/data/routes.dat");
    static List Aerolineas = getUrlContents("https://raw.githubusercontent.com/jpatokal/openflights/master/data/airlines.dat"); 
    
	private static List getUrlContents(String theUrl)
	  {
	    List content = new ArrayList();

	    try
	    {
	      URL url = new URL(theUrl);
	      URLConnection urlConnection = url.openConnection();
	      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	      String line;
	      while ((line = bufferedReader.readLine()) != null)
	      {
	        content.add(line + "\n");
	      }
	      bufferedReader.close();
	    }
	    catch(Exception e)
	    {
	      e.printStackTrace();
	    }
	    return content;
	  }
	
}
