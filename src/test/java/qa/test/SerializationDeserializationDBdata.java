package qa.test;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import qa.database.Cassandradbconnect;
import qa.main.Weather;

public class SerializationDeserializationDBdata {
	
	Cassandradbconnect dbcon=new Cassandradbconnect();
	
	@Test(priority=1)
	public void Serializationbydbconnect() throws JsonGenerationException, JsonMappingException, IOException
	{
		
		  
			Weather weatherbydbdata=dbcon.getdbdata();
			
			ObjectMapper mapper=new ObjectMapper();
			
			
		      // Java objects to JSON file
	        mapper.writeValue(new File("C:\\Users\\risgoyal1\\MobileAutomation\\resttest\\ExpectedJsons\\WeatherBydbdata.json"), weatherbydbdata);

	        
	        
	        /*
	        // Java objects to JSON string - compact-print
	        String jsonString = mapper.writeValueAsString(jsnstr);

	        System.out.println(jsonString);

	        // Java objects to JSON string - pretty-print
	        String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsnstr);

	        System.out.println(jsonInString2);
			
		*/
		
		
		
	}
	
	
	@Test(priority=2)
	public void DeserializeDBdata() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		 
		// JSON file to Java object
         Weather weather1 = mapper.readValue(new File("C:\\Users\\risgoyal1\\MobileAutomation\\resttest\\ExpectedJsons\\WeatherBydbdata.json"), Weather.class);

         // JSON string to Java object
         //jsonstring we have to fetch after get request(whether we use rest assured or anything else)
         String actualjsonInString = "{\"weatherDescription\":\"scattered clouds\",\"windDirectionDegree\":\"180 Degree\",\"city\":\"Hyderabad1\",\"humidity\":\"59 Percent\",\"windSpeed\":\"1.5 Km per hour\",\"temperature\":\"31.68 Degree celsius\"}";
         Weather weather2 = mapper.readValue(actualjsonInString, Weather.class);

         // compact print
         System.out.println(weather2);

         // pretty print
         String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(weather2);

         System.out.println(prettyStaff1);
         
         System.out.println("Expected city-"+weather1.getCity());
         System.out.println("Actual City-"+weather2.getCity());
         
         Assert.assertTrue(weather1.getCity().equals(weather2.getCity()));
		
		
	}
	

}
