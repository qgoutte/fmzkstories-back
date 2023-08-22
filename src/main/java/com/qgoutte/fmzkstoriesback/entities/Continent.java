package com.qgoutte.fmzkstoriesback.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "continents_list")
public class Continent {
    private @Id @Column(name= "c_name") String  name;

    public Continent() {
    }

    public String getName() {
        return name;
    }

    public Continent(String name) {
        this.name = name;
    }
}
