package com.qgoutte.fmzkstoriesback.controllers;

import com.qgoutte.fmzkstoriesback.entities.Championship;
import com.qgoutte.fmzkstoriesback.exception.ResourceNotFoundException;
import com.qgoutte.fmzkstoriesback.repositories.ChampionshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ChampionshipController {

    @Autowired
    private ChampionshipRepository championshipRepository;

    @GetMapping("/championships")
    public List<Championship> getAllChampionships() { return championshipRepository.findAll(); }

    @GetMapping("/championships/{id}")
    public ResponseEntity<Championship> getChampionshipById(@PathVariable(value = "id") Integer champId) throws ResourceNotFoundException {
        Championship championship = championshipRepository.findById(champId).orElseThrow(() -> new ResourceNotFoundException("Championship not found for this id :: " + champId));
        return ResponseEntity.ok().body(championship);
    }

    @RequestMapping("/championships/nation")
    public @ResponseBody ResponseEntity<List<Championship>> getChampionshipsByNationName
            (@RequestParam(value = "name") String nation) throws ResourceNotFoundException {
        List<Championship> championships= championshipRepository.findChampionshipsByNation_Name(nation).orElseThrow(() -> new ResourceNotFoundException("Championships not found for nation named :: " + nation));
        return ResponseEntity.ok().body(championships);
    }

    @GetMapping("/championships/{name}")
    public ResponseEntity<Championship> getChampionshipByName(@PathVariable(value = "name") String name) throws ResourceNotFoundException {
        Championship championship = championshipRepository.findChampionshipByName(name).orElseThrow(() -> new ResourceNotFoundException("Championship not found for this name :: " + name));
        return ResponseEntity.ok().body(championship);
    }

    @RequestMapping("/championships")
    public @ResponseBody ResponseEntity<List<Championship>> getChampionshipsNameContains
            (@RequestParam(value = "name") String name) throws ResourceNotFoundException {
        List<Championship> championships=championshipRepository.findChampionshipsByNameContaining(name)
                .orElseThrow(()-> new ResourceNotFoundException("No championship contains this name :: " + name));
        return ResponseEntity.ok().body(championships);
    }

    /*    @RequestMapping ("/championships/nation")
    public @ResponseBody ResponseEntity<List<Championship>> getChampionshipsByNation
            (@RequestParam(value = "nation") String nation) {
        List<Championship> championships = championshipRepository.findChampionshipByNation(new Nation(nation));
        return ResponseEntity.ok().body(championships);
    }*/

}
