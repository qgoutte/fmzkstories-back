package com.qgoutte.fmzkstoriesback.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "clubs_list")
public class Club {
    private @Id @Column(name = "cl_id") Integer id;

    private @Column (name = "cl_name") String name;

    private @Column (name = "cl_logo") String logo;

    @ManyToOne
    @JoinColumn (name = "cl_fk_nation_id", referencedColumnName = "n_id")
    private Nation nation;

    private @Column (name ="cl_main_color") String mainColor;

    private @Column (name = "cl_secondary_color") String secondaryColor;

}
