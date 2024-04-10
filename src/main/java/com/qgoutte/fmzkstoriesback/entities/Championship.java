package com.qgoutte.fmzkstoriesback.entities;

import jakarta.persistence.*;


@Entity
@Table (name = "championships_list")
public class Championship {
    private @Id @Column(name = "ch_id") Integer id;

    private @Column(name = "ch_name") String name;

    private @Column(name = "ch_level") Integer level;

    @ManyToOne
    @JoinColumn (name="ch_fk_nation_id", referencedColumnName = "n_id")
    private Nation nation;

}
