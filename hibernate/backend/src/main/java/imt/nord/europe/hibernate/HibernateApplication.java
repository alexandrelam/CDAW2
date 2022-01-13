package imt.nord.europe.hibernate;

import imt.nord.europe.hibernate.model.CountryModel;
import imt.nord.europe.hibernate.model.RegionModel;
import imt.nord.europe.hibernate.model.TemperatureModel;
import imt.nord.europe.hibernate.repository.CountryRepository;
import imt.nord.europe.hibernate.repository.RegionRepository;
import imt.nord.europe.hibernate.repository.TemperatureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;

@SpringBootApplication
@EnableWebMvc
public class HibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Bean
	public CommandLineRunner factory(TemperatureRepository repository, CountryRepository countryRepository, RegionRepository regionRepository) {
		return (args) -> {
			repository.save(new TemperatureModel("France", 12));
			repository.save(new TemperatureModel("Allemagne", 15));
		    repository.save(new TemperatureModel("Angleterre", 5));

			CountryModel france = countryRepository.save(new CountryModel("France", "Macron", "https://cdn.pixabay.com/photo/2013/07/12/17/17/france-151928_960_720.png"));
			regionRepository.save(new RegionModel("IDF", 15, france));
			regionRepository.save(new RegionModel("Nord", 5, france));
			regionRepository.save(new RegionModel("Sud", 33, france));

			CountryModel allemagne = countryRepository.save(new CountryModel("Allemagne", "Pas Merkel", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Flag_of_Germany.svg/2560px-Flag_of_Germany.svg.png"));
			regionRepository.save(new RegionModel("Sud", -15, allemagne));
			regionRepository.save(new RegionModel("Nord", 11, allemagne));
		};
	}
}
