package com.qgoutte.fmzkstoriesback.controllers;

import com.qgoutte.fmzkstoriesback.entities.Club;
import com.qgoutte.fmzkstoriesback.exception.ResourceNotFoundException;
import com.qgoutte.fmzkstoriesback.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClubController {

    @Autowired
    private ClubRepository clubRepository;

    @GetMapping("/clubs")
    public List<Club> getAllClubs() { return clubRepository.findAll(); }

    @GetMapping("/clubs/{id}")
    public ResponseEntity<Club> getClubById(@PathVariable Integer id) throws ResourceNotFoundException {
        Club club = clubRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Club not found for this id :: " + id ));
        return ResponseEntity.ok().body(club);
    }

    @RequestMapping("/clubs/nation")
    public @ResponseBody ResponseEntity<List<Club>> getClubsByNation
            (@RequestParam(value="name") String nation) throws ResourceNotFoundException {
        List<Club> clubs=clubRepository.findClubsByNation_Name(nation).orElseThrow(() -> new ResourceNotFoundException("Club not found for this nation :: " +nation));
        return ResponseEntity.ok().body(clubs);
    }

    @GetMapping("/clubs/{name}")
    public ResponseEntity<Club> getClubByName(@PathVariable String name)
            throws ResourceNotFoundException {
        Club club = clubRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Club not found for this name :: " + name));
        return ResponseEntity.ok().body(club);
    }

    @RequestMapping("/clubs")
    public @ResponseBody ResponseEntity<List<Club>> getClubsNameContains
            (@RequestParam String name) throws ResourceNotFoundException {
        List<Club> clubs=clubRepository.findClubsByNameContaining(name)
                .orElseThrow(() -> new ResourceNotFoundException("No club contains this name :: " + name));
        return ResponseEntity.ok().body(clubs);
    }
}
