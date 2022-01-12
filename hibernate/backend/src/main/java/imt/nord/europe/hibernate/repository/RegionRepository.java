package imt.nord.europe.hibernate.repository;

import imt.nord.europe.hibernate.model.CountryModel;
import imt.nord.europe.hibernate.model.RegionModel;
import org.springframework.data.repository.CrudRepository;

public interface RegionRepository  extends CrudRepository<RegionModel, Long> {
    RegionModel findById(long id);
    Iterable<RegionModel> findAllByCountry(CountryModel country);
}
