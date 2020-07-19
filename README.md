# Weather Report
Application which asks you your location and shows current Weather conditions.
We created application to fetch live weathers of location so Internet connection is required to achieve the goal of application
### How to build the source code
1)  We use openweather map to fetch live weather information. So First we need to create API ID by registering on https://openweathermap.org/price and copy the generated API ID and replace <b>XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</b> with generated API ID into [application.properties](src/main/resources/application.properties#L8)

2) We created maven based project so we need to install maven to build the source code

3) After Installing maven we just need to execute : mvn clean install; from root path of this source code

4) Maven install command will produce the artifact weather-report.jar into target folder 

5) I also uploaded generated weather-report.jar ( in case if we don't want build it using maven )

### Here are the steps to execute the module

1) Execute following commands with generated artifact with java 8 (preferable)
2) java -jar weather-report.jar 

##### Application will be deploy using default configuration that is 
##### http://localhost:4321/weather/

###### If we want to change the port or context path we can change into [application.properties](src/main/resources/application.properties)
