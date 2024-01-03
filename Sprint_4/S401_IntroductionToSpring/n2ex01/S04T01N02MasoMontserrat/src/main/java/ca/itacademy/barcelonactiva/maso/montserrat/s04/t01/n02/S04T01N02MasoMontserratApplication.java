package ca.itacademy.barcelonactiva.maso.montserrat.s04.t01.n02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"ca.itacademy.barcelonactiva.maso.montserrat.s04.t01.n02.controllers"})
public class S04T01N02MasoMontserratApplication {

	public static void main(String[] args) {
		SpringApplication.run(S04T01N02MasoMontserratApplication.class, args);
	}

}
