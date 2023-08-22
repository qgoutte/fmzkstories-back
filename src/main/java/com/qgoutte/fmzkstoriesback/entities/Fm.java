package com.qgoutte.fmzkstoriesback.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "fm_list")
public class Fm {
    private @Id @Column(name="fm_id") String id;
    private @Column(name="fm_name") String name;

    public Fm(){

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
