package ca.itacademy.barcelonactiva.maso.montserrat.s04.t01.n01.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/* @RestController annotation combines @Controller and @ResponseBody, which eliminates
 * the need to annotate every request handling method of the class with the @ResponseBody */

@RestController
public class HelloWorldController {

	@GetMapping("/HelloWorld")
	public String greet(@RequestParam(defaultValue = "UNKNOWN") String name) 
	{
		return "Hello, " + name + ". You're executing a Maven Project.";
	}
	
	@GetMapping({"/HelloWorld2", "/HelloWorld2/{name}"})
	public String greet2(@PathVariable(required = false) Optional<String> name) 
	{
		return "Hello, " + name.orElse("UNKNOWN") + ". You're executing a Maven Project.";
	}
}
