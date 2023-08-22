package com.qgoutte.fmzkstoriesback.controllers;

import com.qgoutte.fmzkstoriesback.entities.Continent;
import com.qgoutte.fmzkstoriesback.entities.Nation;
import com.qgoutte.fmzkstoriesback.exception.ResourceNotFoundException;
import com.qgoutte.fmzkstoriesback.repositories.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class NationController {
    @Autowired
    private NationRepository nationRepository;

    @GetMapping("/nations")
    public List<Nation> getAllNations(){
        return nationRepository.findAll();
    }

    @GetMapping("/nations/{id}")
    public ResponseEntity <Nation> getNationById(@PathVariable(value = "id")Integer nationId) throws ResourceNotFoundException{
        Nation nation = nationRepository.findById(nationId)
                .orElseThrow(()-> new ResourceNotFoundException("Continent not found for this id :: " + nationId));
        return ResponseEntity.ok().body(nation);
    }

    //TODO : Voir le lien pour mettre en param https://stackoverflow.com/questions/7021084/how-do-you-receive-a-url-parameter-with-a-spring-controller-mapping
    @GetMapping("/nations/continent={continent}")
    public ResponseEntity <List<Nation>> getNationByContinent(@PathVariable(value = "continent")String continentName) throws ResourceNotFoundException{
        List<Nation> nation = nationRepository.findNationsByContinent(new Continent(continentName))
                .orElseThrow(()-> new ResourceNotFoundException("Continent not found for this continent :: " + continentName));
        return ResponseEntity.ok().body(nation);
    }

    //TODO : Voir le lien pour mettre en param https://stackoverflow.com/questions/7021084/how-do-you-receive-a-url-parameter-with-a-spring-controller-mapping
    @GetMapping("/nations/name={name}")
    public ResponseEntity <Nation> getNationByName(@PathVariable(value = "name")String nationName) throws ResourceNotFoundException{
        Nation nation = nationRepository.findNationByName(nationName)
                .orElseThrow(()-> new ResourceNotFoundException("Continent not found for this name :: " + nationName));
        return ResponseEntity.ok().body(nation);
    }


}
