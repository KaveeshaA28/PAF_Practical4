package paflab4com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //Applying the endpoints through the annotation
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/") //endpoint is /
	public String rootEndpoint() {
		String message = "Hello World"; //Showing the output once the endpoint passed
		return message; //return the message to the web page
	}

	@GetMapping("/name") //endpoint is /name
	public String nameEndpoint() {
		String message = "Kaveesha"; //Showing the output once the endpoint passed
		return message; //return the message to the web page
	}

	// ------------------------------------------------
	// PRACTICAL 3 EXTENSION – Greeting Endpoints
	// ------------------------------------------------

	// TASK 1: Basic greeting
	// Access: http://localhost:8080/greet
	// Response: Welcome to Spring Boot!
	@GetMapping("/greet")
	public String greet() {
		return "Welcome to Spring Boot!";
	}

	// TASK 2 + EXTENSION: Personalized greeting with optional query parameter
	// Access: http://localhost:8080/greet/John
	// Response: Hello John! Welcome to Spring Boot!
	//
	// With query param: http://localhost:8080/greet/John?message=Good to see you!
	// Response: Hello John! Good to see you!
	@GetMapping("/greet/{name}")
	public String greetByName(
			@PathVariable String name,
			@RequestParam(required = false, defaultValue = "Welcome to Spring Boot!") String message) {

		return "Hello " + name + "! " + message;
	}

}
