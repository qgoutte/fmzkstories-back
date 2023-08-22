package com.qgoutte.fmzkstoriesback.repositories;

import com.qgoutte.fmzkstoriesback.entities.Continent;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContinentRepository extends JpaRepository <Continent, String> {
}
