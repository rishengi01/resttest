package qa.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.mongodb.DBCollection;

import qa.main.Weather;

public class Cassandradbconnect {


	    //public static void main(String[] args) 
	    //{
	        String serverIp = "127.0.0.1";
	        String keyspace = "weatherspace";
	        String dbresp;
	        Object w;
	        
	        String cityvalue;
	        String Temperature;
	        String Humidity;
	        String WeatherDescription;
	        String WindSpeed;
	        String WindDirectionDegree;
	        
            Weather weatherbydb=new Weather();
	        
            
	        public Weather getdbdata()
	        {
	        	
	        Cluster cluster = Cluster.builder()
	                .addContactPoints(serverIp)
	                .build();

	        Session session = cluster.connect(keyspace);

	        String cqlStatement = "SELECT * FROM weather";
	        
	        for (Row row : session.execute(cqlStatement)) {
	        	dbresp=row.toString();
	            System.out.println(dbresp);
	            System.out.println(row);
	           
	            cityvalue=row.getString("city");
	            System.out.println(cityvalue); 
	            Temperature	=row.getString("temperature");
	            Humidity=row.getString("humidity");
	            WeatherDescription=row.getString("weatherdescription");
	            WindSpeed=row.getString("windspeed");
	            WindDirectionDegree=row.getString("winddirectiondegree");
	           
	            
	        
  	
	        	/*
	            w=row.getObject(0);
	            System.out.println(w);
	        	System.out.println(w);
	           //Gson lib from google , and use this Row object to convert it into json 
	            Weather w = new Weather();
	            w.setCity(city);
	            GsonBuilder builder = new GsonBuilder();
	            
	            Gson gson = builder.create(); 
	            String jsonString = gson.toJson(w); 
	            System.out.println("####################################");
	            System.out.println(jsonString);
	            //System.out.println(dbresp);
	             
	             */
	        }
	   
            
	        weatherbydb.setCity(cityvalue);	         
	        weatherbydb.setHumidity(Humidity);
	        weatherbydb.setTemperature(Temperature);
	        weatherbydb.setWeatherDescription(WeatherDescription);
	        weatherbydb.setWindSpeed(WindSpeed);
	        weatherbydb.setWindDirectionDegree(WindDirectionDegree);
	         
	        session.close();
	        
	        return weatherbydb;
	              
	       
	        }      
	    
}





