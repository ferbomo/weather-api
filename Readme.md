# Weather service
Please create a Web Application which should:  Accept a city name via REST API 

Get the current weather for the city name using the OpenWeather API.

## Strategy
I've created a Maven project, so it's needed maven 3.x.x and Java 8 to run the app.

I implemented the api using hexagonal architecture, or ports and adapters architectural pattern.
As far as I understand it, the domain it's my app and is only accessible using interfaces, that are implemented
by the adapters. The app interface are the primary ports and adapters and when the app needs some resource uses the secondary ones.
The app has only one use case that is retrieve weather information from a web service and return some part of this info.
So, in the use case, we get the weather info from the web service, convert it and finally return it as a json response.
Added cache management.
Only usecase class is unit tested, and there is a small controller test.
I would add more unit tests trying to reach all corner cases.
Also check why the json entity WeatherDto is impossible to deserialize.



## Execution
In the main folder, run: ./run.sh. 

If it doesn't work, try to give permissions to the .sh file using: chmod u+x

In the browser, go to http://localhost:8080/swagger-ui.html, and you will find the swagger page to test
easily the endpoint.