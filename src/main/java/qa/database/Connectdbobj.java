package qa.database;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.cassandra.db.rows.Row;
import org.apache.cassandra.utils.OutputHandler.SystemOutput;
import org.json.simple.JSONArray;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import qa.main.Weather;

public class Connectdbobj {

	//public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		
		
		
		Cassandradbconnect dbcon=new Cassandradbconnect();
	  
		Weather weatherbydbdata=dbcon.getdbdata();
		
		ObjectMapper mapper=new ObjectMapper();
		
		
	      // Java objects to JSON file
      //  mapper.writeValue(new File("C:\\Users\\risgoyal1\\MobileAutomation\\resttest\\ExpectedJsons\\WeatherBydbdata.json"), weatherbydbdata);

        
        
        /*
        // Java objects to JSON string - compact-print
        String jsonString = mapper.writeValueAsString(jsnstr);

        System.out.println(jsonString);

        // Java objects to JSON string - pretty-print
        String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsnstr);

        System.out.println(jsonInString2);
		
	*/	
		

	

}
