package imt.nord.europe.hibernate;

import imt.nord.europe.hibernate.model.TemperatureModel;
import imt.nord.europe.hibernate.repository.TemperatureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class HibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Bean
	public CommandLineRunner factory(TemperatureRepository repository) {

		return (args) -> {
			repository.save(new TemperatureModel("France", 12));
			repository.save(new TemperatureModel("Allemagne", 15));
		    repository.save(new TemperatureModel("Angleterre", 5));

		};
	}
}
