package com.qgoutte.fmzkstoriesback.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "nations_list")
public class Nation {
    private @Id @Column(name= "n_id") Integer id;

    private @Column(name = "n_name") String name;

    @ManyToOne
    @JoinColumn (name = "n_fk_continent", referencedColumnName = "c_name")
    private Continent continent;

    private @Column(name ="n_team_main_color") String teamMainColor;

    private @Column(name ="n_team_secondary_color") String teamSecondaryColor;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Continent getContinent() {
        return continent;
    }

    public Nation(String name) {
        this.name = name;
    }

    public Nation() {}
}
