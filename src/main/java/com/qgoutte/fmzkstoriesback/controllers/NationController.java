package com.qgoutte.fmzkstoriesback.controllers;

import com.qgoutte.fmzkstoriesback.entities.Continent;
import com.qgoutte.fmzkstoriesback.entities.Nation;
import com.qgoutte.fmzkstoriesback.exception.ResourceNotFoundException;
import com.qgoutte.fmzkstoriesback.repositories.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/nations/continent")
    public @ResponseBody ResponseEntity<List<Nation>> getNationsByContinent(
            @ModelAttribute(value="continent") String continent) {
        List<Nation> nations = nationRepository.findNationsByContinent(new Continent(continent));
        return ResponseEntity.ok().body(nations);
    }

    @GetMapping("/nations/{name}")
    public ResponseEntity<Nation> getNationByName(@PathVariable(value = "name") String nationName) throws ResourceNotFoundException {
        Nation nation = nationRepository.findNationByName(nationName)
                .orElseThrow(() -> new ResourceNotFoundException("Nation not found for this name :: " + nationName));
        return ResponseEntity.ok().body(nation);
    }


}
