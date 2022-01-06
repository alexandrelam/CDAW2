package imt.nord.europe.hibernate.service;

import imt.nord.europe.hibernate.model.RegionModel;
import imt.nord.europe.hibernate.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RegionService {
    @Autowired
    private final RegionRepository regionRepository;

    public Iterable<RegionModel> findAll(){
        return regionRepository.findAll();
    }

    public Optional<RegionModel> findById(Long id){
        return regionRepository.findById(id);
    }

}
