package com.laurens.tul.model.service;

import com.laurens.tul.model.entities.Audience;
import com.laurens.tul.model.repositories.AudienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AudienceService {

    @Autowired
    public AudienceRepository audienceRepository;

    public List<Audience> getAllAudiences(){
        List<Audience> audiences;
        audiences = audienceRepository.findAll();
        return audiences;
    }

    public Audience saveAudience(Audience audience){
        return audienceRepository.save(audience);
    }

    public Audience updateAudience(Audience audience){
        Optional<Audience> updateAudience = audienceRepository.findById(audience.getId());
        if( !updateAudience.isPresent() ){
            return new Audience(000, "No existe", "No existe", 000, "No existe");
        }

        return audienceRepository.save(audience);
    }

    public String deleteAudience(Integer id){
        Optional<Audience> deleteAudience = audienceRepository.findById(id);
        if( !deleteAudience.isPresent() ){
            return "noexiste";
        }
        audienceRepository.delete(deleteAudience.get());
        return "eliminado";
    }

}
