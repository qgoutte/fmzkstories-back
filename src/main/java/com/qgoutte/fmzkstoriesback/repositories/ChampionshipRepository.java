package com.qgoutte.fmzkstoriesback.repositories;

import com.qgoutte.fmzkstoriesback.entities.Championship;
import com.qgoutte.fmzkstoriesback.entities.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChampionshipRepository extends JpaRepository<Championship,Integer> {

    Optional<Championship> findChampionshipByName(String championshipName);

    List<Championship> findChampionshipByNation (Nation nation);

    Optional<List<Championship>> findChampionshipsByNation_Name (String name);

    Optional<List<Championship>> findChampionshipsByNameContaining (String championshipName);
}
