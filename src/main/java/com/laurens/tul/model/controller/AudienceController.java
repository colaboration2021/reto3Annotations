package com.laurens.tul.model.controller;

import com.laurens.tul.model.entities.Audience;
import com.laurens.tul.model.service.AudienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/Audience")
public class AudienceController {

    @Autowired
    private AudienceService audienceService;

    @GetMapping()
    public List<Audience> getAllAudiences(){
        return audienceService.getAllAudiences();
    }

    @PostMapping()
    public Audience saveAudience(@RequestBody Audience audience){
        return audienceService.saveAudience(audience);
    }

    @PutMapping
    public Audience editAudience(@RequestBody Audience audience){
        return audienceService.updateAudience(audience);
    }

    @DeleteMapping
    public ResponseEntity deleteAudience(@RequestBody Audience audience){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(audienceService.deleteAudience(audience.getId()));
    }

}
