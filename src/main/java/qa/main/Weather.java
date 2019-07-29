package qa.main;

public class Weather {
	
	private String City;

    private String Temperature;

    private String Humidity;

    private String WeatherDescription;

    private String WindSpeed;

    private String WindDirectionDegree;

    public void setCity(String City){
        this.City = City;
    }
    public String getCity(){
        return this.City;
    }
    public void setTemperature(String Temperature){
        this.Temperature = Temperature;
    }
    public String getTemperature(){
        return this.Temperature;
    }
    public void setHumidity(String Humidity){
        this.Humidity = Humidity;
    }
    public String getHumidity(){
        return this.Humidity;
    }
    public void setWeatherDescription(String WeatherDescription){
        this.WeatherDescription = WeatherDescription;
    }
    public String getWeatherDescription(){
        return this.WeatherDescription;
    }
    public void setWindSpeed(String WindSpeed){
        this.WindSpeed = WindSpeed;
    }
    public String getWindSpeed(){
        return this.WindSpeed;
    }
    public void setWindDirectionDegree(String WindDirectionDegree){
        this.WindDirectionDegree = WindDirectionDegree;
    }
    public String getWindDirectionDegree(){
        return this.WindDirectionDegree;
    }


}
