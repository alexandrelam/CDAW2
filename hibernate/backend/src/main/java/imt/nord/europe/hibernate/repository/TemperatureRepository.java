package imt.nord.europe.hibernate.repository;

import imt.nord.europe.hibernate.model.TemperatureModel;
import org.springframework.data.repository.CrudRepository;

public interface TemperatureRepository extends CrudRepository<TemperatureModel, Long> {

    TemperatureModel findFirstByCountry(String country);

    TemperatureModel findById(long id);
}