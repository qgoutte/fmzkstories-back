package com.qgoutte.fmzkstoriesback.controllers;

import com.qgoutte.fmzkstoriesback.entities.Continent;
import com.qgoutte.fmzkstoriesback.exception.ResourceNotFoundException;
import com.qgoutte.fmzkstoriesback.repositories.ContinentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ContinentController {
    @Autowired
    private ContinentRepository continentRepository;

    @GetMapping("/continents")
    public List<Continent> getAllContinents(){
        return continentRepository.findAll();
    }

    @GetMapping("/continents/{name}")
    public ResponseEntity <Continent> getContinentById(@PathVariable(value ="name") String continentName) throws ResourceNotFoundException {
        Continent continent = continentRepository.findById(continentName)
                .orElseThrow(() -> new ResourceNotFoundException("Continent not found for this id :: " + continentName));
        return ResponseEntity.ok().body(continent);
    }
}
