package Coditation.Coditation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("Coditation")
public class CoditationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoditationApplication.class, args);
	}

}
