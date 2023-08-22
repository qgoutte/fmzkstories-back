package com.qgoutte.fmzkstoriesback.controllers;

import com.qgoutte.fmzkstoriesback.entities.Fm;
import com.qgoutte.fmzkstoriesback.exception.ResourceNotFoundException;
import com.qgoutte.fmzkstoriesback.repositories.FmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FmController {
    @Autowired
    private FmRepository fmRepository;

    @GetMapping("/fm")
    public List<Fm> getAllFm(){
        return fmRepository.findAll();
    }

    @GetMapping("/fm/{id}")
    public ResponseEntity <Fm> getFmById(@PathVariable (value = "id") String fmId) throws ResourceNotFoundException{
        Fm fm = fmRepository.findById(fmId).orElseThrow(() -> new ResourceNotFoundException("Fm not found for this id :: " + fmId));
        return ResponseEntity.ok().body(fm);
    }
}
