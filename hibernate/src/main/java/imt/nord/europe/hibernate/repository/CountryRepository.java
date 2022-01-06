package imt.nord.europe.hibernate.repository;

import imt.nord.europe.hibernate.model.CountryModel;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<CountryModel, Long> {
}
