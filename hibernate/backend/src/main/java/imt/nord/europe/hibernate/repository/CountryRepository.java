package imt.nord.europe.hibernate.repository;

import imt.nord.europe.hibernate.model.CountryModel;
import imt.nord.europe.hibernate.model.RegionModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends CrudRepository<CountryModel, Long> {
    @Query(value = "SELECT DISTINCT country.countryId, country.name, country.president FROM `country` \n" +
            "INNER JOIN region ON countryId = region.country_id\n" +
            "WHERE region.temperature >= :minTemp\n", nativeQuery = true)
    List<CountryModel> findAllCountryWithRegionGreaterThanEqual(@Param("minTemp") String minTemperature);
}
