package com.qgoutte.fmzkstoriesback.repositories;

import com.qgoutte.fmzkstoriesback.entities.Continent;
import com.qgoutte.fmzkstoriesback.entities.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NationRepository extends JpaRepository<Nation, Integer> {

   Optional<List<Nation>> findNationsByContinent(Continent continent);

   Optional<Nation> findNationByName(String name);
}
