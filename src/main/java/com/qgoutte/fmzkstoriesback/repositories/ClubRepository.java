package com.qgoutte.fmzkstoriesback.repositories;

import com.qgoutte.fmzkstoriesback.entities.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ClubRepository extends JpaRepository<Club, Integer> {
    Optional<Club> findByName(String clubName);

    Optional<Club> findById(Integer id);

    Optional<List<Club>> findClubsByNameContaining(String clubName);

    Optional<List<Club>> findClubsByNation_Name(String nation);
}
